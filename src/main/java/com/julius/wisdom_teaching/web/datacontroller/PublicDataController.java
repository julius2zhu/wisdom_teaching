package com.julius.wisdom_teaching.web.datacontroller;

import com.julius.wisdom_teaching.domain.entity.PublicResources;
import com.julius.wisdom_teaching.repository.PublicResourcesMapper;
import com.julius.wisdom_teaching.service.PublicResourcesService;
import com.julius.wisdom_teaching.service.UserService;
import com.julius.wisdom_teaching.util.CommonResult;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;


/**
 * author julius.zhu
 * date   2019/6/8
 * time   17:03
 * describe:
 * 公共数据查询,仅仅作为开放查询和下载接口,例如查询下拉框中的数据,
 * 查询资源，查询用户名等
 */
@CrossOrigin(origins = "*")
@RestController
public class PublicDataController {
    private final UserService userService;
    private final PublicResourcesService resourcesService;
    @Autowired
    private PublicResourcesMapper resourcesMapper;

    @Autowired
    public PublicDataController(UserService userService,
                                PublicResourcesService resourcesService) {
        this.userService = userService;
        this.resourcesService = resourcesService;
    }

    /**
     * 根据用户名查询用户是否存在
     *
     * @param request 请求对象
     * @return
     */
    @GetMapping(GlobalUrlMapping.public_data_query_user)
    public String selectUserByUserName(HttpServletRequest request) {
        return userService.findUserByUsername(request.getParameter("username"))
                != null ? CommonResult.USERNAME_EXIST : null;
    }

    /**
     * 根据条件去查询公共资源
     *
     * @param condition 条件对象
     * @return
     */
    @PostMapping(GlobalUrlMapping.public_data_query_resources)
    public Map<String, Object> queryPublicResources(@RequestBody PublicResources condition) {
        return resourcesService.queryPublicResources(condition);
    }

    /**
     * 根据指定资源id下载资源
     *
     * @param id       资源id
     * @param response 响应对象
     */
    @GetMapping(GlobalUrlMapping.public_data_resources_download)
    public void publicResourcesDownload(Integer id, HttpServletResponse response) throws IOException {
        String path = resourcesMapper.queryResoucesById(id);
        String fileName = path.substring(path.lastIndexOf("/") + 1);
        //设置响应头并写出数据
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        Files.copy(Paths.get(path), response.getOutputStream());
    }
}
