package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileCreate {

    private static final Logger logger = LoggerFactory.getLogger(FileCreate.class);

    public static void ResultFileCreate(){
        try {
            logger.info("파일신규생성시작");
        File file = new File(ResourceUtils.CLASSPATH_URL_PREFIX + "result.text");

        if (!file.exists()) {
                file.createNewFile();
        }else{
            logger.info("기존파일 삭제후 신규파일 생성");
            file.delete();
            file.createNewFile();
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static  void ResultFIleWrite(String result) {
        try {
        File file = new File(ResourceUtils.CLASSPATH_URL_PREFIX + "result.text");
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter writer = new BufferedWriter(fw);
        // 4. 파일에 쓰기
        writer.append(result+"\n");
        writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}