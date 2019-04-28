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
    private int sgTypecode;     // 선거종류코드
    private int huboid;         // 후보자 ID
    private String sggName;     // 선거구명
    private String sdName;      // 시도명  (대선, 비례국선 : 전국으로 표기 그 외 : 선거구를 관할하는 시도명)
    private String wiwName;     // 구시군명(대선, 비례국선 : 전국으로 표기 그 외 : 선거구를 관할하는 시도명)
    private int giho;           // 후보자 기호 (비례대표는 추천순위)
    private String gihoSangse;  // 후보자 기호상세((구시군의원만 해당) 가, 나, …)
    private String jdName;      // 후보자 정당명
    private String name;        // 후보자 이름
    private String gender;      // 후보자 성별
    private int birthday;       // 후보자 생년월일(YYYYMMDD)
    private int age;            // 후보자 연령
    private String addr;        // 후보자 주소
    private String job;         // 후보자 직업
    private String edu;         // 후보자 학력
    private String career1;     // 후보자 경력1
    private String career2;     // 후보자 경력2

    public Candidate(){

    }

    public int getSgTypecode() {
        return sgTypecode;
    }

    public void setSgTypecode(int sgTypecode) {
        this.sgTypecode = sgTypecode;
    }

    public int getHuboid() {
        return huboid;
    }

    public void setHuboid(int huboid) {
        this.huboid = huboid;
    }

    public String getSggName() {
        return sggName;
    }

    public void setSggName(String sggName) {
        this.sggName = sggName;
    }

    public String getSdName() {
        return sdName;
    }

    public void setSdName(String sdName) {
        this.sdName = sdName;
    }

    public String getWiwName() {
        return wiwName;
    }

    public void setWiwName(String wiwName) {
        this.wiwName = wiwName;
    }

    public int getGiho() {
        return giho;
    }

    public void setGiho(int giho) {
        this.giho = giho;
    }

    public String getGihoSangse() {
        return gihoSangse;
    }

    public void setGihoSangse(String gihoSangse) {
        this.gihoSangse = gihoSangse;
    }

    public String getJdName() {
        return jdName;
    }

    public void setJdName(String jdName) {
        this.jdName = jdName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getCareer1() {
        return career1;
    }

    public void setCareer1(String career1) {
        this.career1 = career1;
    }

    public String getCareer2() {
        return career2;
    }

    public void setCareer2(String career2) {
        this.career2 = career2;
    }
}
