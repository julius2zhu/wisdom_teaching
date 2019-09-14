package com.julius.wisdom_teaching.web.login;

import com.julius.wisdom_teaching.domain.entity.User;
import com.julius.wisdom_teaching.service.UserService;
import com.julius.wisdom_teaching.util.CommonResult;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * author julius.zhu
 * date   2019/5/29
 * time   16:27
 * describe:
 * 登录登出控制
 */
@CrossOrigin(origins = "*")
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 处理用户登录
     *
     * @param user 用户信息对象实体
     * @return 返回用户角色信息
     */
    @PostMapping(GlobalUrlMapping.LOGIN)
    //@RequestBody映射ajax请求中对象的数据
    public User login(@RequestBody User user) {
        //检查是否被冻结
        int record = userService.checkIsFreeze(user.getUsername());
        if (record > 0) {
            user.setMessage(CommonResult.FREEZE);
            return user;
        }
        //获取当前登陆的主体
        Subject subject = SecurityUtils.getSubject();
        //创建登陆账号和密码
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(user.getUsername());
        token.setPassword(user.getPassword().toCharArray());
        try {
            //执行登陆操作
            subject.login(token);
            //没有出现异常
            User u = userService.findUserByUsername(user.getUsername());
            user.setMessage("登录成功");
            user.setName(u.getName());
            user.setRole(u.getRole());
        } catch (UnknownAccountException e1) {
            user.setMessage("账号不存在,请检查输入信息!");
        } catch (AuthenticationException e2) {
            user.setMessage("密码错误,请检查输入信息!");
        }
        return user;
    }

    /**
     * 用户修改密码
     *
     * @param user 用户信息对象
     * @return 结果
     */
    @PostMapping(GlobalUrlMapping.alter_password)
    public String alterPassWord(@RequestBody User user) {
        try {
            userService.alterPassWord(user);
        } catch (AuthenticationException e) {
            return CommonResult.FAIL;
        }
        return CommonResult.SUCCESS;
    }
}
