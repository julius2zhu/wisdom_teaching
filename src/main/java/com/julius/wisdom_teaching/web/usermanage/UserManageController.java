package com.julius.wisdom_teaching.web.usermanage;

import com.julius.wisdom_teaching.domain.entity.User;
import com.julius.wisdom_teaching.service.UserService;
import com.julius.wisdom_teaching.util.CommonResult;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
     * @param condition 查询条件对象
     * @return
     */
    @PostMapping(GlobalUrlMapping.user_manage_query)
    public Map<String, Object> queryUser(@RequestBody User condition) {
        return userService.queryUser(condition);
    }

    /**
     * 删除用户信息
     *
     * @param user 用户信息对象
     * @return
     */
    @PostMapping(GlobalUrlMapping.user_manage_delete)
    public String deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }

    /**
     * 冻结或者解冻
     *
     * @param user 用户信息对象
     * @return
     */
    @PostMapping(GlobalUrlMapping.user_manage_freezeOrThaw)
    public String freeOrThaw(@RequestBody User user) {
        return userService.freeOrThaw(user);
    }

    /**
     * 添加/更新用户
     *
     * @param user 用户信息对象
     * @return
     */
    @PostMapping(GlobalUrlMapping.user_manage_addOrUpdate)
    public String userAddOrUpdate(@RequestBody User user) {
        if (user.getId() > 0) {
            //更新
            return userService.update(user) > 0 ? CommonResult.SUCCESS : CommonResult.FAIL;
        }
        return userService.addOne(user) > 0 ? CommonResult.SUCCESS : CommonResult.FAIL;
    }
}

