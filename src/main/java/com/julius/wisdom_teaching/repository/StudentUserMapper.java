package com.julius.wisdom_teaching.repository;

import com.julius.wisdom_teaching.domain.entity.StudentUser;

/**
 * author julius.zhu
 * date   2019/9/11
 * time   14:36
 * describe:
 * 学生表和用户表中间联系表
 */
public interface StudentUserMapper {

    /**
     * 根据id查询student_id和user_id信息
     * @param id
     * @return
     */
    StudentUser selectStudentUserInfo(Integer id);
}
