package com.julius.wisdom_teaching.repository;


import com.julius.wisdom_teaching.domain.entity.Answer;
import com.julius.wisdom_teaching.domain.entity.SelectBase;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * author julius.zhu
 * date   2019/6/8
 * time   17:08
 * describe:
 * 课程信息查询接口
 */
public interface CourseMapper {
    /**
     * 查询所有的课程信息
     *
     * @return 课程信息集合
     */
    List<SelectBase> queryCourse();

    /**
     * 根据课程名称查询题目信息
     *
     * @param courseValue 课程编号
     * @return 题目信息集合
     */
    List<SelectBase> queryQuestion(@Param("value") String courseValue);

    /**
     * 根据问题id查询问题URL地址
     *
     * @param id 问题id
     * @return
     */
    SelectBase queryQuestionUrl(Integer id);

    /**
     * 根据课程编号和题目id查询答案信息
     *
     * @param courseId   课程编号
     * @param questionId 题目id
     * @return 答案解析对象集合
     */
    List<Answer> queryAnswer(@Param("courseId") String courseId,
                             @Param("questionId") Integer questionId);
}
