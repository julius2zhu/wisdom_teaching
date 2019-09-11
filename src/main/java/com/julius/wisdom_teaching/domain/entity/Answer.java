package com.julius.wisdom_teaching.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * author julius.zhu
 * date   2019/6/8
 * time   16:46
 * describe:
 * 答案解析实体类
 */
@Setter
@Getter
public class Answer {
    //主键id
    private Integer id;
    //课程编号
    private String courseValue;
    //当前试卷id
    private String selectId;
    //正确答案
    private String value;
    //分数
    private Double score;
    //解析
    private String resolve;
}
