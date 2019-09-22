package com.julius.wisdom_teaching.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * author julius.zhu
 * date   2019/9/12
 * time   10:40
 * describe:
 * 作业实体类
 */
@Setter
@Getter
public class HomeWork extends BaseDomain {
    //作业名称
    private String name;
    //文件存储的路径
    private String path;
    //描述信息
    private String describes;
    //发布者id
    private Integer userId;

    @Override
    public String toString() {
        return "HomeWork{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", describes='" + describes + '\'' +
                ", userId='" + userId + '\'' +
                "} " ;
    }
}
