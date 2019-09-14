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

    /**
     * 根据学生id查询学生的作业提交信息
     *
     * @param studentId 学生id
     * @return
     */
    List<HomeWorkState> selectTaskSubmitState(Integer studentId);

    /**
     * 更新作业提交信息
     *
     * @param homeWorkState 作业提交信息对象
     */
    void updateTaskSubmitState(HomeWorkState homeWorkState);

    /**
     * 根据教师姓名查询学生作业提交情况
     *
     * @param teacherName 教师姓名
     * @return
     */
    List<HomeWorkState> studentSubmitTaskRead(String teacherName);

    /**
     * 教师批改学生作业
     *
     * @param homeWorkState 作业状态信息
     * @return
     */
    Integer studentSubmitTaskCorrect(HomeWorkState homeWorkState);

    /**
     * 学生查询作业成绩和评语
     *
     * @param username 用户名
     * @return
     */
    List<HomeWorkState> studentCheckTaskScore(String username);
}
