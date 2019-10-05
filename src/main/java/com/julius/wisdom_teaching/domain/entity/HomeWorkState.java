package com.julius.wisdom_teaching.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * author julius.zhu
 * date   2019/9/12
 * time   12:24
 * describe:
 * 作业提交状态实体类
 */
@Setter
@Getter
public class HomeWorkState extends BaseDomain {
    //作业信息对象
    private HomeWork homeWork;
    //学生相关信息,此处仅使用姓名而已
    private User user;
    //学生id
    private Integer studentId;
    //提交文件路径
    private String submitPath;
    //提交状态
    private String submitState;
    //发布者id
    private Integer userId;
    //分数
    private Double score;
    //教师评语
    private String remark;
    //作业id
    private Integer homeWorkId;
    /**
     * 查询条件
     **/
    //学生姓名
    private String name;
    //学生学号
    private Integer number;
    //学生班级
    private String grade;

    @Override
    public String toString() {
        return "HomeWorkState{" +
                "homeWork=" + homeWork +
                ", user=" + user +
                ", studentId=" + studentId +
                ", submitPath='" + submitPath + '\'' +
                ", submitState='" + submitState + '\'' +
                ", userId=" + userId +
                ", score=" + score +
                ", remark='" + remark + '\'' +
                ", homeWorkId=" + homeWorkId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", grade='" + grade + '\'' +
                '}';
    }
}
