package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.User;
import com.julius.wisdom_teaching.repository.UserMapper;
import com.julius.wisdom_teaching.util.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

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
    public void saveUserInfoAndLog(User user, HttpServletRequest request) {
        //存储下session信息
//        UserContext.setCurrentUser(request.getSession(), user);
        //记录下用户登录的日志
        logger.info("用户登录-用户账号:{}", user.getUsername());
        LocalDateTime dateTime = LocalDateTime.now();
        logger.info("用户登录-登录时间:{}", dateTime);
        logger.info("用户登录-登录地址:{}", request.getRemoteAddr());
    }

    @Override
    public String alterPassWord(User user) {
        return userMapper.alterPassWord(user) > 0 ? CommonResult.SUCCESS
                : CommonResult.FAIL;
    }

    @Override
    public List<User> queryUser() {
        return userMapper.queryUser();
    }
}
