package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.Examination;
import com.julius.wisdom_teaching.domain.entity.ExaminationRecord;
import com.julius.wisdom_teaching.repository.ExaminationManageMapper;
import com.julius.wisdom_teaching.util.CommonResult;
import com.julius.wisdom_teaching.util.WordUtil;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
    public String examinationImport(MultipartFile file, Examination examination) throws IOException {
        //1.首先读取word中内容
        Map map = WordUtil.readWord(file.getInputStream());
        //2.获取标题和表格中的相关信息
        String title = (String) map.get(WordUtil.title);
        List<ExaminationRecord> records = (List<ExaminationRecord>) map.get(WordUtil.info);
        //插入试题信息表
        examination.setName(title);
        examinationManageMapper.add(examination);
        Integer id = examination.getId();
        //插入试题信息记录表
        examinationManageMapper.addRecords(records, id);
        return CommonResult.SUCCESS;
    }

    @Override
    public String examinationAdd(Examination examination) {
        examinationManageMapper.examinationAdd(examination);
        return CommonResult.SUCCESS;
    }

    @Override
    public Examination examinationSelect(Integer id) {
        return examinationManageMapper.examinationSelect(id);
    }

    @Override
    public String examination_update(Examination examination) {
        examinationManageMapper.examination_update(examination);
        return CommonResult.SUCCESS;
    }

    @Override
    public String examinationDelete(Integer id) {
        return examinationManageMapper.examinationDelete(id)
                > 0 ? CommonResult.SUCCESS : CommonResult.FAIL;
    }
}
