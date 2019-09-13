package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.HomeWork;
import com.julius.wisdom_teaching.domain.entity.User;

import java.util.Map;

/**
 * author julius.zhu
 * date   2019/9/12
 * time   12:54
 * describe:
 * 作业管理业务层
 */
public interface HomeWorkService {
    /**
     * 根据教师名称查询
     *
     * @param homeWork
     * @return
     */
    Map<String, Object> selectHomeWorkByTeacherName(HomeWork homeWork);

    /**
     * 根据作业id删除作业信息
     *
     * @param id 作业id
     * @return
     */
    String delete(Integer id);

    /**
     * 学生查看作业提交状态信息
     *
     * @param user 用户信息对象
     * @return
     */
    Map<String, Object> selectTaskSubmitState(User user);
}
