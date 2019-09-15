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
     * 导入学生数据
     *
     * @param file    文件对象
     * @param request 请求对象
     * @throws IOException
     */
    @PostMapping(GlobalUrlMapping.student_upload_template)
    public void uploadTemplate(MultipartFile file, HttpServletRequest request) throws IOException {
        String teacherName = request.getParameter("teacherName");
        //读取excel中数据
        List<StudentInfo> studentInfos = ExcelUtil.readExcel(file.getInputStream(), teacherName);
        //执行插入数据库操作
        for (StudentInfo studentInfo : studentInfos) {
            studentManageService.add(studentInfo);
        }
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
        response.setHeader("Content-Disposition", "attachment;filename=studentInfo.xlsx");
        studentInfoCheckService.selectStudentById(ids, outputStream);
    }
}
