package com.julius.wisdom_teaching.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * author julius.zhu
 * date   2019/9/15
 * time   16:36
 * describe:
 * 公共资源实体类
 */
@Setter
@Getter
public class PublicResources extends BaseDomain {
    //资源名称
    private String name;
    //资源路径
    private String path;
    //描述信息
    private String describes;

    @Override
    public String toString() {
        return "PublicResources{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", describes='" + describes + '\'' +
                "} ";
    }
}
