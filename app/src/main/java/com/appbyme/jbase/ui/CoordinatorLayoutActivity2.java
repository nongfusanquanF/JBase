package com.appbyme.jbase.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.appbyme.jbase.R;
import com.appbyme.jbase.databinding.ActivityCoorBinding;
import com.appbyme.jbase.mvp.presenter.TestPresenter;
import com.appbyme.jbase.mvp.view.ITestV;
import com.geya.jbase.baseactivity.BaseDetailsActivity;

public class CoordinatorLayoutActivity2 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coor);
    }

    //    private ActivityCoorBinding mBinding;
//
//    @Override
//    public TestPresenter newPresenter() {
//        return new TestPresenter(this);
//    }
//
//    @Override
//    public void init() {
//
//    }
//
//    @Override
//    public void setContentView() {
//        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_coor);
//    }
}
