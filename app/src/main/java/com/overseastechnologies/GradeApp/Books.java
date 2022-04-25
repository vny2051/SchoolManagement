package com.overseastechnologies.GradeApp;

import android.net.Uri;

import java.net.URL;

public class Books {
    Integer id;
    String name;
    URL pdfLink;

    public Books() {
    }
    public Books(Integer id, String name, URL pdfLink) {
        this.id = id;
        this.name = name;
        this.pdfLink = pdfLink;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public URL getPdfLink() {
        return pdfLink;
    }
    public void setPdfLink(URL pdfLink) {
        this.pdfLink = pdfLink;
    }
}
