package com.julius.wisdom_teaching.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * author julius.zhu
 * date   2019/5/29
 * time   13:22
 * describe:
 * 学生信息实体类
 */
@Data
@Setter
@Getter
public class StudentInfo extends StudentBase implements Serializable {
    //学生姓名
    private String name;
    //学生性别
    private String sex;
    //学生班级号
    private String grade;
    //学生学号
    private String number;
    //学生所在系别
    private String department;
    //学生专业
    private String major;
}
