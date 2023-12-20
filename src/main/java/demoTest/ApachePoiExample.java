package demoTest;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApachePoiExample {
    public static void main(String[] args) {
        try {
            // 从现有Word模板文件创建XWPFDocument对象
            String inputFilePath = "input_template.docx";
            XWPFDocument document = new XWPFDocument(new FileInputStream(inputFilePath));

            // 定义需要替换的变量和值
            Map<String, String> variables = new HashMap<>();
            variables.put("name", "张三");
            variables.put("age", "25");
            variables.put("job", "程序员");

            // 替换模板中的变量（包括表格内的占位符）
            replaceVariables(document, variables);

            // 保存填充后的Word文档
            String outputFilePath = "output_template.docx";
            FileOutputStream out = new FileOutputStream(outputFilePath);
            document.write(out);
            out.close();
            document.close();

            System.out.println("Word文档已成功生成：" + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void replaceVariables(XWPFDocument document, Map<String, String> variables) {
        // 替换段落中的占位符
        List<XWPFParagraph> paragraphs = document.getParagraphs();
        for (XWPFParagraph paragraph : paragraphs) {
            for (XWPFRun run : paragraph.getRuns()) {
                String text = run.getText(0);
                if (text != null) {
                    for (Map.Entry<String, String> entry : variables.entrySet()) {
                        if (text.contains("${" + entry.getKey() + "}")) {
                            text = text.replace("${" + entry.getKey() + "}", entry.getValue());
                            run.setText(text, 0);
                        }
                    }
                }
            }
        }

        // 替换表格中的占位符
        List<XWPFTable> tables = document.getTables();
        for (XWPFTable table : tables) {
            List<XWPFTableRow> rows = table.getRows();
            for (XWPFTableRow row : rows) {
                List<XWPFTableCell> tableCells = row.getTableCells();
                for (XWPFTableCell tableCell : tableCells) {
                    List<XWPFParagraph> tableCellParagraphs = tableCell.getParagraphs();
                    for (XWPFParagraph tableCellParagraph : tableCellParagraphs) {
                        for (XWPFRun run : tableCellParagraph.getRuns()) {
                            String text = run.getText(0);
                            if (text != null) {
                                for (Map.Entry<String, String> entry : variables.entrySet()) {
                                    if (text.contains("${" + entry.getKey() + "}")) {
                                        text = text.replace("${" + entry.getKey() + "}", entry.getValue());
                                        run.setText(text, 0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
           /* for (XWPFTableCell cell : table.getRow(0).getTableCells()) {
                for (XWPFParagraph paragraph : cell.getParagraphs()) {
                    for (XWPFRun run : paragraph.getRuns()) {
                        String text = run.getText(0);
                        if (text != null) {
                            for (Map.Entry<String, String> entry : variables.entrySet()) {
                                if (text.contains("${" + entry.getKey() + "}")) {
                                    text = text.replace("${" + entry.getKey() + "}", entry.getValue());
                                    run.setText(text, 0);
                                }
                            }
                        }
                    }
                }
            }*/
        }
    }
}
