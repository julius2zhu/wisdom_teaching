package com.julius.wisdom_teaching.web.taskmanage;

import com.julius.wisdom_teaching.domain.entity.HomeWork;
import com.julius.wisdom_teaching.service.HomeWorkService;
import com.julius.wisdom_teaching.service.StudentTaskManageService;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * author julius.zhu
 * date   2019/9/12
 * time   10:09
 * describe:
 * 学生作业管理
 */
@RestController
@CrossOrigin(origins = "*")
public class StudentTaskManageController {
    private final StudentTaskManageService taskManageService;
    private final HomeWorkService homeWorkService;

    @Autowired
    public StudentTaskManageController(StudentTaskManageService taskManageService,
                                       HomeWorkService homeWorkService) {
        this.taskManageService = taskManageService;
        this.homeWorkService = homeWorkService;
    }

    /**
     * 教师发布作业且推送给负责的所有学生
     *
     * @param file    作业文件
     * @param request 请求对象
     * @return
     * @throws IOException
     */
    @PostMapping(GlobalUrlMapping.student_issue_task)
    public String issueTask(MultipartFile file, HttpServletRequest request) throws IOException {
        //获取文件的输入流和文件名称以及作业名和描述信息
        InputStream inputStream = file.getInputStream();
        String originalFilename = file.getOriginalFilename();
        String taskName = request.getParameter("name");
        String describe = request.getParameter("describe");
        String teacherName = request.getParameter("teacherName");
        HomeWork homeWork = new HomeWork();
        homeWork.setName(taskName);
        homeWork.setPath(originalFilename);
        homeWork.setDescribes(describe);
        homeWork.setTeacherName(teacherName);
        return taskManageService.issueTask(inputStream, homeWork);
    }

    /**
     * 发布作业信息查看
     * @param homeWork
     * @return
     */
    @PostMapping(GlobalUrlMapping.student_issue_task_check)
    public Map<String, Object> selectHomeWork(@RequestBody HomeWork homeWork) {
        return this.homeWorkService.selectHomeWorkByTeacherName(homeWork);
    }
}
