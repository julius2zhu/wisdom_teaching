package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.User;
import org.apache.shiro.authc.AuthenticationException;

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
     * 用户修改密码
     *
     * @param user 用户信息对象
     */
    void alterPassWord(User user) throws AuthenticationException;

    /**
     * 用户信息查询
     *
     * @return 用户信息对象集合
     */
    List<User> queryUser();

    /**
     * 添加一个用户
     *
     * @param user 用户信息对象
     * @return 受影响的行数
     */
    int addOne(User user);

    /**
     * 删除用户信息
     *
     * @param user 用户信息对象
     * @return
     */
    String deleteUser(User user);

    /**
     * 冻结/解冻
     *
     * @param user 用户信息对象
     * @return
     */
    String freeOrThaw(User user);

    /**
     * 检查通用户是否被冻结
     *
     * @param username 用户账号
     * @return
     */
    int checkIsFreeze(String username);

    /**
     * 更新用户信息
     *
     * @param user 用户信息对象
     * @return
     */
    int update(User user);
}
