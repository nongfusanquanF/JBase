package com.appbyme.jbase.ui;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;

import com.appbyme.jbase.R;
import com.appbyme.jbase.adapter.ViewPageAdapter;
import com.appbyme.jbase.databinding.ActivityCoordinatorlayoutBinding;
import com.appbyme.jbase.mvp.presenter.TestPresenter;
import com.appbyme.jbase.mvp.view.ITestV;
import com.geya.jbase.baseactivity.BaseDetailsActivity;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.slidebar.LayoutBar;
import com.shizhefei.view.indicator.slidebar.ScrollBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorLayoutActivity extends BaseDetailsActivity<TestPresenter> implements ITestV {

    private ActivityCoordinatorlayoutBinding mBinding;
    private List<String> mNames = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();
    private IndicatorViewPager indicatorViewPager;


    @Override
    public TestPresenter newPresenter() {
        return new TestPresenter(this);
    }

    @Override
    public void init() {
        initTopBar();
    }

    @Override
    public void setContentView() {
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_coordinatorlayout);
    }

    private void initTopBar() {
        mNames.add("全部");
        mNames.add("审核中");
        mNames.add("未通过");


        mFragmentList.add(new ListFragment());
        mFragmentList.add(new ListFragment());
        mFragmentList.add(new ListFragment());


        mBinding.moretabIndicator.setScrollBar(new LayoutBar(this, R.layout.j_bar_img, ScrollBar.Gravity.CENTENT));

        mBinding.moretabIndicator.setOnTransitionListener(new OnTransitionTextListener()
                .setColor(0xFF2A81F3, 0xFF393A52)
                .setSize(18,16)
        );
        mBinding.moretabIndicator.setSplitAuto(false);//自动布局 长度超过后滑动
        mBinding.webPager.setOffscreenPageLimit(3);
        indicatorViewPager = new IndicatorViewPager(mBinding.moretabIndicator, mBinding.webPager);
        indicatorViewPager.setAdapter(new ViewPageAdapter(getSupportFragmentManager(), this, mNames, mFragmentList));
        mBinding.webPager.setCurrentItem(0);
    }
}
