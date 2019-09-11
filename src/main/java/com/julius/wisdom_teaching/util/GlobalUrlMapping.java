package com.julius.wisdom_teaching.util;

/**
 * author julius.zhu
 * date   2019/5/29
 * time   13:00
 * describe:
 * 全局请求url地址映射
 */
public class GlobalUrlMapping {
    //根路径请求
    public static final String ROOT = "/wisdom_teaching/";

    /**
     * 登录登出修改密码模块
     **/
    //登陆
    public static final String LOGIN = ROOT + "login";

    public static final String alter_password = ROOT + "alter_password";
    /*学生信息查看模块*/
    public static final String STUDENT_INFO_CHECK = ROOT + "student_check";
    /*学生信息维护*/
    public static final String student_manage_add = ROOT + "student_manage/add";
    public static final String student_manage_update = ROOT + "student_manage/update";
    public static final String student_manage_delete = ROOT + "student_manage/delete";

    /*学生信息导入和导出*/
    public static final String student_download_template = ROOT + "/download_template";
    public static final String student_upload_template = ROOT + "/upload_template";
    public static final String student_export = ROOT + "/student_export";

    /* 学生在线考试*/
    public static final String student_online_question_url = ROOT + "/online_question_url";

    /*用户信息维护*/
    public static final String user_manage_query = ROOT + "/user_manage_query";
    /*公共数据查询,例如常见的下拉框中的数据*/
    public static final String public_data_query_course = ROOT + "/query_course";
    public static final String public_data_query_question = ROOT + "/query_question";
    public static final String public_data_query_answer = ROOT + "/query_answer";
}
