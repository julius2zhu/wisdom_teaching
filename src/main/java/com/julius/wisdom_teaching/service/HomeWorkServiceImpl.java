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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author julius.zhu
 * date   2019/9/12
 * time   12:54
 * describe:
 */
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
        List<HomeWork> homeWorkList = homeWorkMapper.selectHomeWorkByTeacherName(homeWork.getTeacherName());
        //包装下
        PageInfo<HomeWork> pageInfo = new PageInfo<>(homeWorkList);
        Map<String, Object> map = new HashMap<>();
        //存放相关的分页信息
        homeWork.setTotalPage(pageInfo.getPages());
        homeWork.setTotalCount((int) pageInfo.getTotal());
        map.put("pageInfo", homeWork);
        //存放数据
        map.put("data", pageInfo.getList());
        return map;
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
        //获取下当前页和每页显示的条数
        PageHelper.startPage(user.getCurrentPage(), user.getCount());
        //必须紧跟查询条件
        List<HomeWorkState> homeWorkStateList = homeWorkStateMapper.selectTaskSubmitState(studentId);
        //包装下
        PageInfo<HomeWorkState> pageInfo = new PageInfo<>(homeWorkStateList);
        Map<String, Object> map = new HashMap<>();
        //存放相关的分页信息
        HomeWorkState homeWorkState = new HomeWorkState();
        homeWorkState.setTotalPage(pageInfo.getPages());
        homeWorkState.setTotalCount((int) pageInfo.getTotal());
        map.put("pageInfo", homeWorkState);
        //存放数据
        map.put("data", pageInfo.getList());
        return map;
    }

    @Override
    public Map<String, Object> studentSubmitTaskRead(HomeWorkState homeWorkState) {
        PageHelper.startPage(homeWorkState.getCurrentPage(), homeWorkState.getCount());
        //必须紧跟查询条件
        List<HomeWorkState> homeWorkStateList = homeWorkStateMapper.studentSubmitTaskRead(homeWorkState.getTeacherName());
        //包装下
        PageInfo<HomeWorkState> pageInfo = new PageInfo<>(homeWorkStateList);
        Map<String, Object> map = new HashMap<>();
        //存放相关的分页信息
        homeWorkState.setTotalPage(pageInfo.getPages());
        homeWorkState.setTotalCount((int) pageInfo.getTotal());
        map.put("pageInfo", homeWorkState);
        //存放数据
        map.put("data", pageInfo.getList());
        return map;
    }

    @Override
    public String studentSubmitTaskCorrect(HomeWorkState homeWorkState) {
        return this.homeWorkStateMapper.
                studentSubmitTaskCorrect(homeWorkState) > 0 ? "成功" : "失败";
    }

    @Override
    public Map<String, Object> studentCheckTaskScore(User user) {
        PageHelper.startPage(user.getCurrentPage(), user.getCount());
        //必须紧跟查询条件
        List<HomeWorkState> homeWorkStateList = homeWorkStateMapper.studentCheckTaskScore(user.getUsername());
        //包装下
        PageInfo<HomeWorkState> pageInfo = new PageInfo<>(homeWorkStateList);
        Map<String, Object> map = new HashMap<>();
        //存放相关的分页信息
        user.setTotalPage(pageInfo.getPages());
        user.setTotalCount((int) pageInfo.getTotal());
        map.put("pageInfo", user);
        //存放数据
        map.put("data", pageInfo.getList());
        return map;
    }
}
