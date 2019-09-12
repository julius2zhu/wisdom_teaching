package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.HomeWork;

import java.util.Map;

/**
 * author julius.zhu
 * date   2019/9/12
 * time   12:54
 * describe:
 * 作业管理业务层
 */
public interface HomeWorkService {
    /**
     * 根据教师名称查询
     *
     * @param homeWork
     * @return
     */
    Map<String, Object> selectHomeWorkByTeacherName(HomeWork homeWork);
}
