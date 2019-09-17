package com.julius.wisdom_teaching.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * author julius.zhu
 * date   2019/9/17
 * time   8:38
 * describe:
 * 课程信息实体类
 */
@Setter
@Getter
public class Course extends BaseDomain {
    //课程名称
    private String label;
    //课程描述信息
    private String describes;
    //课程代码
    private Integer value;
    //创建人姓名
    private String createName;

    @Override
    public String toString() {
        return "Course{" +
                "label='" + label + '\'' +
                ", describes='" + describes + '\'' +
                ", value=" + value +
                ", createName='" + createName + '\'' +
                "} ";
    }
}
