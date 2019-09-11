package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * author julius.zhu
 * date   2019/5/29
 * time   17:52
 * describe:
 * 用户信息服务层接口
 */
public interface UserService {
    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息对象
     */
    User findUserByUsername(String username);

    /**
     * 保存用户信息和登陆日志信息
     *
     * @param user    用户信息对象实体
     * @param request 请求对象
     */
    void saveUserInfoAndLog(User user, HttpServletRequest request);

    /**
     * 用户修改密码
     *
     * @param user 用户信息对象
     * @return 结果
     */
    String alterPassWord(User user);

    /**
     * 用户信息查询
     *
     * @return 用户信息对象集合
     */
    List<User> queryUser();
}
