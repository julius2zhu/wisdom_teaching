package com.julius.wisdom_teaching.repository;

import com.julius.wisdom_teaching.domain.entity.Examination;
import com.julius.wisdom_teaching.domain.entity.ExaminationRecord;

import java.util.List;

/**
 * author julius.zhu
 * date   2019/9/17
 * time   10:23
 * describe:
 * 试题信息mapper接口
 */
public interface ExaminationManageMapper {
    /**
     * 添加试题信息
     *
     * @param examination 试题信息对象
     * @return 自动增长的主键
     */
    int add(Examination examination);

    /**
     * 添加试题记录信息
     *
     * @param examinationRecord 试题信息记录对象
     * @return
     */
    int addRecord(ExaminationRecord examinationRecord);

    /**
     * 根据课程id查询对应的试题信息
     *
     * @param value 课程id
     * @return
     */
    List<Examination> selectExaminationByCourseId(Integer value);

    /**
     * 根据试题id和题目类型查询记录数
     *
     * @param condition 条件
     * @return
     */
    List<ExaminationRecord> selectExaminationRecord(ExaminationRecord condition);
}
