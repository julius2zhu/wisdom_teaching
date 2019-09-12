package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.OnlineCheckName;

import java.util.List;

/**
 * author julius.zhu
 * date   2019/9/11
 * time   17:44
 * describe:
 * 课堂管理业务层
 */
public interface ClassManageService {
    /**
     * 考堂考勤
     *
     * @param what 做什么
     * @param ids  被添加/修改的id
     * @param teacherName 添加教师的名称
     * @return
     */
    String onlineCheckName(String what, String ids, String teacherName);

    /**
     * 根据学生id查询学生考勤信息
     * @param teacherName 教师名称
     * @param studentId 学生id
     * @return  考勤信息对象集合
     */
    List<OnlineCheckName> studentOnlineCheck(String teacherName,Integer studentId);
}
