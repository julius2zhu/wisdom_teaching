package com.julius.wisdom_teaching.web.classmanage;

import com.julius.wisdom_teaching.domain.entity.OnlineCheckName;
import com.julius.wisdom_teaching.service.ClassManageService;
import com.julius.wisdom_teaching.util.CommonResult;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * author julius.zhu
 * date   2019/9/11
 * time   17:21
 * describe:
 * 课堂管理
 */
@RestController
@CrossOrigin(origins = "*")
public class ClassManageController {
    private final ClassManageService classManageService;

    @Autowired
    public ClassManageController(ClassManageService classManageService) {
        this.classManageService = classManageService;
    }

    /**
     * 课堂考勤
     *
     * @param onlineCheckNames 考勤信息对象
     * @return
     */
    @RequiresPermissions(CommonResult.ROLE_TEACHER_PERMISSION)
    @PostMapping(GlobalUrlMapping.student_online_checkName)
    public String onlineCheckName(@RequestBody OnlineCheckName[] onlineCheckNames) {
        return this.classManageService.
                onlineCheckName(onlineCheckNames);
    }

    /**
     * 考勤信息查看
     *
     * @param request 请求对象
     * @return
     */
    @RequiresPermissions(CommonResult.ROLE_TEACHER_PERMISSION)
    @GetMapping(GlobalUrlMapping.student_online_check)
    public List<OnlineCheckName> studentOnlineCheck(HttpServletRequest request) {
        //获取添加者id和学生id
        return this.classManageService.studentOnlineCheck(
                Integer.parseInt(request.getParameter("userId")),
                Integer.valueOf(request.getParameter("studentId")));
    }
}
