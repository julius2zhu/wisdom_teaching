package com.julius.wisdom_teaching.service;

import com.github.pagehelper.PageHelper;
import com.julius.wisdom_teaching.domain.entity.User;
import com.julius.wisdom_teaching.repository.UserMapper;
import com.julius.wisdom_teaching.util.CommonResult;
import com.julius.wisdom_teaching.util.EncryptUtil;
import com.julius.wisdom_teaching.util.SelectResultWrap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * author julius.zhu
 * date   2019/5/29
 * time   17:54
 * describe:
 * 用户信息服务层接口实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public void alterPassWord(User user) throws AuthenticationException {
        //用户输入的密码和旧密码进行匹配
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(user.getUsername());
        token.setPassword(user.getPassword().toCharArray());
        subject.login(token);
        //对密码进行密文加密
        user.setNewPassWord(EncryptUtil.encrypt(user));
        userMapper.alterPassWord(user);
    }

    @Override
    public Map<String,Object> queryUser(User condition) {
        PageHelper.startPage(condition.getCurrentPage(), condition.getCount());
        return SelectResultWrap.resultWrap(userMapper.queryUser(condition));

    }

    @Override
    public int addOne(User user) {
        //取出用户传递的密码,设置该属性,加密器通过该属性进行加密
        user.setNewPassWord(user.getUsername());
        user.setPassword(EncryptUtil.encrypt(user));
        return userMapper.addOne(user);
    }

    @Override
    public String deleteUser(User user) {
        return userMapper.deleteUser(user) > 0 ? CommonResult.SUCCESS : CommonResult.FAIL;
    }

    @Override
    public String freeOrThaw(User user) {
        return userMapper.freeOrThaw(user) > 0 ? CommonResult.SUCCESS : CommonResult.FAIL;
    }

    @Override
    public int checkIsFreeze(String username) {
        return userMapper.checkIsFreeze(username);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public String register(User user) {
        user.setPassword(EncryptUtil.encrypt(user.getPassword(), user.getUsername(), 3));
        return userMapper.register(user) > 0 ? CommonResult.SUCCESS : CommonResult.FAIL;
    }
}
