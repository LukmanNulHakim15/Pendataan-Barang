package com.example.Versi11.With.Validation.response;


import java.util.ArrayList;
import java.util.List;

public class CommonResponse<T> {

    private String status;
    private String massage;
    private T datas;



    public CommonResponse(){

    }

    public CommonResponse(String status, String massage, T datas) {
        this.status = status;
        this.massage = massage;
        this.datas = datas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }
}
