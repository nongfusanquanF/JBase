package com.geya.jbase.constant;

import android.content.Context;

/**
 * Created by Administrator on 2016/12/10.
 * 常量类
 */

public class RequestType {
    public static Context mContext;

    //网路请求方式
    public static final String OKGO_GET = "GET";
    public static final String OKGO_GET_CACHE = "GET_CACHE";
    public static final String OKGO_POST = "POST";
    public static final String OKGO_POST_FILE = "POST_FILE";
    public static final String OKGO_POST_JSON = "POST_JSON";
    public static final String OKGO_POST_JSON_OBJ = "POST_JSON_OBJ";
    public static final String OKGO_DOWNLOAD = "DOWNLOAD";
    //默认分割线颜色
    public static final int DIVISION_COLOR = 0xfff6f6f6;
    //--------------------本地存储数据名
    //更新标识
    public static final String Version = "Version";
    public static final String EXISTS = " exists";


    /**
     * 服务器地址
     */
    public static final String ADDRESS = "http://www.newzhihuishijiesy.com";



//   ------------------接口地址---------------------------

    public static final String DATA = "/api/app/notice/detail";
    public static final String LIST = "/api/app/notice";
    public static final String LIST2 = "/api/app/live";


    /**
     * 当前页数
     */
    public static final String PAGE_INDEX = "page";

    /**
     * 当前页条目数量
     */
    public static final String PAGE_SIZE = "size";

    //错误状态提示
    public static final String INTERNET_ERROR = "网络连接失败";
    public static final String SERVER_ERROR = "服务器连接失败";
    public static final String DATA_ERROR = "数据解析异常";
    public static final String CONNECT_ERROR = "连接超时";
    public static final int NO_DATA = 100;
    //网络请求的缓存key 按功能区分
    public static final String CACHE_KEY_COMMON = "COMMON";//普通
    public static final String CACHE_KEY_ORDINARY = "ORDINARY";//一般
    public static final String CACHE_KEY_IMPORTANCE = "IMPORTANCE";//重要
    public static final String CACHE_KEY_SENSITIVITY = "SENSITIVITY";//敏感
    //于服务器约定的字段名
    public static final String IS_SUCCESS = "retcode";//此次访问，服务器是否通过
    public static final String MESSAGE = "massage";//服务器消息（失败原因等）
    public static final String LIST_DATAS = "data";//列表数据所在字段Key

}