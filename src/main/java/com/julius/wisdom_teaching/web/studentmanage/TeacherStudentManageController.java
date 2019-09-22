package com.julius.wisdom_teaching.web.studentmanage;

import com.julius.wisdom_teaching.domain.entity.StudentInfo;
import com.julius.wisdom_teaching.service.StudentInfoCheckService;
import com.julius.wisdom_teaching.service.TeacherStudentManageService;
import com.julius.wisdom_teaching.util.CommonResult;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * author julius.zhu
 * date   2019/5/30
 * time   22:57
 * describe:
 * 教师和学生关系管理controller层
 */
@CrossOrigin(origins = "*")
@RestController
public class TeacherStudentManageController {
    private final TeacherStudentManageService teacherStudentManageService;
    private final StudentInfoCheckService studentInfoCheckService;

    @Autowired
    public TeacherStudentManageController(TeacherStudentManageService teacherStudentManageService,
                                          StudentInfoCheckService studentInfoCheckService) {
        this.teacherStudentManageService = teacherStudentManageService;
        this.studentInfoCheckService = studentInfoCheckService;
    }

    /**
     * 教师根据条件查询学生信息
     *
     * @param condition 条件对象
     * @return 符合条件的学生信息对象集合
     */
    @RequiresPermissions(CommonResult.ROLE_TEACHER_PERMISSION)
    @PostMapping(GlobalUrlMapping.STUDENT_INFO_CHECK)
    public Map<String, Object> select(@RequestBody StudentInfo condition) {
        return studentInfoCheckService.selectStudentInfoByCondition(condition);
    }

    /**
     * 教师添加一条学生信息
     *
     * @param studentInfo 学生信息实体
     * @return
     */
    @RequiresPermissions(CommonResult.ROLE_TEACHER_PERMISSION)
    @PostMapping(GlobalUrlMapping.student_manage_add)
    public String add(@RequestBody StudentInfo studentInfo) {
        return teacherStudentManageService.add(studentInfo);
    }

    /**
     * 教师编辑一条学生信息
     *
     * @param studentInfo 学生信息对象
     * @return
     */
    @RequiresPermissions(CommonResult.ROLE_TEACHER_PERMISSION)
    @PostMapping(GlobalUrlMapping.student_manage_update)
    public String update(@RequestBody StudentInfo studentInfo) {
        return teacherStudentManageService.update(studentInfo);
    }

    /**
     * 教师删除一条学生信息
     *
     * @param studentInfo 学生信息对象
     * @return
     */
    @RequiresPermissions(CommonResult.ROLE_TEACHER_PERMISSION)
    @PostMapping(GlobalUrlMapping.student_manage_delete)
    public String delete(@RequestBody StudentInfo studentInfo) {
        return teacherStudentManageService.delete(studentInfo.getId());

    }
}
