package com.example.local_elections_app.Model;

public class Polls {

    private String psName;       // 선거일투표소명
    private String sdName;       // 시도명
    private String wiwName;      // 위원회명
    private String emdName;      // 읍면동명
    private String placeName;    // 장소명
    private String addr;         // 주소
    private String floor;        // 층수

    public Polls(){}

    public Polls(String psName, String sdName, String wiwName, String emdName, String placeName, String addr, String floor) {
        this.psName = psName;
        this.sdName = sdName;
        this.wiwName = wiwName;
        this.emdName = emdName;
        this.placeName = placeName;
        this.addr = addr;
        this.floor = floor;
    }

    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName;
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

    public String getEmdName() {
        return emdName;
    }

    public void setEmdName(String emdName) {
        this.emdName = emdName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

}
