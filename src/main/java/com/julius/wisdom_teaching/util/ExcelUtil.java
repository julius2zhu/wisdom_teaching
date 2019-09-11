package com.julius.wisdom_teaching.util;

import com.julius.wisdom_teaching.domain.entity.StudentInfo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * author julius.zhu
 * date   2019/5/26
 * time   19:21
 * describe:
 * 操作excel表格的工具类,包括读取excel表格数据以及导入数据
 */
public class ExcelUtil {
    /**
     * 读取excel表格中数据
     *
     * @param inputStream 读取文件的输入流
     * @return 学生对象集合
     * @throws IOException 文件读取异常/文件被占用会抛出该异常
     */
    public static List<StudentInfo> readExcel(InputStream inputStream) throws IOException {
        List<StudentInfo> students = new ArrayList<>();
        //根据的excel文件创建一个WorkBook，用于读取其中的sheet中信息
        Workbook workbook = WorkbookFactory.create(inputStream);
        //获取一个Sheet对象,下标为0表示获取第0个sheet表中数据
        Sheet sheet = workbook.getSheetAt(0);
        //遍历每一行数,默认从二行开始遍历,若是没有数据则停止遍历
        int rowIndex = 1;
        Row row = sheet.getRow(rowIndex);
        while (row != null) {
            //取出当前行中每列的数据封装成对象添加到集合中
            //循环遍历列
            int cellIndex = 0;
            Cell cell = row.getCell(cellIndex);
            StudentInfo student = new StudentInfo();
            while (cell != null) {
                //统一设置,不然会出现非法状态异常
                //该方法官方提示将会在5.0版本中移除
                cell.setCellType(CellType.STRING);
                String value = cell.getStringCellValue();
                //针对部分类型进行特殊处理
                students.add(student);
                rowIndex++;
                row = sheet.getRow(rowIndex);
            }
        }
        return students;
    }

    /**
     * 导出数据为excel表格数据
     *
     * @param outputStream 输出流对象
     * @param studentInfo  学生信息对象集合
     * @return 是否成功
     * @throws IOException 输入输出异常
     */
    public static Boolean exportExcel(OutputStream outputStream, List<StudentInfo> studentInfo) throws
            IOException {
        //XSS用于操作xlsx格式文档读写
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建sheet对象
        Sheet sheet = workbook.createSheet("学生信息表");
        //创建一行作为表头
        Row row = sheet.createRow(0);
        //设置表头数据
        Cell cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("姓名");
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("性别(0男1女)");
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("班级");
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("学号");
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("系别");
        cell = row.createCell(5, CellType.NUMERIC);
        cell.setCellValue("专业");
        cell = row.createCell(6, CellType.NUMERIC);
        cell.setCellValue("班主任");
        //遍历查找到的数据index遍历集合下标 k控制excel行下标
        for (int index = 0, k = 1; index < studentInfo.size(); index++, k++) {
            //依次取出数据
            StudentInfo student = studentInfo.get(index);
            //创建一行
            row = sheet.createRow(k);
            //创建一列
            cell = row.createCell(0, CellType.STRING);
            //设置值
            cell.setCellValue(student.getName());
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(student.getSex());
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(student.getGrade());
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(student.getNumber());
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(student.getDepartment());
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue(student.getMajor());
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue(student.getClassTeacher());
        }
        //将数据写出到输出流
        workbook.write(outputStream);
        return true;
    }
}
