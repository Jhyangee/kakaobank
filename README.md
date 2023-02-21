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
```java
// Application.java
@SpringBootApplication // 
Class Application {
    public static void main(String[] args)  {...}
}
```
- ResultFile
```java
// ResultFile.java
Class ResultFile {
    public static void ResultFileCreate(){...}
    public static void ResultFIleWrite(){...}
}
```
- RestController
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
```java
//CSVRead.java
Class SchoolCount {
    public static void ApiCount(List<String> schllist ){...}
    public static void localUnicount(){...}
```
- CsvRead
```java
//CSVRead.java
Class CsvRead {
    public static String csvRead(){...}
    public static String uniCsvRead(){...}
```

## Solution
1.CSV handling
2.유효한 학교 Data handling
3.result.txt 생성
4.result.log 생성
5.ERROR handling




