package com.julius.wisdom_teaching.repository;

import com.julius.wisdom_teaching.domain.entity.StudentInfo;

import java.util.List;

/**
 * author julius.zhu
 * date   2019/9/22
 * time   13:06
 * describe:
 * 教师学生关系mapper接口
 */
public interface TeacherStudentManageMapper {
    /**
     * 根据添加者id查询学生是否有记录
     *
     * @param studentInfo 学生信息对象
     * @return 记录数
     */
    int selectExistsByUserId(StudentInfo studentInfo);

    /**
     * 添加一条学生信息
     *
     * @param studentInfo 学生信息对象
     * @return
     */
    int add(StudentInfo studentInfo);

    /**
     * 教师编辑一条学生信息
     *
     * @param studentInfo 学生信息对象
     * @return
     */
    int update(StudentInfo studentInfo);

    /**
     * 教师删除一条学生信息
     *
     * @param id 学生id
     * @return
     */
    int delete(Integer id);

    /**
     * 根据学生学号查询该学生所有的教师id
     *
     * @param username 学生学号
     * @return
     */
    List<Integer> selectTeacherIdByNumber(Integer username);

    /**
     * 根据用户名查询学生id
     *
     * @param username 用户名
     * @return
     */
    Integer selectStudentIdByUsername(Integer username);
}
