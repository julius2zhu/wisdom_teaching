package com.julius.wisdom_teaching.repository;

import com.julius.wisdom_teaching.domain.entity.StudentCheckInfoCondition;
import com.julius.wisdom_teaching.domain.entity.StudentInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * author julius.zhu
 * date   2019/5/29
 * time   13:15
 * describe:
 * 学生信息查看持久层接口
 */
public interface StudentInfoCheckMapper {
    /**
     * 插入一条学生信息
     *
     * @param studentInfo 学生信息实体对象
     * @return 受影响的行数
     */
    Integer insertStudentInfo(StudentInfo studentInfo);

    /**
     * 查询所有学生信息
     *
     * @return 学生信息对象集合
     */
    List<StudentInfo> selectAllStudentInfo();

    /**
     * 查询符合条件的学生信息对象集合
     *
     * @param condition 条件
     * @return 学生信息对象集合
     */
    List<StudentInfo> selectStudentInfoByCondition(StudentCheckInfoCondition condition);

    /**
     * 根据学生单个id或者多个id集合查询学生信息
     *
     * @param ids id集合
     * @return 学生信息对象
     */
    List<StudentInfo> selectStudentById(@Param("ids") List<String> ids);
}
