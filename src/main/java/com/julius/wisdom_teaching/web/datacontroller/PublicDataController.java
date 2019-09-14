package com.julius.wisdom_teaching.web.datacontroller;

import com.julius.wisdom_teaching.domain.entity.Answer;
import com.julius.wisdom_teaching.domain.entity.SelectBase;
import com.julius.wisdom_teaching.domain.entity.User;
import com.julius.wisdom_teaching.repository.CourseMapper;
import com.julius.wisdom_teaching.service.UserService;
import com.julius.wisdom_teaching.util.CommonResult;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * author julius.zhu
 * date   2019/6/8
 * time   17:03
 * describe:
 * 公共数据controller，例如查询下拉框中的数据
 */
@CrossOrigin(origins = "*")
@RestController
public class PublicDataController {
    @Autowired
    private CourseMapper courseMapper;
    private UserService userService;

    @Autowired
    public PublicDataController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 查询课程信息
     *
     * @return 课程信息对象
     */
    @GetMapping(GlobalUrlMapping.public_data_query_course)
    public List<SelectBase> queryCourse() {
        return courseMapper.queryCourse();
    }

    /**
     * 根据课程名称查询题目信息
     *
     * @param value 课程代号
     * @return 题目信息对象
     */
    @GetMapping(GlobalUrlMapping.public_data_query_question)
    public List<SelectBase> queryQuestion(String value) {
        return courseMapper.queryQuestion(value);
    }

    /**
     * 根据课程编号和题目id查询答案信息
     *
     * @param courseId   课程编号
     * @param questionId 题目id
     * @return 答案解析对象集合
     */
    @GetMapping(GlobalUrlMapping.public_data_query_answer)
    public List<Answer> queryAnswer(String courseId, Integer questionId) {
        return courseMapper.queryAnswer(courseId, questionId);
    }

    /**
     * 根据用户名查询用户是否存在
     *
     * @param request 请求对象
     * @return
     */
    @GetMapping(GlobalUrlMapping.public_data_query_user)
    public String selectUserByUserName(HttpServletRequest request) {
        return userService.findUserByUsername(request.getParameter("username"))
                != null ? CommonResult.USERNAME_EXIST : null;
    }
}
