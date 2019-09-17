package com.julius.wisdom_teaching.web.datacontroller;

import com.julius.wisdom_teaching.domain.entity.PublicResources;
import com.julius.wisdom_teaching.service.PublicResourcesService;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * author julius.zhu
 * date   2019/9/15
 * time   16:41
 * describe:
 * 资源信息管理控制层
 */
@CrossOrigin(origins = "*")
@RestController
public class PublicResourcesController {
    private final PublicResourcesService resourcesService;

    @Autowired
    public PublicResourcesController(PublicResourcesService resourcesService) {
        this.resourcesService = resourcesService;
    }

    /**
     * 上传资源
     *
     * @param file    文件
     * @param request 请求对象
     * @return 结果
     * @throws IOException 文件读写异常
     */
    @PostMapping(GlobalUrlMapping.resources_add)
    public String add(MultipartFile file, HttpServletRequest request) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        if (id > 0) {
            return this.update(file, request);
        }
        PublicResources publicResources = new PublicResources();
        publicResources.setName(request.getParameter("name"));
        publicResources.setDescribes(request.getParameter("describes"));
        publicResources.setUsername(request.getParameter("username"));
        return resourcesService.add(file, publicResources);
    }

    /**
     * 根据资源id删除资源
     *
     * @param publicResources 资源信息对象
     * @return
     */
    @PostMapping(GlobalUrlMapping.resources_delete)
    public String delete(@RequestBody PublicResources publicResources) {
        return resourcesService.delete(publicResources.getId());
    }

    /**
     * 修改资源信息
     *
     * @param file    文件
     * @param request 请求对象
     * @return 结果
     * @throws IOException 文件读写异常
     */
    public String update(MultipartFile file, HttpServletRequest request) throws IOException {
        PublicResources publicResources = new PublicResources();
        publicResources.setId(Integer.valueOf(request.getParameter("id")));
        publicResources.setName(request.getParameter("name"));
        publicResources.setDescribes(request.getParameter("describes"));
        publicResources.setUsername(request.getParameter("username"));
        return resourcesService.update(file, publicResources);
    }

}
