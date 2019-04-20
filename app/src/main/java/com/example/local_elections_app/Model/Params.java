package com.example.local_elections_app.Model;

public class Params {
    int sgTypeCode;
    String sdName, sggName;

    public Params(int sgTypeCode, String sdName, String sggName) {
        this.sgTypeCode = sgTypeCode;
        this.sdName = sdName;
        this.sggName = sggName;
    }

    public int getSgTypecode() {
        return sgTypeCode;
    }

    public String getSdName() {
        return sdName;
    }

    public String getSggName() {
        return sggName;
    }

    public void setSgTypecode(int sgTypeCode) {
        this.sgTypeCode = sgTypeCode;
    }

    public void setSdName(String sdName) {
        this.sdName = sdName;
    }

    public void setSggName(String sggName) {
        this.sggName = sggName;
    }
}