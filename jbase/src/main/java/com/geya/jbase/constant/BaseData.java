package com.geya.jbase.constant;

/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class BaseData {

    /**
     * retcode : -1
     * massage : 登录失败！
     */

    private int code;
    private String message;

    public int getRetcode() {
        return code;
    }

    public void setRetcode(int retcode) {
        this.code = retcode;
    }

    public String getMassage() {
        return message;
    }

    public void setMassage(String massage) {
        this.message = massage;
    }


    public String getCodes(){
        return code+"".trim();
    }

}
