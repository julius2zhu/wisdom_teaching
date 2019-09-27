package com.julius.wisdom_teaching.util;

import com.julius.wisdom_teaching.domain.entity.ExaminationRecord;
import org.apache.poi.xwpf.usermodel.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author julius.zhu
 * date  2019/9/27
 * time   14:09
 * describe:
 * 处理word的工具类
 */
public interface WordUtil {
    String title = "title";
    String info = "data";
    List<ExaminationRecord> RECORDS = new ArrayList<>();

    /**
     * 读取word中数据
     *
     * @param inputStream 输入流对象
     * @return 标题和数据信息
     * @throws IOException 文件读写异常
     */
    static Map readWord(InputStream inputStream) throws IOException {
        final Map<String, Object> map = new HashMap<>();
        //1.创建对象
        XWPFDocument document = new XWPFDocument(inputStream).getXWPFDocument();
        XWPFParagraph paragraphArray = document.getParagraphArray(0);
        map.put(title, paragraphArray.getText());
        //2.获取所有的表格
        List<XWPFTable> tables = document.getTables();
        //3.不同表格的数据交给不同的方法去处理
        for (int i = 0; i < tables.size(); i++) {
            switch (i) {
                case 0:
                    WordUtil.resolverSingleSelect(tables.get(0));
                    break;
                case 1:
                    WordUtil.resolverMultipleSelect(tables.get(1));
                    break;
                case 2:
                    WordUtil.resolverGap(tables.get(2), 4);
                    break;
                case 3:
                    WordUtil.resolverSimpleQuestion(tables.get(3));
                    break;
            }
        }
        document.close();
        map.put(info, RECORDS);
        return map;
    }

    /**
     * 处理单选题的表格
     *
     * @param table 表格信息对象
     */
    static void resolverSingleSelect(XWPFTable table) {
        //1.获取行信息
        int rowIndex = 1;
        XWPFTableRow row = table.getRow(rowIndex);
        String text = null;
        Double score = 0.0;
        while (row != null) {
            ExaminationRecord record = new ExaminationRecord();
            int cellIndex = 0;
            XWPFTableCell cell = row.getCell(cellIndex);
            while (cell != null) {
                text = cell.getText().trim();
                switch (cellIndex) {
                    case 0:
                        record.setQuestion(text);
                        break;
                    case 1:
                        record.setSelectA(text);
                        break;
                    case 2:
                        record.setSelectB(text);
                        break;
                    case 3:
                        record.setSelectC(text);
                        break;
                    case 4:
                        record.setSelectD(text);
                        break;
                    case 5:
                        record.setCorrect(text);
                        break;
                    case 6:
                        record.setAnalyze(text);
                        break;
                    case 7:
                        try {
                            if (!text.isEmpty()) {
                                score = Double.valueOf(text);
                            }
                        } catch (NumberFormatException e) {
                            throw new RuntimeException("分数输入不正确");
                        }
                        record.setScore(score);
                        break;
                }
                cellIndex++;
                cell = row.getCell(cellIndex);
            }
            record.setQuestionType(1);
            RECORDS.add(record);
            rowIndex++;
            row = table.getRow(rowIndex);
        }
    }

    /**
     * 处理多选题的表格
     *
     * @param table 表格信息对象
     */
    static void resolverMultipleSelect(XWPFTable table) {
        //1.获取行信息
        int rowIndex = 1;
        XWPFTableRow row = table.getRow(rowIndex);
        String text = null;
        Double score = 0.0;
        while (row != null) {
            ExaminationRecord record = new ExaminationRecord();
            int cellIndex = 0;
            XWPFTableCell cell = row.getCell(cellIndex);
            while (cell != null) {
                text = cell.getText().trim();
                switch (cellIndex) {
                    case 0:
                        record.setQuestion(text);
                        break;
                    case 1:
                        record.setSelectA(text);
                        break;
                    case 2:
                        record.setSelectB(text);
                        break;
                    case 3:
                        record.setSelectC(text);
                        break;
                    case 4:
                        record.setSelectD(text);
                        break;
                    case 5:
                        record.setSelectE(text);
                        break;
                    case 6:
                        record.setSelectF(text);
                        break;
                    case 7:
                        record.setCorrect(text);
                        break;
                    case 8:
                        record.setAnalyze(text);
                        break;
                    case 9:
                        try {
                            if (!text.isEmpty()) {
                                score = Double.valueOf(text);
                            }
                        } catch (NumberFormatException e) {
                            throw new RuntimeException("分数输入不正确");
                        }
                        record.setScore(score);
                        break;
                }
                cellIndex++;
                cell = row.getCell(cellIndex);
            }
            record.setQuestionType(2);
            RECORDS.add(record);
            rowIndex++;
            row = table.getRow(rowIndex);
        }
    }


    /**
     * 处理填空题的表格
     *
     * @param table        表格信息对象
     * @param questionType 题目类型
     */
    static void resolverGap(XWPFTable table, Integer questionType) {
        //1.获取行信息
        int rowIndex = 1;
        XWPFTableRow row = table.getRow(rowIndex);
        String text = null;
        Double score = 0.0;
        while (row != null) {
            ExaminationRecord record = new ExaminationRecord();
            int cellIndex = 0;
            XWPFTableCell cell = row.getCell(cellIndex);
            while (cell != null) {
                text = cell.getText().trim();
                switch (cellIndex) {
                    case 0:
                        record.setQuestion(text);
                        break;
                    case 1:
                        record.setCorrect(text);
                        break;
                    case 2:
                        record.setAnalyze(text);
                        break;
                    case 3:
                        try {
                            if (!text.isEmpty()) {
                                score = Double.valueOf(text);
                            }
                        } catch (NumberFormatException e) {
                            throw new RuntimeException("分数输入不正确");
                        }
                        record.setScore(score);
                        break;
                }
                cellIndex++;
                cell = row.getCell(cellIndex);
            }
            record.setQuestionType(questionType);
            RECORDS.add(record);
            rowIndex++;
            row = table.getRow(rowIndex);
        }
    }




    /**
     * 处理简答题的表格
     *
     * @param table 表格信息对象
     */
    static void resolverSimpleQuestion(XWPFTable table) {
        WordUtil.resolverGap(table, 3);
    }
}
