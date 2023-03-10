package com.kakao.school;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



public class JsonParsing {
    private static final Logger logger = LoggerFactory.getLogger(ResultFile.class);

    public static void CallAPI(String apiUrl)  {
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
            SchoolCount.ApiCount(schllist);
        } catch (IOException e) {
            //**에러사항 발행을 위해 대학교 api 호출시 에러발생
            //1. runtimeException처리
            //  throw new RuntimeException(e);
            //2.로컬에서 파일 긁어오기
             SchoolCount.localCount();
        }
    }
}