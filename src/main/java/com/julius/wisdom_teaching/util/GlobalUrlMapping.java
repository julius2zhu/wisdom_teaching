package com.julius.wisdom_teaching.util;

import org.springframework.stereotype.Component;

import java.io.File;

/**
 * author julius.zhu
 * date   2019/5/29
 * time   13:00
 * describe:
 * 全局请求url地址映射
 * 注:必须让spring去管理这个bean才会执行static代码块和construct中代码
 */
@Component
public class GlobalUrlMapping {
    //根路径请求
    private static final String ROOT = "/wisdom_teaching/";

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

    /* 课堂管理*/
    //考勤信息提交
    public static final String student_online_checkName = ROOT + "online_checkName";
    //考勤信息查看
    public static final String student_online_check = ROOT + "online_check";
    /*用户信息维护*/
    public static final String user_manage_query = ROOT + "/user_manage_query";

    /*学生作业管理*/
    //作业发布/更新
    public static final String student_issue_task = ROOT + "issue_task";
    //发布作业查看
    public static final String student_issue_task_check = ROOT + "issue_task_check";
    //发布作业下载
    public static final String student_issue_task_download = ROOT + "issue_task_download";
    //删除发布作业
    public static final String student_issue_task_delete = ROOT + "issue_task_delete";
    //学生查看作业
    public static final String student_task_submit_check = ROOT + "student_task_submit_check";
    //学生上传作业
    public static final String student_task_submit_upload = ROOT + "student_task_submit_upload";


    /*公共数据查询,例如常见的下拉框中的数据*/
    public static final String public_data_query_course = ROOT + "/query_course";
    public static final String public_data_query_question = ROOT + "/query_question";
    public static final String public_data_query_answer = ROOT + "/query_answer";

    /*文件上传和下载地址控制*/
    public static final String issue_task_path = "D:/hometask/issue/";
    public static final String submit_task_path = "D:/hometask/submit/";

    //初始化创建所有必须的文件夹
    static {
        //用于创建文件夹
        File f1 = new File(issue_task_path);
        if (!f1.exists())
            f1.mkdirs();
        File f2 = new File(submit_task_path);
        if (!f2.exists())
            f2.mkdirs();
    }
}
