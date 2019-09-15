package com.julius.wisdom_teaching.repository;

import com.julius.wisdom_teaching.domain.entity.PublicResources;

import java.util.List;

/**
 * author julius.zhu
 * date   2019/9/15
 * time   16:55
 * describe:
 * 公共资源mapper接口
 */
public interface PublicResourcesMapper {
    /**
     * 查询当前记录最大id值
     *
     * @return 最大id
     */
    Integer selectMaxId();

    /**
     * 插入一条记录
     *
     * @param publicResources 资源对象
     * @return
     */
    int add(PublicResources publicResources);

    /**
     * 根据资源id删除资源
     *
     * @param id 资源id
     * @return
     */
    int delete(Integer id);

    /**
     * 修改资源内容
     *
     * @param publicResources 资源信息对象
     * @return
     */
    int update(PublicResources publicResources);

    /**
     * 查询公共资源信息
     *
     * @param condition 条件对象
     * @return
     */
    List<PublicResources> queryPublicResources(PublicResources condition);

    /**
     * 根据资源id查询资源路径
     *
     * @param id 资源id
     * @return
     */
    String queryResoucesById(Integer id);
}
