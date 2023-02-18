package com.example.demo;

import org.springframework.util.ResourceUtils;
import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class FileReadUsingSpring {

    public static String FileRead() throws IOException {
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "comments.csv");
        List<String> lines = Files.readAllLines(file.toPath());
        String text = lines.toString();
        text = text.replaceAll("[^ㄱ-힣]", ""); // 모두 제거
        //System.out.println(">>>>"+text);
       return text;
    }
}