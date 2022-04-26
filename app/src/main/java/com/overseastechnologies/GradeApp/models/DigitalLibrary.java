package com.overseastechnologies.GradeApp.models;

public class DigitalLibrary {
    Integer id;
    Integer std;
    String subject;
    String type;
    String url;

    public DigitalLibrary() {
    }
    public DigitalLibrary(Integer id, Integer std, String subject, String type, String url) {
        this.id = id;
        this.std = std;
        this.subject = subject;
        this.type = type;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStd() {
        return std;
    }
    public void setStd(Integer std) {
        this.std = std;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
