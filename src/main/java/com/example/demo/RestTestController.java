package com.example.demo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestTestController {

    @GetMapping("/jsonapi/element")
    public String elementJson() {
        StringBuffer result = new StringBuffer();
        String jsonString = null;
        //List<String> element_list = new ArrayList<>();

        try {
            //초등학교
            String  apiUrl = "https://open.neis.go.kr/hub/" +
                             "schoolInfo?SCHUL_KND_SC_NM=%EC%B4%88%EB%93%B1%ED%95%99%EA%B5%90&KEY=97e7f2f26edc450da3111af6608c18ef"+
                             "&pIndex=1&pSize=1000"+
                             "&KEY=97e7f2f26edc450da3111af6608c18ef";;

            List<String> schl_list = CallAPI(apiUrl);
            count(schl_list);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    @GetMapping("/jsonapi/middle")
    public String callApiWithJson() {
        StringBuffer result = new StringBuffer();
        String jsonString = null;
        List<String> middle_list = new ArrayList<>();
        try {
             //중학교
            String  apiUrl = "https://open.neis.go.kr/hub/" +
                    "schoolInfo?SCHUL_KND_SC_NM=%EC%A4%91%ED%95%99%EA%B5%90&KEY=97e7f2f26edc450da3111af6608c18ef"+
                    "&pIndex=1&pSize=1000"+
                    "&KEY=97e7f2f26edc450da3111af6608c18ef";;

            List<String> schl_list = CallAPI(apiUrl);
            count(schl_list);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    @GetMapping("/jsonapi/high")
    public String highJson(){
        StringBuffer result = new StringBuffer();
        String jsonString = null;
        List<String> high_list = new ArrayList<>();
        try {
            //고등학교
            String  apiUrl = "https://open.neis.go.kr/hub/schoolInfo?" +
                    "SCHUL_KND_SC_NM=%EA%B3%A0%EB%93%B1%ED%95%99%EA%B5%90" +
                    "&pIndex=1&pSize=1000"+
                    "&KEY=97e7f2f26edc450da3111af6608c18ef";

            List<String> schl_list = CallAPI(apiUrl);
            count(schl_list);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    public static List<String> CallAPI(String apiUrl)  {

            StringBuffer result = new StringBuffer();
            String jsonString = null;
            List<String> schllist = new ArrayList<>();

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
            String returnLine;
            while ((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine);
            }
            JSONObject jsonObject = XML.toJSONObject(result.toString());
            jsonString = jsonObject.toString();
            JSONObject jObject = new JSONObject(jsonString);
            JSONObject schoolInfo = jObject.getJSONObject("schoolInfo");
            JSONArray row = schoolInfo.getJSONArray("row");
            for(int i=0; i< row.length(); i++) {
                JSONObject rows = (JSONObject) row.get(i);
                String schl_Nm = (String) rows.get("SCHUL_NM");
                schllist.add(schl_Nm);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return schllist;
    }

    public void count(List<String> schl_list ){

        try {
            String text = FileReadUsingSpring.FileRead();

            for (String str :schl_list){
                ArrayList a_list = new ArrayList();
                if(text.contains(str)) {
                    for(int i=0; i<text.length(); i++) {
                        if(text.charAt(i) == str.charAt(0)) {
                            a_list.add(i); //a 문자 인덱스값을 배열에 담는다
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


}

