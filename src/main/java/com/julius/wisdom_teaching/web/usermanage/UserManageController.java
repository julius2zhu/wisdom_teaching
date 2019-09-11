package com.julius.wisdom_teaching.web.usermanage;

import com.julius.wisdom_teaching.domain.entity.User;
import com.julius.wisdom_teaching.service.UserService;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * author julius.zhu
 * date   2019/6/14
 * time   12:27
 * describe:
 * 用户信息维护Controller层
 */
@CrossOrigin(origins = "*")
@RestController
public class UserManageController {
    @Autowired
    private UserService userService;

    /**
     * 用户信息查询
     *
     * @return 用户信息对象集合
     */

    @GetMapping(GlobalUrlMapping.user_manage_query)
    public List<User> queryUser() {
        return userService.queryUser();
    }
}
