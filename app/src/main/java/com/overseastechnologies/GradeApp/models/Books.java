package com.overseastechnologies.GradeApp.models;

public class Books {
    String bId;
    String bName;
    String bUrl;

    public Books() {
    }

    public Books(String bId, String bName, String bUrl) {
        this.bId = bId;
        this.bName = bName;
        this.bUrl = bUrl;
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbUrl() {
        return bUrl;
    }

    public void setbUrl(String bUrl) {
        this.bUrl = bUrl;
    }
}
