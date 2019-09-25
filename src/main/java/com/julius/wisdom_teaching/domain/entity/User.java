package com.julius.wisdom_teaching.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * author julius.zhu
 * date   2019/5/29
 * time   17:49
 * describe:
 * 用户信息实体类,存储用户名和密码以及权限信息
 */
@Setter
@Getter
public class User extends BaseDomain {
    //主键id
    private Integer id;
    //用户真实姓名
    private String name;
    //用户性别
    private String sex;
    //密码
    private String password;
    //角色信息,学生0/教师1/管理员2
    private String role;
    //冻结状态,0,1
    private String state;
    //新密码
    private String newPassWord;
    //登录结果(账号不存在,密码错误,以及成功)
    private String message;
    //学生学号
    private Integer number;

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", role='" + role + '\'' +
                ", state='" + state + '\'' +
                ", newPassWord='" + newPassWord + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
