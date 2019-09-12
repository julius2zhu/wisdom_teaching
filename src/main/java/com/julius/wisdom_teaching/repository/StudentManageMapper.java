package com.julius.wisdom_teaching.repository;

import com.julius.wisdom_teaching.domain.entity.StudentInfo;
import com.julius.wisdom_teaching.domain.entity.StudentUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author julius.zhu
 * date   2019/5/30
 * time   23:08
 * describe:
 * 持久层
 */
public interface StudentManageMapper {
    /**
     * 添加学生信息
     *
     * @param studentInfo 学生信息实体对象
     * @return 受影响的行数
     */
    Integer add(StudentInfo studentInfo);

    /**
     * 插入id到student_user表中
     *
     * @param studentId   student生成id
     * @param userId      user生成的id
     * @param teacherName 添加人姓名
     * @return
     */
    Integer addStudentUser(@Param("studentId") Integer studentId,
                           @Param("userId") Integer userId,
                           @Param("teacherName") String teacherName);

    /**
     * 更新学生信息
     *
     * @param studentInfo 学生信息对象
     * @return 受影响的行数
     */
    Integer update(StudentInfo studentInfo);

    /**
     * 删除学生信息
     *
     * @param id 学生主键id
     * @return 受影响的行数
     */
    Integer delete(Integer id);

    /**
     * 插入多个学生信息
     *
     * @param students 学生信息实体集合
     * @return 受影响的行数
     */
    Integer insertStudentInfo(@Param("students") List<StudentInfo> students);

    /**
     * 根据学生学号查询学生id和用户id
     *
     * @param number 学生学号
     * @return
     */
    StudentUser selectStudentIdAndUserIdByNumber(String number);
}
