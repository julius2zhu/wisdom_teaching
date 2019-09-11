package com.julius.wisdom_teaching.web.onlineexam;

import com.julius.wisdom_teaching.service.QuestionCheckService;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author julius.zhu
 * date   2019/6/8
 * time   16:03
 * describe:
 * 题目查询controller
 */
@CrossOrigin(origins = "*")
@RestController
public class QuestionController {
    @Autowired
    private QuestionCheckService questionCheckService;

    /**
     * 根据课程名称和时间返回文件的url地址
     *
     * @param id 文件地址id
     * @return 文件的url地址
     */
    @GetMapping(GlobalUrlMapping.student_online_question_url)
    public String fileUrl(Integer id) {
        return questionCheckService.selectQuestionUrl(id);
    }
}
