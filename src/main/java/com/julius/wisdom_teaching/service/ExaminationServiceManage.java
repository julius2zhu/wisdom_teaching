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

    /**
     * 提那家试题信息
     *
     * @param examination 试题信息对象
     * @return
     */
    String examinationAdd(Examination examination);

    /**
     * 根据试题id查询试题信息
     *
     * @param id 试题id
     * @return
     */
    Examination examinationSelect(Integer id);

    /**
     * 更新试题信息
     *
     * @param examination 试题信息对象
     * @return
     */
    String examination_update(Examination examination);

    /**
     * 根据试题id删除试题信息
     *
     * @param id 试题id
     * @return
     */
    String examinationDelete(Integer id);
}
