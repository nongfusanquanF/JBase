package com.appbyme.jbase.mvp.presenter;


import android.support.v4.app.Fragment;

import com.appbyme.jbase.mvp.view.ITestV;
import com.geya.jbase.mvp.presenter.BasePresenter;
import com.shizhefei.view.indicator.IndicatorViewPager;

import java.util.ArrayList;
import java.util.List;

public class TestPresenter extends BasePresenter<ITestV> {

    private List<String> mNames = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();
    private IndicatorViewPager indicatorViewPager;

    public TestPresenter(ITestV mvpView) {
        super(mvpView);
    }

    @Override
    public void serverResponseObj(Object o) {



    }
}
