package com.julius.wisdom_teaching.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * author julius.zhu
 * date   2019/5/29
 * time   13:22
 * describe:
 * 学生信息实体类
 */
@Setter
@Getter
public class StudentInfo extends BaseDomain  {
    //学生id
    private Integer studentId;
    //学生姓名
    private String name;
    //学生性别 0男1女
    private String sex;
    //学生班级号
    private String grade;
    //学生学号
    private String number;
    //学生所在系别
    private String department;
    //学生专业
    private String major;
    //学生班主任
    private String classTeacher;
    //添加人姓名
    private String teacherName;

    @Override
    public String toString() {
        return "StudentInfo{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", grade='" + grade + '\'' +
                ", number='" + number + '\'' +
                ", department='" + department + '\'' +
                ", major='" + major + '\'' +
                ", classTeacher='" + classTeacher + '\'' +
                ", teacherName='" + teacherName + '\'' +
                "} ";
    }
}
