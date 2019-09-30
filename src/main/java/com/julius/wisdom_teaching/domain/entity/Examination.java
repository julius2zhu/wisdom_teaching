package com.julius.wisdom_teaching.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * author julius.zhu
 * date   2019/9/17
 * time   10:14
 * describe:
 * 试题信息表实体
 */
@Setter
@Getter
public class Examination extends BaseDomain {
    //试题名称
    private String name;
    //试题内容,带格式的html串
    private String content;
    //试题描述
    private String describes;
    //课程编号
    private Integer courseId;
    //添加人用户id
    private Integer userId;
    //为了符合前端需求,特意加两个属性,仅仅用作查询setter方法使用
    private String label;
    private String value;

    @Override
    public String toString() {
        return "Examination{" +
                "name='" + name + '\'' +
                ", describes='" + describes + '\'' +
                ", courseId=" + courseId +
                ", userId=" + userId +
                ", label='" + label + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
