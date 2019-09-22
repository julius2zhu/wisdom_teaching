package com.julius.wisdom_teaching.repository;

import com.julius.wisdom_teaching.domain.entity.HomeWork;

import java.util.List;

/**
 * author julius.zhu
 * date   2019/9/12
 * time   12:49
 * describe:
 * 作业管理mapper
 */
public interface HomeWorkMapper {
    /**
     * 根据发布者id称查询发布的作业
     *
     * @param homeWork 作业信息对象
     * @return
     */
    List<HomeWork> selectHomeWorkByUserId(HomeWork homeWork);

    /**
     * 根据作业id删除作业
     *
     * @param id 作业id
     * @return 受影响的行数
     */
    Integer delete(Integer id);

    /**
     * 跟新作业信息
     *
     * @param homeWork 作业信息对象
     */
    void updateTask(HomeWork homeWork);
}
