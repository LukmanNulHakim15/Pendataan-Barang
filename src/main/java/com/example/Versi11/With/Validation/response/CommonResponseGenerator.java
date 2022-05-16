package com.example.Versi11.With.Validation.response;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
public class CommonResponseGenerator {

    public <T> CommonResponse <T> successResponse (T datas, String massege){
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setStatus("200");
        commonResponse.setMassage(massege);
        commonResponse.setDatas(datas);

        return commonResponse;
    }

    public <T> CommonResponse <T> failedResponse (String massege){
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setStatus("500");
        commonResponse.setMassage(massege);

        return commonResponse;
    }
}
