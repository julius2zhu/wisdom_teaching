package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.Examination;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * author julius.zhu
 * date   2019/9/17
 * time   10:21
 * describe:
 * 试题信息业务层
 */
public interface ExaminationServiceManage {

    /**
     * 试题信息导入
     *
     * @param file        文件对象
     * @param examination 试题信息对象
     * @return
     */
    String examinationImport(MultipartFile file, Examination examination) throws IOException;
}
