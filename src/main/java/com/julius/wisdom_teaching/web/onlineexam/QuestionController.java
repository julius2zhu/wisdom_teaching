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


}
