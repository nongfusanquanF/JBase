package com.geya.jbase.constant;

import android.text.TextUtils;

/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class BaseData {

    /**
     * retcode : -1
     * massage : 登录失败！
     */

    private String retcode;
    private int code;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }


    public void setMassage(String massage) {
        this.message = massage;
    }


    public String getCodes(){

        return retcode+"".trim();
    }

    public boolean isSuccess(){
        if (TextUtils.isEmpty(retcode)){
            return code == 0;
        }else {
            return retcode.equals("200");
        }
    }




}
