package com.julius.wisdom_teaching.service;

import com.github.pagehelper.PageHelper;
import com.julius.wisdom_teaching.domain.entity.Course;
import com.julius.wisdom_teaching.repository.CourseManageMapper;
import com.julius.wisdom_teaching.util.SelectResultWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * author julius.zhu
 * date   2019/9/17
 * time   8:45
 * describe:
 */
@Transactional
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseManageMapper courseManageMapper;

    @Override
    public Map<String, Object> selectCourse(Course condition) {
//        PageHelper.startPage(condition.getCurrentPage(), condition.getCount());
        return SelectResultWrap.resultWrap(courseManageMapper.selectCourse(condition));
    }
}
