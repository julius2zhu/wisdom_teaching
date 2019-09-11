package com.julius.wisdom_teaching.service;

/**
 * author julius.zhu
 * date   2019/6/8
 * time   17:48
 * describe:
 * 问题查询业务层接口
 */
public interface QuestionCheckService {
    /**
     * 根据问题id查询问题的url地址
     *
     * @param id 问题id
     * @return url地址
     */
    String selectQuestionUrl(Integer id);
}
