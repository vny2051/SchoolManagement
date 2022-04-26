package com.overseastechnologies.GradeApp.models;

public class Liveclass {
            private String  subjectName;
            private String  coverImage;
            private String  classUrl;

            public Liveclass(){}
            public Liveclass(String subjectName,String coverImage,String classUrl){

                this.subjectName= subjectName;
                this.coverImage=coverImage;
                this.classUrl=classUrl;

            }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getClassUrl() {
        return classUrl;
    }

    public void setClassUrl(String classUrl) {
        this.classUrl = classUrl;
    }
}
