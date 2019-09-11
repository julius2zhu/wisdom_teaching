package com.julius.wisdom_teaching.service;


import com.julius.wisdom_teaching.domain.entity.SelectBase;
import com.julius.wisdom_teaching.repository.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author julius.zhu
 * date   2019/6/8
 * time   17:51
 * describe:
 * 问题查询接口层实现类
 */
@Service
public class QuestionCheckServiceImpl implements QuestionCheckService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public String selectQuestionUrl(Integer id) {
        SelectBase selectBase = courseMapper.queryQuestionUrl(id);
        return selectBase.getUrl();
    }
}
