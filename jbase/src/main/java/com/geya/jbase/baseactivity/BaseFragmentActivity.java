package com.geya.jbase.baseactivity;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.geya.jbase.R;

import com.geya.jbase.constant.RequestType;

import com.geya.jbase.uiview.TopTitleButton;

import com.gyf.immersionbar.ImmersionBar;


/**
 * Created by Administrator on 2017/2/15.
 *   Acticity用基类
 *   功能：沉浸式状态栏，统一管理屏幕方向
 *
 */

public  class BaseFragmentActivity extends FragmentActivity {

    //导航栏
    protected TopTitleButton mTitleButton;


    protected ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarColor(RequestType.MAIN_COLOR);
        if (RequestType.MAIN_COLOR == R.color.white){
            mImmersionBar.statusBarDarkFont(true, 0.2f) ;
        }
        mImmersionBar.init();   //所有子类都将继承这些相同的属性
        //要使用沉浸式状态栏的话，布局文件要设置fitsSystemWindows = true
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            setTranslucentStatus(true);
//             tintManager = new SystemBarTintManager(this);
//            tintManager.setStatusBarTintEnabled(true);
//            tintManager.setStatusBarTintResource(R.color.app_bg);//通知栏所需颜色
//        }
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    /**
     *  初始化导航栏
     */
    public void initTitle(){

        if (findViewById(R.id.top_title)!=null) {
            mTitleButton = findViewById(R.id.top_title);
            mTitleButton.setBackClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }

}
