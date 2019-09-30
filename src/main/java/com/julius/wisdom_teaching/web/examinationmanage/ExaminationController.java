package com.julius.wisdom_teaching.web.examinationmanage;

import com.julius.wisdom_teaching.domain.entity.Examination;
import com.julius.wisdom_teaching.service.ExaminationServiceManage;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * author julius.zhu
 * date   2019/9/17
 * time   10:16
 * describe:
 * 在线试题管理controller层
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
     * 试题信息导入,服务器不留存文件
     *
     * @param file    文件对象
     * @param request 请求对象
     * @return
     */
    @PostMapping(GlobalUrlMapping.examination_import)
    public String examinationImport(MultipartFile file, HttpServletRequest request) throws IOException {
        //获取上传者id信息
        Examination examination = new Examination();
        examination.setCourseId(Integer.valueOf(request.getParameter("courseId")));
        examination.setUserId(Integer.valueOf(request.getParameter("userId")));
        return examinationServiceManage.examinationImport(file, examination);
    }

    /**
     * 添加/更新试题信息
     *
     * @param examination 试题信息对象
     * @return
     */
    @PostMapping(GlobalUrlMapping.examination_addOrUpdate)
    public String examinationAddOrUpdate(@RequestBody Examination examination) {
        if (examination.getId() > 0) {
            return this.examinationUpdate(examination);
        }
        return examinationServiceManage.examinationAdd(examination);
    }

    /**
     * 根据试题id查询试题信息
     *
     * @param examination 包含试题id
     * @return 试题信息对象
     */
    @PostMapping(GlobalUrlMapping.examination_select)
    public Examination examinationSelect(@RequestBody Examination examination) {
        return examinationServiceManage.examinationSelect(examination.getId());
    }

    /**
     * 更新试题信息
     *
     * @param examination 试题信息对象
     * @return
     */
    @PostMapping(GlobalUrlMapping.examination_update)
    public String examinationUpdate(Examination examination) {
        return examinationServiceManage.examination_update(examination);
    }

    /**
     * 根据试题id删除试题信息
     *
     * @param examination 试题信息对象
     * @return
     */
    @PostMapping(GlobalUrlMapping.examination_delete)
    public String examinationDelete(@RequestBody Examination examination) {
        return examinationServiceManage.examinationDelete(examination.getId());
    }
}
