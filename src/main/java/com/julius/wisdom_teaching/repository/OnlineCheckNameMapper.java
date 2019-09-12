package com.julius.wisdom_teaching.repository;

import com.julius.wisdom_teaching.domain.entity.OnlineCheckName;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author julius.zhu
 * date   2019/9/11
 * time   20:50
 * describe:
 * 在线考勤
 */
public interface OnlineCheckNameMapper {
    /**
     * 插入多条数据
     *
     * @param onlineCheckNames
     */
    void insert(@Param("onlineCheckNames") List<OnlineCheckName> onlineCheckNames);

    /**
     * 更新数据
     *
     * @param asList 所有的集合id
     */
    void update(@Param("ids") List<String> asList);

    /**
     * 根据学生id查询学生考勤信息
     *
     * @param teacherName 教师名称
     * @param studentId   学生id
     * @return
     */
    List<OnlineCheckName> studentOnlineCheck(@Param("teacherName") String teacherName,
                                             @Param("studentId") Integer studentId);
}
