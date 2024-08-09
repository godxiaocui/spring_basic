package com.czh.spring;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CsvTest {
public static void main(String[] args) {
    String inputFilePath = "/Users/godxiaocui/Downloads/测试题/测试/login_data.csv";
    String outputFilePath = "/Users/godxiaocui/Downloads/测试题/测试/login_data_out.csv ";

    try {
        // 读取CSV文件
        List<String> lines = Files.readAllLines(Paths.get(inputFilePath), Charset.defaultCharset());

        // 去除表头
        lines.remove(0);

        // 写入CSV文件
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath), StandardCharsets.UTF_8));
        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();

        System.out.println("转换完成！");
    } catch (IOException e) {
        System.out.println("发生错误：" + e.getMessage());
    }
}
}