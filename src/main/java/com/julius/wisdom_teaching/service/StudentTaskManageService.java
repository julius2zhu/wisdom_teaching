package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.HomeWork;

import java.io.IOException;
import java.io.InputStream;

/**
 * author julius.zhu
 * date   2019/9/12
 * time   10:48
 * describe:
 */
public interface StudentTaskManageService {
    /**
     * 教师添加作业
     *
     * @param inputStream 文件名称
     * @param homeWork    作业信息实体对象
     * @return
     */
    String issueTask(InputStream inputStream, HomeWork homeWork) throws IOException;

    /**
     * 更新作业
     *
     * @param inputStream 输入流文件
     * @param homeWork    作业信息对象
     * @return
     */
    String updateTask(InputStream inputStream, HomeWork homeWork) throws IOException;

    /**
     * 学生上传作业
     *
     * @param inputStream 输入流对象
     * @param filename    文件名称
     * @param id          主键id
     * @return
     */
    String updateTaskSubmitState(InputStream inputStream, String filename, int id) throws IOException;
}
