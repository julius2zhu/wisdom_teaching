package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.Examination;
import com.julius.wisdom_teaching.domain.entity.ExaminationRecord;

import java.util.List;
import java.util.Map;

/**
 * author julius.zhu
 * date   2019/9/17
 * time   22:09
 * describe:
 * 试题信息记录表业务层接口
 */
public interface ExaminationRecordService {
    /**
     * 根据课程id查询试题信息
     *
     * @param value 课程id
     * @return
     */
    List<Examination> selectExaminationByCourseId(Integer value);

    /**
     * 根据试题id和题目类型查询记录
     *
     * @param condition 条件对象
     * @return
     */
    Map<String, Object> selectExaminationRecord(ExaminationRecord condition);


}
