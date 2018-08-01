package com.geya.jbase.baseactivity;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.geya.jbase.R;
import com.gyf.barlibrary.ImmersionBar;


/**
 * Created by Administrator on 2017/2/15.
 *   Acticity用基类
 *   功能：沉浸式状态栏，统一管理屏幕方向
 *
 */

public  class BaseFragmentActivity extends FragmentActivity {

    //导航栏
    protected ImageView btn_img;
    protected TextView tv_title;
    protected TextView tv_title2;

    protected ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarColor(R.color.main_tone);
//        mImmersionBar.statusBarDarkFont(true, 0.2f) ;
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
        if (findViewById(R.id.tv_title)!=null){
            btn_img= (ImageView) findViewById(R.id.img_btn);
            tv_title= (TextView) findViewById(R.id.tv_title);
            tv_title2= (TextView) findViewById(R.id.tv_title2);
            btn_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

}
