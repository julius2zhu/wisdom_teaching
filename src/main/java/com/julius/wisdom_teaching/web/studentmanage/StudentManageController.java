package com.julius.wisdom_teaching.web.studentmanage;

import com.julius.wisdom_teaching.domain.entity.StudentInfo;
import com.julius.wisdom_teaching.service.StudentManageService;
import com.julius.wisdom_teaching.util.CommonResult;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * author julius.zhu
 * date   2019/5/30
 * time   22:57
 * describe:
 * 学生信息管理controller层
 */
@CrossOrigin(origins = "*")
@RestController
public class StudentManageController {
    @Autowired
    private StudentManageService studentManageService;

    @PostMapping(GlobalUrlMapping.student_manage_add)
    public String add(@RequestBody StudentInfo studentInfo) {
        return studentManageService.add(studentInfo) > 0 ?
                CommonResult.SUCCESS : CommonResult.FAIL;
    }

    @PostMapping(GlobalUrlMapping.student_manage_update)
    public String update(@RequestBody StudentInfo studentInfo) {
        return studentManageService.update(studentInfo) > 0 ?
                CommonResult.SUCCESS : CommonResult.FAIL;
    }

    @PostMapping(GlobalUrlMapping.student_manage_delete)
    public String delete(@RequestBody StudentInfo studentInfo) {
        return studentManageService.delete(studentInfo.getId()) > 0 ?
                CommonResult.SUCCESS : CommonResult.FAIL;
    }
}
