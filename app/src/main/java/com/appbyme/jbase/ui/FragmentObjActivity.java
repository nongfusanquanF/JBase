package com.appbyme.jbase.ui;

import com.appbyme.jbase.R;
import com.appbyme.jbase.mvp.presenter.MainPresenter;
import com.appbyme.jbase.mvp.view.IMainView;
import com.geya.jbase.baseactivity.BaseDetailsActivity;

/**
 * Created by Administrator on 2018/6/8 0008.
 */

public class FragmentObjActivity extends BaseDetailsActivity<MainPresenter> implements IMainView{

    @Override
    public MainPresenter newPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void init() {

    }

    @Override
    public void setContentView() {
         setContentView(R.layout.activity_detail_fragment);
    }
}
