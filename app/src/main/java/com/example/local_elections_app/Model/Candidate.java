package com.example.local_elections_app.Model;

/*JSON 양식
"num": "",
"sgId":"",
"sgTypecode":"",
"huboid":"",
"sggName":"",
"sdName":"",
"wiwName":"",
"giho":"",
"gihoSangse":,
"jdName":"",
"name":"",
"hanjaName":";",
"gender":"",
"birthday":"",
"age":"",
"addr":"",
"jobId":"",
"job":"",
"eduId":"",
"edu":" ",
"career1":"",
"career2":"",
"status":""
*/

public class Candidate {
    public int sgTypecode;     // 선거종류코드
    public int huboid;         // 후보자 ID
    public String sggName;     // 선거구명
    public String sdName;      // 시도명  (대선, 비례국선 : 전국으로 표기 그 외 : 선거구를 관할하는 시도명)
    public String wiwName;     // 구시군명(대선, 비례국선 : 전국으로 표기 그 외 : 선거구를 관할하는 시도명)
    public int giho;           // 후보자 기호 (비례대표는 추천순위)
    public String gihoSangse;  // 후보자 기호상세((구시군의원만 해당) 가, 나, …)
    public String jdName;      // 후보자 정당명
    public String name;        // 후보자 이름
    public String gender;      // 후보자 성별
    public int birthday;       // 후보자 생년월일(YYYYMMDD)
    public int age;            // 후보자 연령
    public String addr;        // 후보자 주소
    public String job;         // 후보자 직업
    public String edu;         // 후보자 학력
    public String career1;     // 후보자 경력1
    public String career2;     // 후보자 경력2

    public Candidate(){

    }
}
