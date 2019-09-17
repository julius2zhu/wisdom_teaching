package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.Examination;
import com.julius.wisdom_teaching.domain.entity.ExaminationRecord;

/**
 * author julius.zhu
 * date   2019/9/17
 * time   10:21
 * describe:
 * 试题信息业务层
 */
public interface ExaminationServiceManage {
    /**
     * 添加试题信息
     *
     * @param examination 试题信息对象
     * @return 自动生成的主键
     */
    int add(Examination examination);

    /**
     *  添加试题信息
     * @param examinationRecord 试题信息记录对象
     * @return
     */
    String addRecord(ExaminationRecord examinationRecord);
}
