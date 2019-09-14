package com.julius.wisdom_teaching.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * author julius.zhu
 * date   2019/9/11
 * time   14:34
 * describe:
 * 学生和用户之间联系表
 */
@Setter
@Getter
public class StudentUser extends BaseDomain {
    private Integer studentId;
    private Integer userId;
    @Override
    public String toString() {
        return "StudentUser{" +
                ", studentId=" + studentId +
                ", userId=" + userId +
                '}';
    }
}
