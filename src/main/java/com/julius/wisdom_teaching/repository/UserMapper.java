package com.julius.wisdom_teaching.repository;

import com.julius.wisdom_teaching.domain.entity.StudentInfo;
import com.julius.wisdom_teaching.domain.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author julius.zhu
 * date   2019/5/29
 * time   17:56
 * describe:
 * 用户信息持久层接口
 */
public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息实体对象
     */
    User findUserByUsername(String username);

    /**
     * 检查登录
     *
     * @param user 用户信息对象实体
     * @return 用户信息实体对象
     */
    User loginCheck(User user);

    /**
     * 用户修改密码
     *
     * @param user 用户信息对象
     * @return 受影响的行数
     */
    Integer alterPassWord(User user);

    /**
     * 用户信息查询
     *
     * @param condition 条件信息
     * @return
     */
    List<User> queryUser(User condition);

    /**
     * 添加一个用户,返回受影响的行数
     *
     * @param user 用户信息对象
     * @return 受影响的行数
     */
    Integer addOne(User user);

    /**
     * 更新一条学生信息
     *
     * @param studentInfo 学生信息对象
     * @return 受影响的行数
     */
    Integer updateStudent(StudentInfo studentInfo);

    /**
     * 删除用户信息
     *
     * @param user 用户信息对象
     * @return
     */
    int deleteUser(User user);

    /**
     * 冻结/解冻
     *
     * @param user 用户信息对象
     * @return
     */
    int freeOrThaw(User user);

    /**
     * 根据用户名检查用户是否被冻结
     *
     * @param username 用户名
     * @return 记录
     */
    int checkIsFreeze(String username);

    /**
     * 更新用户信息
     *
     * @param user 用户信息对象
     * @return
     */
    int update(User user);

    /**
     * 处理用户注册
     *
     * @param user 用户信息对象
     * @return 受影响的行数
     */
    int register(User user);

    /**
     * 添加多个用户,仅仅用作测试使用
     *
     * @param users 用户信息对象集合
     */
    void addUsersUseTest(@Param("users") List<User> users);
}
