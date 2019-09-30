package com.julius.wisdom_teaching.repository;

import com.julius.wisdom_teaching.domain.entity.Examination;
import com.julius.wisdom_teaching.domain.entity.ExaminationRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author julius.zhu
 * date   2019/9/17
 * time   10:23
 * describe:
 * 试题信息mapper接口
 */
public interface ExaminationManageMapper {
    /**
     * 添加试题信息
     *
     * @param examination 试题信息对象
     * @return 自动增长的主键
     */
    int add(Examination examination);

    /**
     * 添加试题记录信息
     *
     * @param examinationRecord 试题信息记录对象
     * @return
     */
    int addRecord(ExaminationRecord examinationRecord);

    /**
     * 根据课程id查询对应的试题信息
     *
     * @param value 课程id
     * @return
     */
    List<Examination> selectExaminationByCourseId(Integer value);

    /**
     * 根据试题id和题目类型查询记录数
     *
     * @param condition 条件
     * @return
     */
    List<ExaminationRecord> selectExaminationRecord(ExaminationRecord condition);

    /**
     * 仅仅做测试使用
     *
     * @param records
     */
    void addRecordTest(@Param("records") List<ExaminationRecord> records);

    /**
     * 添加多条试题记录
     *
     * @param records       试题记录集合对象
     * @param examinationId 试题信息id
     */
    void addRecords(@Param("records") List<ExaminationRecord> records,
                    @Param("examinationId") Integer examinationId);

    /**
     * 添加试题信息
     *
     * @param examination 试题信息对象
     * @return
     */
    int examinationAdd(Examination examination);

    /**
     * 根据试题id查询试题信息
     *
     * @param id 试题id
     * @return
     */
    Examination examinationSelect(Integer id);

    /**
     * 更新试题信息
     *
     * @param examination 试题信息对象
     * @return
     */
    int examination_update(Examination examination);

    /**
     * 根据试题id删除试题信息
     *
     * @param id 试题id
     * @return
     */
    int examinationDelete(Integer id);

}
