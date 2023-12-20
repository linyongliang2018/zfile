package demoTest;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApachePoiExample1 {
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

            // 替换模板中的变量
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
    }
}
