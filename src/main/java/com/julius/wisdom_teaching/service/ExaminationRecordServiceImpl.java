package com.julius.wisdom_teaching.service;

import com.github.pagehelper.PageHelper;
import com.julius.wisdom_teaching.domain.entity.Examination;
import com.julius.wisdom_teaching.domain.entity.ExaminationRecord;
import com.julius.wisdom_teaching.repository.ExaminationManageMapper;
import com.julius.wisdom_teaching.util.SelectResultWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * author julius.zhu
 * date   2019/9/17
 * time   22:10
 * describe:
 */
@Transactional
@Service
public class ExaminationRecordServiceImpl implements ExaminationRecordService {
    @Autowired
    private ExaminationManageMapper examinationManageMapper;

    @Override
    public List<Examination> selectExaminationByCourseId(Integer value) {
        return examinationManageMapper.selectExaminationByCourseId(value);
    }

    @Override
    public Map<String, Object> selectExaminationRecord(ExaminationRecord condition) {
        PageHelper.startPage(condition.getCurrentPage(), condition.getCount());
        return SelectResultWrap.resultWrap(examinationManageMapper.selectExaminationRecord(condition));
    }
}
