package com.julius.wisdom_teaching.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.julius.wisdom_teaching.domain.entity.HomeWork;
import com.julius.wisdom_teaching.domain.entity.HomeWorkState;
import com.julius.wisdom_teaching.domain.entity.User;
import com.julius.wisdom_teaching.repository.HomeWorkMapper;
import com.julius.wisdom_teaching.repository.HomeWorkStateMapper;
import com.julius.wisdom_teaching.repository.StudentUserMapper;
import com.julius.wisdom_teaching.repository.UserMapper;
import com.julius.wisdom_teaching.util.SelectResultWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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
    private UserMapper userMapper;
    @Autowired
    private StudentUserMapper studentUserMapper;
    @Autowired
    private HomeWorkStateMapper homeWorkStateMapper;

    @Override
    public Map<String, Object> selectHomeWorkByTeacherName(HomeWork homeWork) {
        //获取下当前页和每页显示的条数
        PageHelper.startPage(homeWork.getCurrentPage(), homeWork.getCount());
        //必须紧跟查询条件
        return SelectResultWrap.resultWrap(homeWorkMapper.selectHomeWorkByTeacherName(homeWork.getTeacherName()));
    }

    @Override
    public String delete(Integer id) {
        return this.homeWorkMapper.delete(id) > 0 ? "成功" : "失败";
    }

    @Override
    public Map<String, Object> selectTaskSubmitState(User user) {
        //根据用户名查看学生id
        //查询用户id
        Integer userId = userMapper.findUserByUsername(user.getUsername()).getId();
        //根据用户id获取学生id
        Integer studentId = studentUserMapper.selectStudentUserInfoByUserId(userId);
        PageHelper.startPage(user.getCurrentPage(), user.getCount());
        return SelectResultWrap.resultWrap(homeWorkStateMapper.selectTaskSubmitState(studentId));
    }

    @Override
    public Map<String, Object> studentSubmitTaskRead(HomeWorkState homeWorkState) {
        PageHelper.startPage(homeWorkState.getCurrentPage(), homeWorkState.getCount());
        return SelectResultWrap.resultWrap(homeWorkStateMapper.studentSubmitTaskRead(homeWorkState.getTeacherName()));
    }

    @Override
    public String studentSubmitTaskCorrect(HomeWorkState homeWorkState) {
        return this.homeWorkStateMapper.
                studentSubmitTaskCorrect(homeWorkState) > 0 ? "成功" : "失败";
    }

    @Override
    public Map<String, Object> studentCheckTaskScore(User user) {
        PageHelper.startPage(user.getCurrentPage(), user.getCount());
        return SelectResultWrap.resultWrap(homeWorkStateMapper.studentCheckTaskScore(user.getUsername()));
    }
}
