package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.Course;

import java.util.Map;

/**
 * author julius.zhu
 * date   2019/9/17
 * time   8:45
 * describe:
 * 课程信息管理业务层
 */
public interface CourseService {
    /**
     * 根据课程信息对象去查询
     *
     * @param condition 条件信息
     * @return
     */
    Map<String, Object> selectCourse(Course condition);
}
