package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.repository.PermissionResourcesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * author julius.zhu
 * date   2019/9/16
 * time   16:59
 * describe:
 */
@Service
public class PermissionResourcesServiceImpl implements PermissionResourcesService {
    @Autowired
    private PermissionResourcesMapper resourcesMapper;

    @Override
    public String getPermissionResources(String primaryPrincipal) {
        return resourcesMapper.getPermissionResources(primaryPrincipal);
    }
}
