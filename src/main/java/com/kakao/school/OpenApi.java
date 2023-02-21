package com.kakao.school;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenApi {

    @GetMapping("/jsonapi/element")
    public void elementJson() {
        try {
            //초등학교
            String  apiUrl = "https://open.neis.go.kr/hub/" +
                             "schoolInfo?SCHUL_KND_SC_NM=%EC%B4%88%EB%93%B1%ED%95%99%EA%B5%90&KEY=97e7f2f26edc450da3111af6608c18ef"+
                             "&pIndex=1&pSize=1000"+
                             "&KEY=97e7f2f26edc450da3111af6608c18ef";;
             JsonParsing.CallAPI(apiUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/jsonapi/middle")
    public void callApiWithJson() {
        try {
             //중학교
            String  apiUrl = "https://open.neis.go.kr/hub/" +
                    "schoolInfo?SCHUL_KND_SC_NM=%EC%A4%91%ED%95%99%EA%B5%90&KEY=97e7f2f26edc450da3111af6608c18ef"+
                    "&pIndex=1&pSize=1000"+
                    "&KEY=97e7f2f26edc450da3111af6608c18ef";;
            JsonParsing.CallAPI(apiUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/jsonapi/high")
    public void highJson(){
        try {
            //고등학교
            String  apiUrl = "https://open.neis.go.kr/hub/schoolInfo?" +
                    "SCHUL_KND_SC_NM=%EA%B3%A0%EB%93%B1%ED%95%99%EA%B5%90" +
                    "&pIndex=1&pSize=1000"+
                    "&KEY=97e7f2f26edc450da3111af6608c18ef";
            JsonParsing.CallAPI(apiUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/jsonapi/uni")
    public void  uniJson() {
        try {
            //대학교
            //**에러사항 발행을 위해 대학교 api 호출시 에러발생으로 로컬 파일에서 읽어오도록 설계
            String  apiUrl = "http://api.data.go.kr/openapi/tn_pubr_public_univ_info_api" +
                    "/89XyGNdysmxd%2BvNnCKTqDTWKDbLgY35d1I7a%2BVJHeiHx%2BEfAaP2C5DWLP%2F9KLziiqPX8QT5GRc3GiEHvon8I4g%3D%3D";
             JsonParsing.CallAPI(apiUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

