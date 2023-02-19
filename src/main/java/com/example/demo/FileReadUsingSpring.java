package com.example.demo;

import org.springframework.util.ResourceUtils;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReadUsingSpring {

    public static String FileRead() throws IOException {
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "comments.csv");
        List<String> lines = Files.readAllLines(file.toPath());
        String text = lines.toString();
        text = text.replaceAll("[^ㄱ-힣]", ""); //한글이외모두제거
       return text;
    }

    public static List<String> UniFileRead() throws IOException {
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "uni_name.csv");
        List<String> lines = Files.readAllLines(file.toPath());
        List<String> unilist = new ArrayList<>();
        for (String item : lines){
            if(!unilist.contains(item)){
                unilist.add(item);
            }
        }
        return unilist;
    }
}