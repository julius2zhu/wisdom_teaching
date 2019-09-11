package com.julius.wisdom_teaching.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.julius.wisdom_teaching.domain.entity.StudentCheckInfoCondition;
import com.julius.wisdom_teaching.domain.entity.StudentInfo;
import com.julius.wisdom_teaching.repository.StudentInfoCheckMapper;
import com.julius.wisdom_teaching.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * author julius.zhu
 * date   2019/5/29
 * time   13:44
 * describe:
 * 学生信息查看业务层实现类
 */
@Service
public class StudentInfoCheckServiceImp implements StudentInfoCheckService {
    @Autowired
    private StudentInfoCheckMapper studentInfoCheckMapper;

    @Override
    public Map<String, Object> selectAllStudentInfo(StudentCheckInfoCondition condition) {
        //获取下当前页和每页显示的条数
        PageHelper.startPage(condition.getCurrentPage(), condition.getCount());
        //必须紧跟查询条件
        List<StudentInfo> studentInfo = studentInfoCheckMapper.selectAllStudentInfo();
        //包装下
        PageInfo<StudentInfo> pageInfo = new PageInfo<>(studentInfo);
        Map<String, Object> map = new HashMap<>();
        //存放相关的分页信息
        condition.setTotalPage(pageInfo.getPages());
        condition.setTotalCount((int) pageInfo.getTotal());
        map.put("pageInfo", condition);
        //存放数据
        map.put("data", pageInfo.getList());
        return map;
    }

    @Override
    public Map<String, Object> selectStudentInfoByCondition(StudentCheckInfoCondition condition) {
        //获取下当前页和每页显示的条数
        PageHelper.startPage(condition.getCurrentPage(), condition.getCount());
        //必须紧跟查询条件
        List<StudentInfo> studentInfo = studentInfoCheckMapper.selectStudentInfoByCondition(condition);
        //包装下
        PageInfo<StudentInfo> pageInfo = new PageInfo<>(studentInfo);
        Map<String, Object> map = new HashMap<>();
        //存放相关的分页信息
        condition.setTotalPage(pageInfo.getPages());
        condition.setTotalCount((int) pageInfo.getTotal());
        map.put("pageInfo", condition);
        //存放数据
        map.put("data", pageInfo.getList());
        return map;
    }

    @Override
    public void selectStudentById(String ids, OutputStream outputStream) {
        String[] idsString = ids.split(",");
        List<String> idsList = Arrays.asList(idsString);
        try {
            ExcelUtil.exportExcel(outputStream, studentInfoCheckMapper.selectStudentById(idsList));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    //关闭流以来刷新写出数据
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
