package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.StudentInfo;
import com.julius.wisdom_teaching.domain.entity.StudentUser;
import com.julius.wisdom_teaching.repository.StudentManageMapper;
import com.julius.wisdom_teaching.repository.StudentUserMapper;
import com.julius.wisdom_teaching.repository.UserMapper;
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
        //添加之前判断该教师是否存在该生信息,存在则提示

        return null;
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

    @Override
    public Integer findStudentNumberByUsername(String username) {
        return studentManageMapper.findStudentNumberByUsername(username);
    }

    @Override
    public int register(Integer number, Integer userId) {
        if (studentManageMapper.numberExists(number) > 0) {
            return -1;
        }
        return studentManageMapper.register(number, userId);
    }

    @Override
    public void updateStudentInfo(StudentInfo studentInfo) {
        studentManageMapper.updateStudentInfo(studentInfo);
    }
}
