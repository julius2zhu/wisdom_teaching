package com.julius.wisdom_teaching.util;

import com.github.pagehelper.PageInfo;
import com.julius.wisdom_teaching.domain.entity.BaseDomain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author julius.zhu
 * date   2019/9/14
 * time   23:14
 * describe:
 * 查询结果包装
 */
public interface SelectResultWrap {
    static <E> Map<String, Object> resultWrap(List<E> eList) {
        //包装下
        PageInfo<E> pageInfo = new PageInfo<>(eList);
        Map<String, Object> map = new HashMap<>();
        BaseDomain baseDomain = new BaseDomain();
        //存放相关的分页信息,总页数和总条数
        baseDomain.setTotalPage(pageInfo.getPages());
        baseDomain.setTotalCount((int) pageInfo.getTotal());
        map.put("pageInfo", baseDomain);
        //存放数据
        map.put("data", pageInfo.getList());
        return map;
    }
}
