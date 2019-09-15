package com.julius.wisdom_teaching.service;

import com.julius.wisdom_teaching.domain.entity.PublicResources;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * author julius.zhu
 * date   2019/9/15
 * time   16:52
 * describe:
 * 公共资源业务层
 */
public interface PublicResourcesService {
    /**
     * 上传资源
     *
     * @param file            文件
     * @param publicResources 资源信息对象实体
     * @return
     */
    String add(MultipartFile file, PublicResources publicResources) throws IOException;

    /**
     * 根据资源id删除资源
     *
     * @param id 资源id
     * @return 受影响的行数
     */
    String delete(Integer id);

    /**
     * 修改资源信息
     *
     * @param file            文件信息对象
     * @param publicResources 资源信息对象
     * @return
     */
    String update(MultipartFile file, PublicResources publicResources) throws IOException;

    /**
     * 保存文件
     *
     * @param file 文件对象
     * @return 文件的完整路径
     */
    String saveFile(MultipartFile file) throws IOException;

    /**
     * 查询公共资源信息
     *
     * @param condition 条件信息
     * @return
     */
    Map<String, Object> queryPublicResources(PublicResources condition);

}
