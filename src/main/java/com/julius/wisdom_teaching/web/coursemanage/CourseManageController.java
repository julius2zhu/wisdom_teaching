package com.julius.wisdom_teaching.web.coursemanage;

import com.julius.wisdom_teaching.domain.entity.Course;
import com.julius.wisdom_teaching.service.CourseService;
import com.julius.wisdom_teaching.util.CommonResult;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * author julius.zhu
 * date   2019/9/17
 * time   8:43
 * describe:
 * 课程管理Controller
 */
@CrossOrigin(origins = "*")
@RestController
public class CourseManageController {
    private final CourseService courseService;

    @Autowired
    public CourseManageController(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * 添加或者更新课程信息
     *
     * @param course 课程信息对象
     * @return
     */
    @PostMapping(GlobalUrlMapping.course_manage_addOrUpdate)
    @RequiresPermissions(CommonResult.ROLE_ADMIN_PERMISSION)
    public String courseAddOrUpdate(@RequestBody Course course) {
        if (course.getId() > 0) {
            return courseService.update(course);
        }
        return courseService.add(course);
    }

    /**
     * 根据课程id删除课程信息
     *
     * @param id 课程id
     * @return
     */
    @PostMapping(GlobalUrlMapping.course_manage_delete)
    @RequiresPermissions(CommonResult.ROLE_ADMIN_PERMISSION)
    public String courseDelete(@RequestBody Course id) {
        return courseService.courseDelete(id.getId());
    }
}
