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
     * @param inputStream 文件名称
     * @param homeWork 作业信息实体对象
     * @return
     */
    String  issueTask(InputStream inputStream, HomeWork homeWork) throws IOException;
}
