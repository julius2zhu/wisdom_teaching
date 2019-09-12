package com.julius.wisdom_teaching.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.julius.wisdom_teaching.domain.entity.HomeWork;
import com.julius.wisdom_teaching.domain.entity.StudentInfo;
import com.julius.wisdom_teaching.repository.HomeWorkMapper;
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
}
