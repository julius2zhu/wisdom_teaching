package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.StudentInfo;

import java.util.List;

/**
 * author julius.zhu
 * date   2019/9/22
 * time   13:02
 * describe:
 * 教师和学生关系管理service层接口
 */
public interface TeacherStudentManageService {
    /**
     * 教师添加一条学生信息
     *
     * @param studentInfo 学生信息对象
     * @return 添加结果
     */
    String add(StudentInfo studentInfo);

    /**
     * 教师编辑一条学生信息
     *
     * @param studentInfo 学生信息对象
     * @return
     */
    String update(StudentInfo studentInfo);

    /**
     * 教师删除一条学生信息
     *
     * @param id 学生记录id
     * @return
     */
    String delete(Integer id);

    /**
     * 导入学生数据
     *
     * @param studentInfos 学生信息对象集合
     */
    void importStudentInfo(List<StudentInfo> studentInfos);

    /**
     * 查询学生id根据用户名进行查询
     * @param username 用户名
     * @return
     */
    Integer selectStudentIdByUsername(Integer  username);
}
