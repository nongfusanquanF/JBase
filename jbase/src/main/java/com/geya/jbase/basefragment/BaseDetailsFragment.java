package com.geya.jbase.basefragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.geya.jbase.R;
import com.geya.jbase.mvp.presenter.BasePresenter;
import com.geya.jbase.mvp.view.IMvpView;
import com.geya.jbase.uiview.LoadDialog;


/**
 * Created by jiang on 2017/6/20.
 *  懒加载
 */

public abstract class BaseDetailsFragment<P extends BasePresenter> extends LazyTabFragment implements IMvpView {



    /**
     *  Presenter实现类
     */
    protected P mPresenter;
    /**
     * XML文件id
     */
    protected View mView;

    protected ImageView btn_img;
    protected TextView tv_title;
    protected TextView tv_title2;

    /**
     *  初始化P
     * @return
     */
    public abstract P newPresenter();

    /**
     * 初始化布局文件
     */
    public abstract int inflateCreateView();

    public abstract void initDatas(View view);

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        mView=View.inflate(getActivity(),inflateCreateView(),null);
        setContentView(mView);

        if (rootView != null) {
            mPresenter=newPresenter();
            initTitle(mView);
            initDatas(mView);
        }

    }

    //    @Override
//    public View initViews() {
//        mView=View.inflate(mActivity,setContentView(),null);
//        mPresenter=newPresenter();
//        return mView;
//    }
//
//    @Override
//    public void initData() {
//        super.initData();
//    }


    @Override
    public void showSucceed(boolean isSucceed) {

    }

    @Override
    public void getDatas(String json, String type) {

    }

    @Override
    public void showProgress(boolean show) {
        if (show) {
            LoadDialog.show(getActivity());
        }else{
            LoadDialog.dismiss(getActivity());
        }
    }

    @Override
    public void showNetworkError(int errorCode, String errorDesc, String type) {
        Toast.makeText(getActivity(),errorDesc,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showServerError(int errorCode, String errorDesc) {

    }
    public void initTitle(View view){
        if (view.findViewById(R.id.tv_title)!=null){
            btn_img=  view.findViewById(R.id.img_btn);
            tv_title=  view.findViewById(R.id.tv_title);
            tv_title2=  view.findViewById(R.id.tv_title2);
        }
    }
}
