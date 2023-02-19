package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SchoolCount {

    public static  void ApiCount(List<String> schl_list ){
        try {
            String text = FileReadUsingSpring.FileRead();
            for (String str :schl_list){
                ArrayList a_list = new ArrayList();
                if(text.contains(str)) {
                    for(int i=0; i<text.length(); i++) {
                        if(text.charAt(i) == str.charAt(0)) {
                            a_list.add(i);
                        }
                    }
                    String pandan = "";
                    int cnt = 0;
                    for(int i=0; i<a_list.size(); i++) {
                        int start_idx = Integer.valueOf(a_list.get(i).toString());
                        if(text.length() >= start_idx+str.length()) {
                            pandan = text.substring(start_idx, start_idx + str.length());
                            if (pandan.equals(str)) { //자른 문자열이 str 문자열과 같으면
                                cnt++; //str 체크 카운트값을 증가시킨다
                            }
                        }
                    }
                    System.out.println(str +":"+cnt);
                }
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }


    public static void localUnicount(){
        try {
            String text = FileReadUsingSpring.FileRead();
            List<String> uni_name = FileReadUsingSpring.UniFileRead();
            for (String str :uni_name){
                ArrayList a_list = new ArrayList();
                if(text.contains(str)) {
                    for(int i=0; i<text.length(); i++) {
                        if(text.charAt(i) == str.charAt(0)) {
                            a_list.add(i);
                        }
                    }
                    String pandan = "";
                    int cnt = 0;
                    for(int i=0; i<a_list.size(); i++) {
                        int start_idx = Integer.valueOf(a_list.get(i).toString());
                        if(text.length() >= start_idx+str.length()) {
                            pandan = text.substring(start_idx, start_idx + str.length());
                            if (pandan.equals(str)) {
                                cnt++;
                            }
                        }
                    }
                    System.out.println(str +":"+cnt);
                }
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}