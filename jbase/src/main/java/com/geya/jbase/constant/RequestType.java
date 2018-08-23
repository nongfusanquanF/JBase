package com.geya.jbase.constant;

import android.app.Application;

import com.geya.jbase.R;
import com.geya.jbase.uiview.ToastUtil;


/**
 * Created by Administrator on 2016/12/10.
 * 常量类
 */

public class RequestType {

    public static Application mContext;



    public static RequestType getInstance() {
        return RequestTypeHolder.holder;
    }

    private static class RequestTypeHolder {
        private static RequestType holder = new RequestType();
    }

    /***
     *
     * @param app   全局上下文
     * @param page  列表条数字段名
     * @param size  列表数量字段名
     * @param isString isSuccess 是否是字符串
     * @param isSuccess 服务器是否请求成功字段名
     * @param message   错误消息字段名
     * @param listData  具体数据字段名
     * @param againLogin 如果需要动过接口控制是否登录(重新登陆错误吗 int)
     * @param mainColor  主色调
     * @param imgDrawable 暂无数据图片
     */
    public static void init(Application app,
                            String page, String size,boolean isString,
                            String isSuccess, String message, String listData,
                            String againLogin,
                            int mainColor,
                            int imgDrawable

    ) {
        mContext = app;
        ToastUtil.sContext = app;
        PAGE_INDEX = page;
        PAGE_SIZE = size;
        IS_SUCCESS = isSuccess;
        MESSAGE = message;
        LIST_DATAS = listData;
        AGAIN_LOGIN = againLogin;
        MAIN_COLOR = mainColor;
        if (imgDrawable !=0) {
            IMG_DRAWABLE = imgDrawable;
        }
        IS_STRING = isString;
    }


    public RequestType init(Application app) {
        mContext = app;
        ToastUtil.sContext = app;
        return this;
    }

    public RequestType setPageIndex(String pageIndex) {
        PAGE_INDEX = pageIndex;
        return this;
    }

    public RequestType setPageSize(String pageSize) {
        PAGE_SIZE = pageSize;
        return this;
    }

    public RequestType setIsString(boolean isString) {
        IS_STRING = isString;
        return this;
    }

    public RequestType setIsSuccess(String isSuccess) {
        IS_SUCCESS = isSuccess;
        return this;
    }

    public RequestType setMESSAGE(String MESSAGE) {
        RequestType.MESSAGE = MESSAGE;
        return this;
    }

    public RequestType setListDatas(String listDatas) {
        LIST_DATAS = listDatas;
        return this;
    }

    public RequestType setAgainLogin(String againLogin) {
        AGAIN_LOGIN = againLogin;
        return this;
    }

    public RequestType setMainColor(int mainColor) {
        MAIN_COLOR = mainColor;
        return this;
    }

    public  RequestType setTopBarColor(int topBarColor) {
        TOP_BAR_COLOR = topBarColor;
        return this;
    }

    public RequestType setImgDrawable(int imgDrawable) {
        IMG_DRAWABLE = imgDrawable;
        return this;
    }

    public RequestType setTitleColor(int titleColor) {
        TITLE_COLOR = titleColor;
        return this;
    }

    public RequestType setSubheadingColor(int subheadingColor) {
        SUBHEADING_COLOR = subheadingColor;
        return this;
    }

    public RequestType setImgBack(int imgBack) {
        IMG_BACK = imgBack;
        return this;
    }

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
    public static final String ADDRESS="http://www.newzhihuishijiesy.com";
    public static final String ADDRESS2="http://www.newzhihuishijiesy.com";
//    public static final String ADDRESS="http://www.syiptv.com/api/v2/";

    //    /**
//     *     ------------------接口地址---------------------------
//     */
    public static final String DETECTIONUPDATE="paper/index/news/?id=13";
    //    //首页商品列表
    public static final String HOME_GOOD_LIST="paper/index/page";
    //    //首页店铺列表
    public static final String HOME_SHOP_LIST="/api/app/lesson";
    public static final String LIST2="/api/app/lesson";
    public static final String LIST="/api/app/lesson";
    public static final String DATA="/api/app/lesson";


    /**
     * 当前页数
     */
    public static String PAGE_INDEX = "";

    /**
     * 当前页条目数量
     */
    public static String PAGE_SIZE = "";

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
    //于服务器约定的字段名
    public static boolean IS_STRING = true;
    public static String IS_SUCCESS = "retcode";//此次访问，服务器是否通过
    public static String MESSAGE = "massage";//服务器消息（失败原因等）
    public static String LIST_DATAS = "data";//列表数据所在字段Key
    public static String AGAIN_LOGIN = "-888";//重新登陆标识
    public static int MAIN_COLOR = 0xffffffff;//主色调
    public static int TOP_BAR_COLOR = 0xffffffff;//主色调
    public static int TITLE_COLOR = 0xff000000;//标题字色
    public static int SUBHEADING_COLOR = 0xff000000;//标题字色
    public static int IMG_DRAWABLE = R.drawable.nodata;//暂无数据图片
    public static int IMG_BACK = R.mipmap.icon_bac;//暂无数据图片
}