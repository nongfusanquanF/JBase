package com.geya.jbase.constant;

import android.app.Application;

import com.geya.jbase.R;
import com.geya.jbase.uiview.ToastUtil;
import com.geya.jbase.utils.GsonUtil;
import com.geya.jbase.utils.ManifestUtil;


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
     * @param stirngCode code 是字符串时成功标识
     * @param intCode  code 是int时成功标识
     */
    public static void init(Application app,
                            String page, String size,boolean isString,
                            String isSuccess, String message, String listData,
                            String againLogin,
                            int mainColor,
                            int imgDrawable,
                            String stirngCode,
                            int intCode

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
        STRING_CODE = stirngCode;
        INT_CODE = intCode;
    }


    /**
     * 上下文
     * @param app 上下文
     * @return
     */
    public RequestType init(Application app) {
        mContext = app;
        ToastUtil.sContext = app;
//        String json=  ManifestUtil.readManifestString(mContext,"j.base.data");
//        System.out.println("-------------- json = " + json);
//        BaseBean bean = GsonUtil.GsonToBean(json,BaseBean.class);
//        System.out.println("----------------------- " + bean.toString());
        return this;
    }

    /**
     * 当前页码
     * @param pageIndex
     * @return
     */
    public RequestType setPageIndex(String pageIndex) {
        PAGE_INDEX = pageIndex;
        return this;
    }

    /**
     * 当前页条目数量
     * @param pageSize
     * @return
     */
    public RequestType setPageSize(String pageSize) {
        PAGE_SIZE = pageSize;
        return this;
    }

    /**
     * 接口是否请求成功 字段是否是字符串
     * @param isString 是字符串（每日true）
     * @return
     */
    public RequestType setIsString(boolean isString) {
        IS_STRING = isString;
        return this;
    }

    /**
     * 接口状态码 字段key
     * @param isSuccess 接口状态码 字段key
     * @return
     */
    public RequestType setIsSuccess(String isSuccess) {
        IS_SUCCESS = isSuccess;
        return this;
    }

    /**
     * 接口消息 字段key
     * @param MESSAGE 接口消息 字段key
     * @return
     */
    public RequestType setMessage(String MESSAGE) {
        RequestType.MESSAGE = MESSAGE;
        return this;
    }

    /**
     * 接口数据 字段key
     * @param listDatas 接口数据 字段key
     * @return
     */
    public RequestType setListDatas(String listDatas) {
        LIST_DATAS = listDatas;
        return this;
    }

    /**
     * 接口 重新登陆 返回码（特定返回值 如-2）
     * @param againLogin
     * @return
     */
    public RequestType setAgainLogin(String againLogin) {
        AGAIN_LOGIN = againLogin;
        return this;
    }

    /**
     * APP 主色调 R.color...
     * @param mainColor  APP 主色调 R.color...
     * @return
     */
    public RequestType setMainColor(int mainColor) {
        MAIN_COLOR = mainColor;
        return this;
    }

    /**
     * APP 头部颜色 0xffff0000
     * @param topBarColor APP 头部颜色 0xffff0000
     * @return
     */
    public  RequestType setTopBarColor(int topBarColor) {
        TOP_BAR_COLOR = topBarColor;
        return this;
    }

    /**
     * 暂无数据 图片资源R...
     * @param imgDrawable 暂无数据 图片资源R...
     * @return
     */
    public RequestType setImgDrawable(int imgDrawable) {
        IMG_DRAWABLE = imgDrawable;
        return this;
    }

    /**
     * 标题字体颜色
     * @param titleColor 标题字体颜色
     * @return
     */
    public RequestType setTitleColor(int titleColor) {
        TITLE_COLOR = titleColor;
        return this;
    }

    /**
     * 副标题字体颜色
     * @param subheadingColor 副标题字体颜色
     * @return
     */
    public RequestType setSubheadingColor(int subheadingColor) {
        SUBHEADING_COLOR = subheadingColor;
        return this;
    }

    /**
     *  返回按钮资源文件
     * @param imgBack 返回按钮资源文件
     * @return
     */
    public RequestType setImgBack(int imgBack) {
        IMG_BACK = imgBack;
        return this;
    }

    /**
     * 服务器地址
     * @param ADDRESS
     * @return
     */
    public RequestType setAddress(String ADDRESS) {
        RequestType.ADDRESS = ADDRESS;
        return this;
    }

    /**
     * code 是字符串时成功标识
     *
     * @param stringCode
     */
    public  RequestType setStringCodes(String stringCode) {
        STRING_CODE = stringCode;
        return this;
    }

    /**
     * code 是int时成功标识
     *
     * @param intCode
     */
    public  RequestType setIntCodes(int intCode) {
        INT_CODE = intCode;
        return this;
    }

    /**
     * 更具后台返回的code判断是否请求成功
     * @param code
     * @return
     */
    public  static boolean  isCode(String code){

        if (IS_STRING) {
            return code.equals(STRING_CODE)?true:false;
        }else {
            return Integer.parseInt(code) == INT_CODE?true:false;
        }

    }



    //网路请求方式
    public static final String OKGO_GET = "GET";
    public static final String OKGO_GET_CACHE = "GET_CACHE";
    public static final String OKGO_POST_CACHE = "POST_CACHE";
    public static final String OKGO_POST = "POST";
    public static final String OKGO_POST_FILE = "POST_FILE";
    public static final String OKGO_GET_JSON = "GET_JSON";
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
    public  static String ADDRESS="";

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
    public static String STRING_CODE = "200";
    public static int INT_CODE = 1;
    public static String IS_SUCCESS = "retcode";//此次访问，服务器是否通过
    public static String MESSAGE = "massage";//服务器消息（失败原因等）
    public static String LIST_DATAS = "data";//列表数据所在字段Key
    public static String AGAIN_LOGIN = "-888";//重新登陆标识
    public static int MAIN_COLOR = 0xffffffff;//主色调
    public static int TOP_BAR_COLOR = 0xffffffff;//主色调
    public static int TITLE_COLOR = 0xff000000;//标题字色
    public static int SUBHEADING_COLOR = 0xff000000;//副标题字色
    public static int IMG_DRAWABLE = R.drawable.nodata;//暂无数据图片
    public static int IMG_BACK = R.mipmap.icon_bac;//暂无数据图片
}