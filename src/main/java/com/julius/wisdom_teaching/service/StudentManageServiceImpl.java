package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.StudentInfo;
import com.julius.wisdom_teaching.domain.entity.StudentUser;
import com.julius.wisdom_teaching.domain.entity.User;
import com.julius.wisdom_teaching.repository.StudentManageMapper;
import com.julius.wisdom_teaching.repository.StudentUserMapper;
import com.julius.wisdom_teaching.repository.UserMapper;
import com.julius.wisdom_teaching.util.EncryptUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author julius.zhu
 * date   2019/5/30
 * time   23:07
 * describe:
 * 学生信息维护业务层接口实现类
 */
@Transactional
@Service
public class StudentManageServiceImpl implements StudentManageService {
    @Autowired
    private StudentManageMapper studentManageMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentUserMapper studentUserMapper;

    @Override
    public Integer add(StudentInfo studentInfo) {
        //分步骤操作
        //根据学生学号判断,该学生已经存在则直接插入student_user表,建立联系即可
        StudentUser studentUser = studentManageMapper.selectStudentIdAndUserIdByNumber(studentInfo.getNumber());
        //有该生信息,直接添加
        if (studentUser != null) {
            return studentManageMapper.addStudentUser(studentUser.getStudentId(),
                    studentUser.getUserId(), studentInfo.getTeacherName());
        }
        //1.首先插入student表
        studentManageMapper.add(studentInfo);
        //获取返回自增长的主键插入到student_user表中
        Integer studentId = studentInfo.getId();
        //2.插入user表
        User user = new User();
        user.setName(studentInfo.getName());
        user.setUsername(studentInfo.getNumber());
        user.setPassword(EncryptUtil.encrypt(studentInfo.getNumber(), studentInfo.getNumber(), 3));
        user.setRole("0");
        userMapper.addOne(user);
        Integer userId = user.getId();
        //建立联系
        return studentManageMapper.addStudentUser(studentId, userId, studentInfo.getTeacherName());
    }

    @Override
    public Integer insertStudentInfo(List<StudentInfo> students) {
        return studentManageMapper.insertStudentInfo(students);
    }

    @Override
    public Integer update(StudentInfo studentInfo) {
        //根据传递的student_user中id查询该学生的student_id以及user_id
        //接着执行两条update语句
        StudentUser studentUser = studentUserMapper.selectStudentUserInfo(studentInfo.getId());
        studentInfo.setId(studentUser.getStudentId());
        studentManageMapper.update(studentInfo);
        studentInfo.setId(studentUser.getUserId());
        return userMapper.updateStudent(studentInfo);
    }

    @Override
    public Integer delete(Integer id) {
        return studentManageMapper.delete(id);
    }
}
