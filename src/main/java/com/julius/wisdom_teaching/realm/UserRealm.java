package com.julius.wisdom_teaching.realm;

import com.julius.wisdom_teaching.domain.entity.User;
import com.julius.wisdom_teaching.service.PermissionResourcesService;
import com.julius.wisdom_teaching.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * author julius.zhu
 * date   2019/8/26
 * time   18:01
 * describe:
 */
public class UserRealm extends AuthorizingRealm {
    private final Logger logger = LoggerFactory.getLogger("UserRealm");
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionResourcesService resourcesService;

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String primaryPrincipal = (String) principals.getPrimaryPrincipal();
        //根据用户名去查询用户角色,获取权限信息进行授权
        String permissionResources = resourcesService.getPermissionResources(primaryPrincipal);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermission(permissionResources);
        logger.debug("授权");
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取下凭证信息
        String principal = (String) token.getPrincipal();
        User user = userService.findUserByUsername(principal);
        if (user == null) {
            return null;
        }
        //创建一个简单的认证器 凭证信息 密码 盐 当前的realm
        return new SimpleAuthenticationInfo(principal, user.getPassword(),
                ByteSource.Util.bytes(principal), getName());
    }
}
