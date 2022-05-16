package com.example.Versi11.With.Validation.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseValidation <T> {

    //private String status;

    private List<String> responseVal = new ArrayList<>();

   // private T payload;
    //payload ini tempat menampung seleuruhan data seperti datas di package response

//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    public List<String> getResponseVal() {
        return responseVal;
    }

    public void setResponseVal(List<String> responseVal) {
        this.responseVal = responseVal;
    }

//    public T getPayload() {
//        return payload;
//    }
//
//    public void setPayload(T payload) {
//        this.payload = payload;
//    }
}
