package com.geya.jbase.baseactivity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.geya.jbase.R;
import com.geya.jbase.mvp.presenter.BasePresenter;
import com.geya.jbase.mvp.view.IMvpView;
import com.geya.jbase.uiview.LoadDialog;
import com.geya.jbase.uiview.ToastUtil;


/**
 * Created by Administrator on 2017/2/15.
 *    详情类Activity父类，实现IMvpView的基本接口（显示进度条，错误Toast显示等），
 */

public abstract class BaseDetailsActivity<P extends BasePresenter> extends BaseFragmentActivity implements IMvpView {

    /**
     *  Presenter实现类
     */
    protected P mPresenter;
    protected int mContentView=-1;

    //导航栏
    protected ImageView btn_img;
    protected TextView tv_title;
    protected TextView tv_title2;


    public abstract P newPresenter();
    public abstract void init();
    public abstract void setContentView();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView();
        if (mContentView!=-1){
            setContentView(mContentView);
        }
        mPresenter=newPresenter();
        initTitle();
        init();


    }


    /**
     *
     * @param adderss 服务器地址
     * @param url     接口地址
     * @param type    自定义类型
     * @param method   接口类型 POST GET

     */
    protected void requestData(String adderss,String url, String type,String method) {
//
//        mPresenter.getModel().setMethod(method);
//        mPresenter.getModel().setServerAddress(adderss);
//        mPresenter.getModel().setApiInterface(url);
//        mPresenter.getModel().setIdentify(type);
//        mPresennter.initDatas(url, type, queryParams);
        mPresenter.accessServer();//访问服务器

    }


    //网络请求是否成功
    @Override
    public void showSucceed(boolean isSucceed) {

    }

    //是否显示加载进度
    @Override
    public void showProgress(boolean show) {
        if (show) {
            LoadDialog.show(this);
        }else{
            LoadDialog.dismiss(this);
        }

    }

    //网络连接错误
    @Override
    public void showNetworkError(int errorCode, String errorDesc, String type) {
        LoadDialog.dismiss(this);
        ToastUtil.showShort(errorDesc);
//        Toast.makeText(this,errorDesc,Toast.LENGTH_SHORT).show();
    }

    //服务器错误
    @Override
    public void showServerError(int errorCode, String errorDesc) {
        LoadDialog.dismiss(this);
        ToastUtil.showShort(errorDesc);
//        Toast.makeText(this,errorDesc,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {

        if (mPresenter!=null){
            mPresenter.dealloc();
            mPresenter=null;
        }
        super.onDestroy();
    }

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

    @Override
    public void getDatas(String json, String type) {

    }
}
