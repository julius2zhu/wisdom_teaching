package com.julius.wisdom_teaching.repository;

import com.julius.wisdom_teaching.domain.entity.Course;

import java.util.List;

/**
 * author julius.zhu
 * date   2019/9/17
 * time   8:50
 * describe:
 * 课程信息管理mapper接口
 */
public interface CourseManageMapper {
    /**
     * 根据条件查询课程信息
     * @param condition 课程信息对象
     * @return
     */
    List<Course> selectCourse(Course condition);
}
