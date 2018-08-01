package com.geya.jbase.mvp.model;

import com.lzy.okgo.cache.CacheMode;

import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: IBaseModel
 * @author create by Tang
 * @date date 16/9/29 上午11:26
 * @Description: Model基础接口 （如有需要可以扩展缓存模式的设置方法）
 */
public interface IBaseModel {

    /**
     * 向服务器发起请求
     */
    void sendRequestToServers(String method, String url, Class obj , HashMap<String,String> map);

    /**
     *  设置Url接口
     * @param apiInterface
     */


    /**
     * 设置服务器地址
     * @param address
     */


    /**
     *  设置请求方式 GET POST。。。
     * @param method
     */


    /**
     *   设置请求标识
     * @param identify
     */


    /**
     * 设置缓存模式
     * @param cachemode
     */

    /**
     * 设置当前网络请求缓存key
     * @param cacheKey
     */


    /**
     *  取消请求
     */
    void cancelRequest(String type);

    /**
     *  Activity 终止时 释放资源
     *   此方法由View调用
     */
    void dealloc();


    void setClassTyer(Class obj);


}
