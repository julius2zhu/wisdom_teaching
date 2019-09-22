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
    void insert(@Param("onlineCheckNames") OnlineCheckName[] onlineCheckNames);


    /**
     * 根据学生id查询学生考勤信息
     *
     * @param userId    添加者id
     * @param studentId 学生id
     * @return
     */
    List<OnlineCheckName> studentOnlineCheck(@Param("userId") Integer userId,
                                             @Param("studentId") Integer studentId);
}
