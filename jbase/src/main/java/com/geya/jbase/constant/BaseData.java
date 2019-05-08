package com.geya.jbase.constant;

/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class BaseData {

    /**
     * retcode : -1
     * massage : 登录失败！
     */

    private String retcode;
    private String message;

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getMassage() {
        return message;
    }

    public void setMassage(String massage) {
        this.message = massage;
    }


    public String getCodes(){
        return retcode+"".trim();
    }

}
