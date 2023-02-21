package com.kakao.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class}) // DB 사용 안함
public class Application {

    public static void main(String[] args)  {

        SpringApplication.run(Application.class, args);
        //결과파일생성
        ResultFile.ResultFileCreate();

    }

}