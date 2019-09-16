package com.julius.wisdom_teaching.web.taskmanage;

import com.julius.wisdom_teaching.domain.entity.HomeWork;
import com.julius.wisdom_teaching.domain.entity.HomeWorkState;
import com.julius.wisdom_teaching.domain.entity.User;
import com.julius.wisdom_teaching.service.HomeWorkService;
import com.julius.wisdom_teaching.service.StudentTaskManageService;
import com.julius.wisdom_teaching.util.CommonResult;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * author julius.zhu
 * date   2019/9/12
 * time   10:09
 * describe:
 * 作业管理
 */
@RestController
@CrossOrigin(origins = "*")
public class StudentTaskManageController {
    private final StudentTaskManageService studentTaskManageService;
    private final HomeWorkService homeWorkService;

    @Autowired
    public StudentTaskManageController(StudentTaskManageService taskManageService,
                                       HomeWorkService homeWorkService) {
        this.studentTaskManageService = taskManageService;
        this.homeWorkService = homeWorkService;
    }

    /**
     * 教师发布作作业且推送给负责的所有学生/更新作业
     *
     * @param file    作业文件
     * @param request 请求对象
     * @return 结果
     * @throws IOException
     */
    @RequiresPermissions(CommonResult.ROLE_TEACHER_PERMISSION)
    @PostMapping(GlobalUrlMapping.student_issue_task)
    public String issueTaskOrUpdate(MultipartFile file, HttpServletRequest request) throws IOException {
        //获取相关信息
        InputStream inputStream = file.getInputStream();
        String originalFilename = file.getOriginalFilename();
        String taskName = request.getParameter("name");
        String describes = request.getParameter("describes");
        String teacherName = request.getParameter("teacherName");
        HomeWork homeWork = new HomeWork();
        homeWork.setName(taskName);
        homeWork.setPath(originalFilename);
        homeWork.setDescribes(describes);
        homeWork.setTeacherName(teacherName);
        //判断是新增还是更新
        int id = Integer.parseInt(request.getParameter("id"));
        if (id > 0) {
            homeWork.setId(id);
            return studentTaskManageService.updateTask(inputStream, homeWork);
        }
        return studentTaskManageService.issueTask(inputStream, homeWork);
    }

    /**
     * 发布作业信息查看
     *
     * @param homeWork 作业信息对象
     * @return
     */
    @PostMapping(GlobalUrlMapping.student_issue_task_check)
    public Map<String, Object> selectHomeWork(@RequestBody HomeWork homeWork) {
        return this.homeWorkService.selectHomeWorkByTeacherName(homeWork);
    }

    /**
     * 作业下载,根据作业的名称
     *
     * @param path     文件全路径
     * @param response 相应对象
     * @throws IOException
     */
    @GetMapping(GlobalUrlMapping.student_issue_task_download)
    public void homeWorkDownload(String path, HttpServletResponse response) throws IOException {
        String fileName = path.substring(path.lastIndexOf("/") + 1);
        //设置响应头并写出数据
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        Files.copy(Paths.get(path), response.getOutputStream());
    }

    /**
     * 教师查看学生作业提交情况
     *
     * @param homeWorkState 包含条件信息
     * @return
     */
    @RequiresPermissions(CommonResult.ROLE_TEACHER_PERMISSION)
    @PostMapping(GlobalUrlMapping.student_submit_task_read)
    public Map<String, Object> studentSubmitTaskRead(@RequestBody HomeWorkState homeWorkState) {
        return this.homeWorkService.studentSubmitTaskRead(homeWorkState);
    }

    /**
     * 教师批改学生作业
     *
     * @param homeWorkState 学生作业提交状态对象
     * @return 结果
     */
    @RequiresPermissions(CommonResult.ROLE_TEACHER_PERMISSION)
    @PostMapping(GlobalUrlMapping.student_submit_task_correct)
    public String studentSubmitTaskCorrect(@RequestBody HomeWorkState homeWorkState) {
        return this.homeWorkService.studentSubmitTaskCorrect(homeWorkState);
    }

    /**
     * 教师根据作业id删除作业信息
     *
     * @param id 作业id
     * @return
     */
    @RequiresPermissions(CommonResult.ROLE_TEACHER_PERMISSION)
    @GetMapping(GlobalUrlMapping.student_issue_task_delete)
    public String issueTaskDelete(Integer id) {
        return this.homeWorkService.delete(id);
    }

    /**
     * 学生查看作业
     *
     * @param user 用户信息对象
     * @return
     */
    @RequiresPermissions(CommonResult.ROLE_STUDENT_PERMISSION)
    @PostMapping(GlobalUrlMapping.student_task_submit_check)
    public Map<String, Object> selectTaskSubmitState(@RequestBody User user) {
        return this.homeWorkService.selectTaskSubmitState(user);
    }

    /**
     * 学生提交作业
     *
     * @param file    上传文件信息
     * @param request 请求对象
     * @return
     */
    @RequiresPermissions(CommonResult.ROLE_STUDENT_PERMISSION)
    @PostMapping(GlobalUrlMapping.student_task_submit_upload)
    public String updateTaskSubmitState(MultipartFile file, HttpServletRequest request) throws IOException {
        //获取输入流和文件名以及主键信息
        InputStream inputStream = file.getInputStream();
        String filename = file.getOriginalFilename();
        int id = Integer.parseInt(request.getParameter("id"));
        return studentTaskManageService.updateTaskSubmitState(inputStream, filename, id);
    }

    /**
     * 学生查看作业分数和评语
     *
     * @param user 用户信息对象
     * @return
     */
    @RequiresPermissions(CommonResult.ROLE_STUDENT_PERMISSION)
    @PostMapping(GlobalUrlMapping.student_task_submit_score)
    public Map<String, Object> studentCheckTaskScore(@RequestBody User user) {
        return this.homeWorkService.studentCheckTaskScore(user);
    }
}
