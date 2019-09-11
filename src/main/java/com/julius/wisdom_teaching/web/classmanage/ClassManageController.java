package com.julius.wisdom_teaching.web.classmanage;

import com.julius.wisdom_teaching.domain.entity.OnlineCheckName;
import com.julius.wisdom_teaching.service.ClassManageService;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param request 请求对象
     * @return
     */
    @GetMapping(GlobalUrlMapping.student_online_checkName)
    public String onlineCheckName(HttpServletRequest request) {
        String what = request.getParameter("what");
        String ids = request.getParameter("ids");
        String teacherName = request.getParameter("teacherName");
        return this.classManageService.onlineCheckName(what, ids,teacherName);
    }

    /**
     * 考勤信息查看
     * @param request
     * @return
     */
    @GetMapping(GlobalUrlMapping.student_online_check)
    public List<OnlineCheckName> studentOnlineCheck(HttpServletRequest request) {
        String name = request.getParameter("name");
        String studentId = request.getParameter("studentId");
        return this.classManageService.studentOnlineCheck(Integer.parseInt(studentId));
    }
}
