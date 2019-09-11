package com.julius.wisdom_teaching.service;
import com.julius.wisdom_teaching.domain.entity.StudentInfo;
import com.julius.wisdom_teaching.repository.StudentManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * author julius.zhu
 * date   2019/5/30
 * time   23:07
 * describe:
 * 学生信息维护业务层接口实现类
 */
@Service
public class StudentManageServiceImpl implements StudentManageService {
    @Autowired
    private StudentManageMapper manageMapper;

    @Override
    public Integer add(StudentInfo studentInfo) {
        return manageMapper.add(studentInfo);
    }

    @Override
    public Integer insertStudentInfo(List<StudentInfo> students) {
        return manageMapper.insertStudentInfo(students);
    }

    @Override
    public Integer update(StudentInfo studentInfo) {
        return manageMapper.update(studentInfo);
    }

    @Override
    public Integer delete(Integer id) {
        return manageMapper.delete(id);
    }
}
