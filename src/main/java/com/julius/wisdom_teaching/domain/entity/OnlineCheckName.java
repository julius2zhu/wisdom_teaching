package com.julius.wisdom_teaching.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * author julius.zhu
 * date   2019/9/11
 * time   20:54
 * describe:
 * 在线考勤表实体类
 */
@Setter
@Getter
public class OnlineCheckName extends BaseDomain {
    //学生id
    private Integer studentId;
    //添加者id
    private Integer userId;
    //是否考勤1未考勤 0考勤
    private Integer online;
    //理由
    private String reason;
    @Override
    public String toString() {
        return "OnlineCheckName{" +
                "studentId=" + studentId +
                ", userId=" + userId +
                ", online=" + online +
                ", reason='" + reason + '\'' +
                "} " + super.toString();
    }
}
