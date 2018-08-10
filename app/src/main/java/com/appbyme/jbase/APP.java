package com.appbyme.jbase;

import android.app.Application;

import com.geya.jbase.constant.RequestTypes;
import com.lzy.okgo.OkGo;

public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        OkGo.getInstance().init(this);
        RequestTypes.init(this,"page","size",false,"retcode","massage","data",
                "-888",
                R.color.white,0);
    }
}
