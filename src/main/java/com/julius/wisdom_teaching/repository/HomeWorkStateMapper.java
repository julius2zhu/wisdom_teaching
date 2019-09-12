package com.julius.wisdom_teaching.repository;

import com.julius.wisdom_teaching.domain.entity.HomeWorkState;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author julius.zhu
 * date   2019/9/12
 * time   12:35
 * describe:
 */
public interface HomeWorkStateMapper {
    /**
     * 推送作业给所有学生
     *
     * @param homeWorkStates
     */
    void pushTask(@Param("homeWorkStates") List<HomeWorkState> homeWorkStates);
}
