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
    //试题描述
    private String describes;
    //课程编号
    private Integer courseId;
    //创建人姓名
    private String createName;
}
