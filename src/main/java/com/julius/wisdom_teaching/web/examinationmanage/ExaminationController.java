package com.julius.wisdom_teaching.web.examinationmanage;

import com.julius.wisdom_teaching.domain.entity.Examination;
import com.julius.wisdom_teaching.domain.entity.ExaminationRecord;
import com.julius.wisdom_teaching.service.ExaminationServiceManage;
import com.julius.wisdom_teaching.util.CommonResult;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * author julius.zhu
 * date   2019/9/17
 * time   10:16
 * describe:
 * 试题信息表controller层
 */
@CrossOrigin(origins = "*")
@RestController
public class ExaminationController {

    private final ExaminationServiceManage examinationServiceManage;

    @Autowired
    public ExaminationController(ExaminationServiceManage examinationService) {
        this.examinationServiceManage = examinationService;
    }

    /**
     * 添加试题信息
     *
     * @param examination 试题信息对象
     * @return 自动生成的主键
     */
    @RequiresPermissions(CommonResult.ROLE_TEACHER_PERMISSION)
    @PostMapping(GlobalUrlMapping.examination_manage_add)
    public int add(@RequestBody Examination examination) {
        return examinationServiceManage.add(examination);
    }

    /**
     * 添加试题信息记录
     *
     * @param examinationRecord 试题信息记录对象
     * @return
     */
    @RequiresPermissions(CommonResult.ROLE_TEACHER_PERMISSION)
    @PostMapping(GlobalUrlMapping.examination_manage_addRecord)
    public String addRecord(@RequestBody ExaminationRecord examinationRecord) {
        return examinationServiceManage.addRecord(examinationRecord);
    }
}
