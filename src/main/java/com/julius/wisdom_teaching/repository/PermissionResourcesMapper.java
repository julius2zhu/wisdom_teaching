package com.julius.wisdom_teaching.repository;

/**
 * author julius.zhu
 * date   2019/9/16
 * time   17:04
 * describe:
 * 权限资源信息mapper接口
 */
public interface PermissionResourcesMapper {
    /**
     * 查询用户权限资源信息
     *
     * @param primaryPrincipal 用户凭证信息
     * @return 权限资源表达式
     */
    String getPermissionResources(String primaryPrincipal);
}
