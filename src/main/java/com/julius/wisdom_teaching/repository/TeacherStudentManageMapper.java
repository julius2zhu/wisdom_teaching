package com.julius.wisdom_teaching.repository;

import com.julius.wisdom_teaching.domain.entity.StudentInfo;

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
}
