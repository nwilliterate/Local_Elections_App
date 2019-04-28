package com.example.local_elections_app.Model;

public class Params {
    private int sgTypeCode;
    private String sdName, sggName;
    private int prmTypeCode;

    public Params(int sgTypeCode, String sdName, String sggName, int prmTypeCode) {
        this.sgTypeCode = sgTypeCode;
        this.sdName = sdName;
        this.sggName = sggName;
        this.prmTypeCode = prmTypeCode;
    }

    public Params(int sgTypeCode, String sdName, String sggName) {
        this.sgTypeCode = sgTypeCode;
        this.sdName = sdName;
        this.sggName = sggName;
    }

    public int getSgTypeCode() {
        return sgTypeCode;
    }

    public String getSdName() {
        return sdName;
    }

    public String getSggName() {
        return sggName;
    }

    public void setSgTypeCode(int sgTypeCode) {
        this.sgTypeCode = sgTypeCode;
    }

    public void setSdName(String sdName) {
        this.sdName = sdName;
    }

    public void setSggName(String sggName) {
        this.sggName = sggName;
    }
}