package com.julius.wisdom_teaching.web.studentimport;

import com.julius.wisdom_teaching.domain.entity.StudentInfo;
import com.julius.wisdom_teaching.service.StudentInfoCheckService;
import com.julius.wisdom_teaching.service.StudentManageService;
import com.julius.wisdom_teaching.util.ExcelUtil;
import com.julius.wisdom_teaching.util.GlobalUrlMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * author julius.zhu
 * date   2019/6/7
 * time   12:22
 * describe:
 * 处理学生信息导入和导出controller
 */
@RestController
@CrossOrigin(origins = "*")
public class StudentInfoImport {
    @Autowired
    private StudentManageService studentManageService;
    @Autowired
    private StudentInfoCheckService studentInfoCheckService;

    /**
     * 模板文件下载
     *
     * @param fileName 文件名称
     * @param response 响应对象
     * @param request  请求对象
     */
    @GetMapping(GlobalUrlMapping.student_download_template)
    public void downloadTemplate(String fileName, HttpServletResponse response,
                                 HttpServletRequest request) {
        //下载文件存在的位置
        String dir = "C:/Users/Administrator/project";
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        try {
            Files.copy(Paths.get(dir, fileName), response.getOutputStream());
        } catch (IOException e) {
            System.out.println("文件下载出错");
            e.printStackTrace();
        }
    }

    /**
     * excel数据上传导入
     */
    @PostMapping(GlobalUrlMapping.student_upload_template)
    public String uploadTemplate(MultipartFile file) {
        try {
            //读取excel中数据
            List<StudentInfo> studentInfos = ExcelUtil.readExcel(file.getInputStream());
            //执行插入数据库操作
            studentManageService.insertStudentInfo(studentInfos);
        } catch (IOException e) {
            e.printStackTrace();
            return "数据导入出错";
        }
        return "数据导入成功";
    }

    /**
     * 导出数据为excel
     *
     * @param ids      多个id的字符串
     * @param response 相应对象
     */
    @GetMapping(GlobalUrlMapping.student_export)
    public void exportExcelData(String ids, HttpServletResponse response) {
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //写出数据
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader("Content-Disposition", "attachment;filename=test.xlsx");
        studentInfoCheckService.selectStudentById(ids, outputStream);
    }
}
