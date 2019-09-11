package com.julius.wisdom_teaching.web.studentcheck;


import com.julius.wisdom_teaching.domain.entity.StudentCheckInfoCondition;
import com.julius.wisdom_teaching.service.StudentInfoCheckService;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * author julius.zhu
 * date   2019/5/29
 * time   12:59
 * describe:
 * 学生信息查看controller
 */
//允许所有的跨域访问
@CrossOrigin(origins = "*")
@RestController
public class StudentCheckController {
    @Autowired
    private StudentInfoCheckService studentInfoCheckService;

    /**
     * 根据条件查询学生信息
     *
     * @param condition 条件对象
     * @return 符合条件的学生信息对象集合
     */
    @PostMapping(GlobalUrlMapping.STUDENT_INFO_CHECK)
    public Map<String, Object> select(@RequestBody StudentCheckInfoCondition condition) {
        System.out.println(condition);
        return studentInfoCheckService.selectStudentInfoByCondition(condition);
    }
}
