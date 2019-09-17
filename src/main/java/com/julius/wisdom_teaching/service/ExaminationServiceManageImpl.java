package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.Examination;
import com.julius.wisdom_teaching.domain.entity.ExaminationRecord;
import com.julius.wisdom_teaching.repository.ExaminationManageMapper;
import com.julius.wisdom_teaching.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author julius.zhu
 * date   2019/9/17
 * time   10:21
 * describe:
 */
@Transactional
@Service
public class ExaminationServiceManageImpl implements ExaminationServiceManage {
    @Autowired
    private ExaminationManageMapper examinationManageMapper;

    @Override
    public int add(Examination examination) {
        examinationManageMapper.add(examination);
        return examination.getId();
    }

    @Override
    public String addRecord(ExaminationRecord examinationRecord) {
        return examinationManageMapper.addRecord(examinationRecord)
                > 0 ? CommonResult.SUCCESS : CommonResult.FAIL;
    }
}
