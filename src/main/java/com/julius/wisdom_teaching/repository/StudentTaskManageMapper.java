package com.julius.wisdom_teaching.repository;

import com.julius.wisdom_teaching.domain.entity.HomeWork;

/**
 * author julius.zhu
 * date   2019/9/12
 * time   10:59
 * describe:
 */
public interface StudentTaskManageMapper {
    /**
     * 添加作业信息到数据库中
     * @param homeWork 作业信息对象
     * @return
     */
    Integer issueTask(HomeWork homeWork);
}
