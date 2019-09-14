package com.julius.wisdom_teaching.web.datacontroller;

import com.julius.wisdom_teaching.service.UserService;
import com.julius.wisdom_teaching.util.CommonResult;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


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
    private UserService userService;
    @Autowired
    public PublicDataController(UserService userService) {
        this.userService = userService;
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
