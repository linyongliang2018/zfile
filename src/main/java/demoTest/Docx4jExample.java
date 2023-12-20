package demoTest;

import org.docx4j.Docx4J;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.*;

public class Docx4jExample {
    public static void main(String[] args) {
        try {
            // 创建一个WordprocessingMLPackage对象
            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.createPackage();

            // 获取主文档部分
            MainDocumentPart mainDocumentPart = wordMLPackage.getMainDocumentPart();

            // 创建一个表格并添加到文档中
            Tbl table = createTable();
            mainDocumentPart.addObject(table);

            // 保存生成的Word文档
            String outputFilePath = "application_form.docx";
            Docx4J.save(wordMLPackage, new java.io.File(outputFilePath), Docx4J.FLAG_SAVE_ZIP_FILE);

            System.out.println("Word文档已成功生成：" + outputFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Tbl createTable() {
        // 创建表格对象
        Tbl table = new Tbl();
        Tr tableRow;

        // 表头
        String[] header = {"项目", "内容"};

        // 添加表头行
        tableRow = new Tr();
        for (String headerText : header) {
            Tc tableCell = createTableCell(headerText);
            tableRow.getContent().add(tableCell);
        }
        table.getContent().add(tableRow);

        // 申请表内容
        String[][] data = {
                {"姓名", "张三"},
                {"年龄", "25"},
                {"职业", "程序员"},
                {"申请理由", "我想参加这个培训课程，以提升我的技能。"}
        };

        // 添加数据行
        for (String[] row : data) {
            tableRow = new Tr();
            for (String cellText : row) {
                Tc tableCell = createTableCell(cellText);
                tableRow.getContent().add(tableCell);
            }
            table.getContent().add(tableRow);
        }

        return table;
    }

    private static Tc createTableCell(String content) {
        Tc tableCell = new Tc();
        P paragraph = new P();
        R run = new R();
        Text text = new Text();

        text.setValue(content);
        run.getContent().add(text);
        paragraph.getContent().add(run);
        tableCell.getContent().add(paragraph);

        return tableCell;
    }
}
