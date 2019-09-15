package com.julius.wisdom_teaching.repository;

import com.julius.wisdom_teaching.domain.entity.StudentInfo;
import com.julius.wisdom_teaching.domain.entity.StudentUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     *
     * @param id
     * @return
     */
    StudentUser selectStudentUserInfo(Integer id);

    /**
     * 根据教师名称查询该教师下面所有学生id
     *
     * @param teacherName 教师名称
     * @return
     */
    List<Integer> selectStudentIdByTeacherName(@Param("teacherName") String teacherName);

    /**
     * 根据用户id查询学生id信息
     *
     * @param userId
     * @return
     */
    Integer selectStudentUserInfoByUserId(Integer userId);

    /**
     * 添加多个学生,仅仅用于测试
     *
     * @param studentInfos 学生信息对象集合
     */
    void addStudentUseTest(@Param("studentInfos") List<StudentInfo> studentInfos);
}
