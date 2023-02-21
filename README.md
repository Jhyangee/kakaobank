# KAKAOBANK 과제

## 개발환경
>  JDK8
>  SpringBoot
>  Gradle
>  Open API
>  intelliJ
>  Git

## Code
- Application
  프로젝트 시작 클레스
```java
// Application.java
Class Application {
    public static void main(String[] args)  {...}
}
```
- ResultFile
  result.txt 파일 생성 및 쓰기
```java
// ResultFile.java
Class ResultFile {
    public static void ResultFileCreate(){...}
    public static void ResultFIleWrite(){...}
}
```
- RestController
  REST API 호출로 전국의 초중고대학교 데이터 요청
```java
//RestController.java
@RestController
Class RestTestController {
    @GetMapping("/jsonapi/element")
    public void elementJson() {...}
    @GetMapping("/jsonapi/middle")
    public void callApiWithJson() {...}
    @GetMapping("/jsonapi/high")
    public void highJson(){...}
    @GetMapping("/jsonapi/uni")
    public void  uniJson() {...}
```
- JsonParsing
  RESTAPI로 요청받은 JOSNdata파싱
```java
//JsonParsing.java
Class JsonParsing {
    @GetMapping("/jsonapi/element")
    public void elementJson() {...}
    @GetMapping("/jsonapi/middle")
    public void callApiWithJson() {...}
    @GetMapping("/jsonapi/high")
    public void highJson(){...}
    @GetMapping("/jsonapi/uni")
    public void  uniJson() {...}
```
- SchoolCount
  RESTAPI로 요청받은 데이터와 CSV 데이터 비교후 카운팅
```java
//CSVRead.java
Class SchoolCount {
    public static void ApiCount(List<String> schllist ){...}
    public static void localUnicount(){...}
```
- CsvRead
  local에 저장된 CSV 파일 읽기
```java
//CSVRead.java
Class CsvRead {
    public static String csvRead(){...}
    public static String uniCsvRead(){...}
```

## Solution
1.CSV handling
- resources/comments.csv 파일을 toString()으로 읽어 유효한 학교 데이터 추출을 위해
  regex = [^ㄱ-힣] 로 한글 데이터만 추출

2.유효한 학교 Data handling
- 학교종류별(초등학교, 중학교, 고등학교,대학교)로 분리하여 API 호출
- OPEN API
  https://open.neis.go.kr/portal/data/service/selectServicePage.do?page=1&rows=10&sortColumn=&sortDirection=&infId=OPEN17020190531110010104913&infSeq=2
  https://www.data.go.kr/data/15107736/standard.do

3.result.txt 생성
- 유효한 학교 데이터 결과값을 result.txt

4.result.log 생성
- src/resources/llobback-spring.xml에 로그파일설정
- src/resources/log 하위에 result.log 생성

5.ERROR handling
- JsonParsing.java 의 52라인 api 호출시 에러가 발생하면 local 에 저장된
  임의의 csv 파일 읽어 비교하도록 에러처리 




