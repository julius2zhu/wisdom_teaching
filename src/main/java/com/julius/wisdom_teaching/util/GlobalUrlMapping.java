package com.julius.wisdom_teaching.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger("GlobalUrlMapping");

    private GlobalUrlMapping() {
    }

    //根路径请求
    private static final String ROOT = "/wisdom_teaching/";

    /* 登录,注册,修改密码模块*/
    //登陆
    public static final String LOGIN = ROOT + "login";
    //注册
    public static final String REGISTER = ROOT + "register";
    //密码修改
    public static final String alter_password = ROOT + "alter_password";

    /*学生信息查看模块*/
    public static final String STUDENT_INFO_CHECK = ROOT + "student_check";
    /*学生信息维护*/
    public static final String student_manage_add = ROOT + "student_manage/add";
    public static final String student_manage_update = ROOT + "student_manage/update";
    public static final String student_manage_delete = ROOT + "student_manage/delete";

    /*学生信息导入和导出*/
    public static final String student_upload_template = ROOT + "/upload_template";
    public static final String student_export = ROOT + "/student_export";

    /* 课堂管理*/
    //考勤信息提交
    public static final String student_online_checkName = ROOT + "online_checkName";
    //考勤信息查看
    public static final String student_online_check = ROOT + "online_check";

    /*用户信息维护*/
    //查看用户信息
    public static final String user_manage_query = ROOT + "user_manage_query";
    //删除用户信息
    public static final String user_manage_delete = ROOT + "user_manage_delete";
    //冻结/解冻用户
    public static final String user_manage_freezeOrThaw = ROOT + "user_manage_freezeOrThaw";
    //添加或者修改用户信息
    public static final String user_manage_addOrUpdate = ROOT + "user_manage_addOrUpdate";
    //根据用户名获取信息
    public static final String user_getUserInfoByUsername = ROOT + "getUserInfoByUsername";
    //学生更新自己信息
    public static final String user_update_student = ROOT + "user_update_student";

    /*学生作业管理*/
    //作业发布/更新
    public static final String student_issue_task = ROOT + "issue_task";
    //发布作业查看
    public static final String student_issue_task_check = ROOT + "issue_task_check";
    //发布作业下载
    public static final String student_issue_task_download = ROOT + "issue_task_download";
    //删除发布作业
    public static final String student_issue_task_delete = ROOT + "issue_task_delete";
    //教师阅读作业提交情况
    public static final String student_submit_task_read = ROOT + "student_submit_task_read";
    //教师批改学生作业
    public static final String student_submit_task_correct = ROOT + "student_submit_task_correct";

    //学生查看作业
    public static final String student_task_submit_check = ROOT + "student_task_submit_check";
    //学生上传作业
    public static final String student_task_submit_upload = ROOT + "student_task_submit_upload";
    //学生查看成绩和评语
    public static final String student_task_submit_score = ROOT + "student_task_submit_score";
    /*课程信息管理*/
    //添加或者更新课程信息
    public static final String course_manage_addOrUpdate = ROOT + "course_manage_addOrUpdate";
    //删除课程信息
    public static final String course_manage_delete = ROOT + "course_manage_delete";

    /*试题信息管理*/
    //添加试题信息
    public static final String examination_manage_add = ROOT + "examination_manage_add";
    //添加试题记录
    public static final String examination_manage_addRecord = ROOT + "examination_manage_addRecord";

    /*公共数据查询,例如常见的下拉框中的数据*/
    //根据用户名查询用户是否存在
    public static final String public_data_query_user = ROOT + "public_data_query_user";
    //查询公共资源
    public static final String public_data_query_resources = ROOT + "public_data_query_resources";
    //根据资源id去数据库中查找路径进行下载
    public static final String public_data_resources_download = ROOT + "public_data_resources_download";
    //查询所有的课程信息
    public static final String public_data_course_query = ROOT + "public_data_course_query";
    //查询指定课程所包含的试题信息
    public static final String public_data_examination_query = ROOT + "public_data_examination_query";
    //根据试题id和题目类型查询对应的记录
    public static final String public_data_examination_record_query = ROOT + "public_data_examination_record_query";
    //根据学生学号查询学生信息
    public static final String public_data_student_info_query = ROOT + "public_data_student_info_query";

    /*资源库管理*/
    //资源添加
    public static final String resources_add = ROOT + "resources_add";
    //资源删除
    public static final String resources_delete = ROOT + "resources_delete";

    /*文件上传和下载地址控制*/
    public static String issue_task_path = "/hometask/issue/";
    public static String submit_task_path = "/hometask/submit/";
    //公共资源上传存放的路径
    public static String resources_upload = "/public/resources/";

    //初始化创建所有必须的文件夹
    static {
        //获取当前项目所在的文件夹(Windows包含盘符,linux系统下面则要修改代码)
        File f = new File("");
        String absolutePath = f.getAbsolutePath();
        //将所有的\替换成/
        absolutePath = absolutePath.replace("\\", "/");
        issue_task_path = absolutePath + issue_task_path;
        File f1 = new File(issue_task_path);
        if (!f1.exists())
            f1.mkdirs();
        submit_task_path = absolutePath + submit_task_path;
        File f2 = new File(submit_task_path);
        if (!f2.exists())
            f2.mkdirs();
        resources_upload = absolutePath + resources_upload;
        File f3 = new File(resources_upload);
        if (!f3.exists())
            f3.mkdirs();
    }
}
