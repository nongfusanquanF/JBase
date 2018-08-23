package com.appbyme.jbase;

import android.app.Application;


import com.geya.jbase.constant.RequestType;
import com.lzy.okgo.OkGo;

public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        OkGo.getInstance().init(this);
        RequestType.init(this,
                "page","size",
                false,
                "retcode","massage","data",
                "-888",
                R.color.white,
                R.drawable.ic_launcher);
        RequestType.getInstance().init(this)
                .setMainColor(R.color.colorAccent)
                .setTopBarColor(0xff303F9F)
        ;
    }
}
