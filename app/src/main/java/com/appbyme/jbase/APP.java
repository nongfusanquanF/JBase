package com.appbyme.jbase;

import android.app.Application;


import com.geya.jbase.constant.RequestType;
import com.lzy.okgo.OkGo;

public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        OkGo.getInstance().init(this);
//        RequestType.init(this,
//                "page","size",
//                false,
//                "retcode","massage","data",
//                "-888",
//                R.color.white,
//                R.drawable.ic_launcher);
//        RequestType.getInstance().init(this)
//                .setMainColor(R.color.colorAccent)
//                .setTopBarColor(0xff303F9F)
//        ;

        RequestType.getInstance()
                .init(this)
                .setPageIndex("pageIndex")//页码
                .setPageSize("pageSize")//条目数
                .setIsString(false)//后台返回码 是否是字符串
                .setIntCodes(200)
                .setIsSuccess("retcode")//后台返回状态码key
                .setMessage("message")//后台返回消息字段key
                .setListDatas("data")//后台返回数据字段key
                .setAgainLogin("-888")//特定错误码（重新登陆等 可以注册特定广播处理）
                .setMainColor(R.color.colorPrimary)//app主色调
                .setTopBarColor(0xFFee4433) //头部颜色#f10b26
                .setTitleColor(0xFFFFFFFF)//标题颜色
                .setSubheadingColor(0xFFFFFFFF)//副标题颜色
                .setImgDrawable(R.mipmap.ic_launcher)//无数据图片
                .setImgBack(R.mipmap.ic_launcher)//返回按钮图片
                .setAddress("http://www.syiptv.com/api/v1");
    }
}
