package com.overseastechnologies.GradeApp;

import org.json.JSONObject;

public class StudentDetails {
     public JSONObject studentJsonObject;

    public  StudentDetails(JSONObject jsonObject){
        studentJsonObject = jsonObject;
    }

    public StudentDetails() {

    }

    public JSONObject getStudentJsonObject() {
        return studentJsonObject;
    }
}

