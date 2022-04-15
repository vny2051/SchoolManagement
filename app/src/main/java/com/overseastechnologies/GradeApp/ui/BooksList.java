package com.overseastechnologies.GradeApp.ui;

public class BooksList {

    private String name;
    private String image;
    private String book_url;



    public BooksList() {
    }


    public BooksList(String name, String image, String book_url) {
        this.name = name;
        this.image = image;
        this.book_url = book_url;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getBook_url() {
        return book_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setBook_url(String book_url) {
        this.book_url = book_url;
    }
}



