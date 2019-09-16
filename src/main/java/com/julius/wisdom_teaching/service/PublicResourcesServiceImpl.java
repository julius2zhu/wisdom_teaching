package com.julius.wisdom_teaching.service;

import com.github.pagehelper.PageHelper;
import com.julius.wisdom_teaching.domain.entity.PublicResources;
import com.julius.wisdom_teaching.repository.PublicResourcesMapper;
import com.julius.wisdom_teaching.util.CommonResult;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import com.julius.wisdom_teaching.util.SelectResultWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

/**
 * author julius.zhu
 * date   2019/9/15
 * time   16:52
 * describe:
 */
@Transactional
@Service
public class PublicResourcesServiceImpl implements PublicResourcesService {

    @Autowired
    private PublicResourcesMapper resourcesMapper;

    @Override
    public String add(MultipartFile file, PublicResources publicResources) throws IOException {
        publicResources.setPath(this.saveFile(file));
        return resourcesMapper.add(publicResources)
                > 0 ? CommonResult.SUCCESS : CommonResult.FAIL;

    }

    @Override
    public String delete(Integer id) {
        return resourcesMapper.delete(id)
                > 0 ? CommonResult.SUCCESS : CommonResult.FAIL;
    }

    @Override
    public String update(MultipartFile file, PublicResources publicResources) throws IOException {
        publicResources.setPath(this.saveFile(file));
        return resourcesMapper.update(publicResources)
                > 0 ? CommonResult.SUCCESS : CommonResult.FAIL;
    }

    @Override
    public Map<String, Object> queryPublicResources(PublicResources condition) {
        PageHelper.startPage(condition.getCurrentPage(), condition.getCount());
        return SelectResultWrap.resultWrap(resourcesMapper.queryPublicResources(condition));
    }

    @Override
    public String saveFile(MultipartFile file) throws IOException {
        //查询数据库中最大id
        Integer maxId = resourcesMapper.selectMaxId();
        if (maxId != null) {
            ++maxId;
        } else {
            maxId = 1;
        }
        //截取文件后缀名,包含.
        String suffix = file.getOriginalFilename().
                substring(file.getOriginalFilename().lastIndexOf("."));
        //组成文件名
        String fileName = maxId + UUID.randomUUID().toString() + suffix;
        //全路径
        String wholePath = GlobalUrlMapping.resources_upload + fileName;
        //保存到文件中
        Files.copy(file.getInputStream(), Paths.get(wholePath));
        return wholePath;
    }


}
