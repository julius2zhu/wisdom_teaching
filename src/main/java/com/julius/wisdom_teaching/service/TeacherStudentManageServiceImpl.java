package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.StudentInfo;
import com.julius.wisdom_teaching.repository.TeacherStudentManageMapper;
import com.julius.wisdom_teaching.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author julius.zhu
 * date   2019/9/22
 * time   13:03
 * describe:
 */
@Transactional
@Service
public class TeacherStudentManageServiceImpl implements TeacherStudentManageService {
    @Autowired
    private TeacherStudentManageMapper teacherStudentManageMapper;

    @Override
    public String add(StudentInfo studentInfo) {
        //检查是否已经存在该条数据
        if (teacherStudentManageMapper.selectExistsByUserId(studentInfo) > 0) {
            return CommonResult.INFO_EXIST;
        }
        return teacherStudentManageMapper.add(studentInfo)
                > 0 ? CommonResult.SUCCESS : CommonResult.FAIL;
    }

    @Override
    public String update(StudentInfo studentInfo) {
        return teacherStudentManageMapper.update(studentInfo)
                > 0 ? CommonResult.SUCCESS : CommonResult.FAIL;
    }

    @Override
    public String delete(Integer id) {
        return teacherStudentManageMapper.delete(id)
                > 0 ? CommonResult.SUCCESS : CommonResult.FAIL;
    }

    @Override
    public void importStudentInfo(List<StudentInfo> studentInfos) {
        for (StudentInfo studentInfo : studentInfos) {
            //检查是否已经存在该条数据,存在则跳过本次插入
            if (teacherStudentManageMapper.selectExistsByUserId(studentInfo) > 0) {
                continue;
            }
            //插入学生数据
            teacherStudentManageMapper.add(studentInfo);
        }
    }
}
