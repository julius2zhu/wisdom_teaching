package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.HomeWork;
import com.julius.wisdom_teaching.domain.entity.HomeWorkState;
import com.julius.wisdom_teaching.repository.HomeWorkStateMapper;
import com.julius.wisdom_teaching.repository.StudentTaskManageMapper;
import com.julius.wisdom_teaching.repository.StudentUserMapper;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * author julius.zhu
 * date   2019/9/12
 * time   10:48
 * describe:
 */
@Service
public class StudentTaskManageServiceImpl implements StudentTaskManageService {

    @Autowired
    private StudentTaskManageMapper studentTaskManageMapper;
    @Autowired
    private StudentUserMapper studentUserMapper;
    @Autowired
    private HomeWorkStateMapper homeWorkStateMapper;

    @Override
    public String issueTask(InputStream inputStream, HomeWork homeWork) throws IOException {
        //将文件保存起来
        String name = homeWork.getPath();
        String uuid = UUID.randomUUID().toString().substring(0, 30);
        String fileName = uuid + name.substring((name.lastIndexOf(".")));
        Files.copy(inputStream, Paths.get(GlobalUrlMapping.issue_task_path, fileName));
        //完整的路径
        String wholePath = GlobalUrlMapping.issue_task_path + fileName;
        homeWork.setPath(wholePath);
        //插入数据库操作
        if (studentTaskManageMapper.issueTask(homeWork) > 0) {
            //推送给所有的学生
            //获取自动生成的主键
            int taskId = homeWork.getId();
            String teacherName = homeWork.getTeacherName();
            //获取该教师负责的所有学生id信息
            List<Integer> studentIds = studentUserMapper.selectStudentIdByTeacherName(teacherName);
            List<HomeWorkState> homeWorkStates = new ArrayList<>();
            for (Integer studentId : studentIds) {
                HomeWorkState homeWorkState = new HomeWorkState();
                homeWorkState.setStudentId(studentId);
                homeWorkState.setTeacherName(teacherName);
                homeWorkState.setHomeWorkId(taskId);
                homeWorkStates.add(homeWorkState);
            }
            //执行插入操作
            homeWorkStateMapper.pushTask(homeWorkStates);
            return "成功";
        }
        return "失败";
    }
}