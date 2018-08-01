package com.appbyme.jbase.data;

import java.util.List;

/**
 * Created by Administrator on 2018/6/8 0008.
 */

public class BaseList<T> {


    /**
     * retcode : 200
     * massage : 数据读取成功！
     * data : [{"id":5,"title":"欢迎来到智慧世界","content":"<p>欢迎来到智慧世界！<\/p><p><br/><\/p>","type":1,"schoolid":58,"gradeid":0,"classesid":0,"createtime":"2018-06-02 16:52:24"}]
     */

    private int retcode;
    private String massage;
    private List<T> data;

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
