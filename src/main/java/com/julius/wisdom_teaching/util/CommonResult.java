package com.julius.wisdom_teaching.util;

/**
 * author julius.zhu
 * date   2019/5/30
 * time   23:21
 * describe:
 * 通用提示结果和权限表达式
 */
public class CommonResult {
    public CommonResult() {
    }

    public static final String SUCCESS = "成功";
    public static final String FAIL = "失败";
    public static final String FREEZE = "该账号已经被冻结,请联系管理员!";
    public static final String USERNAME_EXIST = "该用户名已经存在,请修改用户名!";
    /*权限资源信息,对应数据库*/
    //管理员权限
    public static final String ROLE_ADMIN_PERMISSION = "*:*";
    //教师权限
    public static final String ROLE_TEACHER_PERMISSION = "teacher:*";
    //学生权限
    public static final String ROLE_STUDENT_PERMISSION = "student:*";

}
