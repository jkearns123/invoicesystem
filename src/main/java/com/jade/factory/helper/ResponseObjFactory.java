package com.jade.factory.helper;

import com.jade.domain.helper.ResponseObj;

public class ResponseObjFactory {

    public static ResponseObj buildResponseObj(String responseCode,String responseDescription){
        return new ResponseObj(responseCode,responseDescription);
    }
}
