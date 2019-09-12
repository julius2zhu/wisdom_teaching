package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.OnlineCheckName;
import com.julius.wisdom_teaching.repository.OnlineCheckNameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author julius.zhu
 * date   2019/9/11
 * time   17:45
 * describe:
 */
@Service
public class ClassManageServiceImpl implements ClassManageService {
    @Autowired
    private OnlineCheckNameMapper onlineCheckNameMapper;

    @Override
    public String onlineCheckName(String what, String ids, String teacherName) {
        //分割id
        String[] split = ids.split(",");
        if ("insert".equalsIgnoreCase(what)) {
            List<OnlineCheckName> onlineCheckNames = new ArrayList<>();
            for (String id : split) {
                OnlineCheckName onlineCheckName = new OnlineCheckName();
                onlineCheckName.setStudentId(Integer.parseInt(id));
                onlineCheckName.setOnline(0);
                onlineCheckName.setTeacherName(teacherName);
                onlineCheckNames.add(onlineCheckName);
            }
            onlineCheckNameMapper.insert(onlineCheckNames);
        } else {
            //更新操作
            onlineCheckNameMapper.update(Arrays.asList(split));
        }
        return "成功";
    }

    @Override
    public List<OnlineCheckName> studentOnlineCheck(String teacherName,Integer studentId) {
        return onlineCheckNameMapper.studentOnlineCheck(teacherName,studentId);
    }
}
