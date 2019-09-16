package com.julius.wisdom_teaching.service;

/**
 * author julius.zhu
 * date   2019/9/16
 * time   16:59
 * describe:
 * 权限资源信息业务层接口
 */
public interface PermissionResourcesService {
    /**
     * 根据登陆的凭证信息去查询权限信息
     *
     * @param primaryPrincipal 凭证信息
     * @return 资源表达式字符串
     */
    String getPermissionResources(String primaryPrincipal);
}
