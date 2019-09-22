package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.StudentInfo;

import java.io.OutputStream;
import java.util.Map;

/**
 * author julius.zhu
 * date   2019/5/29
 * time   13:43
 * describe:
 * 学生信息查看业务层
 */
public interface StudentInfoCheckService {
    /**
     * 查询所有学生信息
     *
     * @param condition 查询条件
     * @return 学生信息对象集合
     */
    Map<String, Object> selectAllStudentInfo(StudentInfo condition);

    /**
     * 查询符合条件的学生信息
     *
     * @param condition 条件
     * @return 学生信息对象集合
     */
    Map<String, Object> selectStudentInfoByCondition(StudentInfo condition);

    /**
     * 根据单个或者多个id查询学生信息
     *
     * @param ids          id数组
     * @param outputStream 输出流对象
     */
    void selectStudentById(Integer[] ids, OutputStream outputStream);

    /**
     * 根据学生学号查询学生信息
     *
     * @param number 学生学号
     * @return 学生信息对象
     */
    StudentInfo selectStudentInfoByNumber(Integer number);
}
