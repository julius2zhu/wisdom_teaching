package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.OnlineCheckName;
import com.julius.wisdom_teaching.repository.OnlineCheckNameMapper;
import com.julius.wisdom_teaching.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author julius.zhu
 * date   2019/9/11
 * time   17:45
 * describe:
 */
@Transactional
@Service
public class ClassManageServiceImpl implements ClassManageService {
    @Autowired
    private OnlineCheckNameMapper onlineCheckNameMapper;

    @Override
    public String onlineCheckName(List<OnlineCheckName> onlineCheckNames) {
        onlineCheckNameMapper.insert(onlineCheckNames);
        return CommonResult.SUCCESS;
    }

    @Override
    public List<OnlineCheckName> studentOnlineCheck(String teacherName, Integer studentId) {
        return onlineCheckNameMapper.studentOnlineCheck(teacherName, studentId);
    }
}
