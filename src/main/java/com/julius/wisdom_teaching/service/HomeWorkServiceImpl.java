package com.julius.wisdom_teaching.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.julius.wisdom_teaching.domain.entity.HomeWork;
import com.julius.wisdom_teaching.domain.entity.HomeWorkState;
import com.julius.wisdom_teaching.domain.entity.User;
import com.julius.wisdom_teaching.repository.HomeWorkMapper;
import com.julius.wisdom_teaching.repository.HomeWorkStateMapper;
import com.julius.wisdom_teaching.util.SelectResultWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * author julius.zhu
 * date   2019/9/12
 * time   12:54
 * describe:
 */
@Transactional
@Service
public class HomeWorkServiceImpl implements HomeWorkService {
    @Autowired
    private HomeWorkMapper homeWorkMapper;
    @Autowired
    private HomeWorkStateMapper homeWorkStateMapper;
    private final TeacherStudentManageService teacherStudentManageService;
    private StudentManageService studentManageService;

    @Autowired
    public HomeWorkServiceImpl(TeacherStudentManageService teacherStudentManageService,
                               StudentManageService studentManageService) {
        this.teacherStudentManageService = teacherStudentManageService;
        this.studentManageService = studentManageService;
    }

    @Override
    public Map<String, Object> selectHomeWorkByUserId(HomeWork homeWork) {
        //获取下当前页和每页显示的条数
        PageHelper.startPage(homeWork.getCurrentPage(), homeWork.getCount());
        //必须紧跟查询条件
        return SelectResultWrap.resultWrap(homeWorkMapper.selectHomeWorkByUserId(homeWork));
    }

    @Override
    public String delete(Integer id) {
        return this.homeWorkMapper.delete(id) > 0 ? "成功" : "失败";
    }

    @Override
    public Map<String, Object> selectTaskSubmitState(User user) {
        //根据用户名查询学生学号
        Integer studentNumber =
                studentManageService.findStudentNumberByUsername(user.getUsername());
        PageHelper.startPage(user.getCurrentPage(), user.getCount());
        return SelectResultWrap.
                resultWrap(homeWorkStateMapper.selectTaskSubmitState(studentNumber));
    }

    @Override
    public Map<String, Object> studentSubmitTaskRead(HomeWorkState homeWorkState) {
        PageHelper.startPage(homeWorkState.getCurrentPage(), homeWorkState.getCount());
        return SelectResultWrap.resultWrap(homeWorkStateMapper.studentSubmitTaskRead(homeWorkState));
    }

    @Override
    public String studentSubmitTaskCorrect(HomeWorkState homeWorkState) {
        return this.homeWorkStateMapper.
                studentSubmitTaskCorrect(homeWorkState) > 0 ? "成功" : "失败";
    }

    @Override
    public Map<String, Object> studentCheckTaskScore(User user) {
        //获取到该生学号信息
        Integer number = studentManageService.findStudentNumberByUsername(user.getUsername());
        PageHelper.startPage(user.getCurrentPage(), user.getCount());
        //根据该生学号信息去查询该生属于所有教师的下面学生id
        return SelectResultWrap.resultWrap(homeWorkStateMapper.studentCheckTaskScore(number));
    }
}
