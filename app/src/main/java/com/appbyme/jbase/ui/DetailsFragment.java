package com.appbyme.jbase.ui;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.appbyme.jbase.R;
import com.appbyme.jbase.data.ListData;
import com.appbyme.jbase.data.ObjData;
import com.appbyme.jbase.databinding.ActivityDetailBinding;
import com.appbyme.jbase.mvp.presenter.MainPresenter;
import com.appbyme.jbase.mvp.view.IMainView;
import com.geya.jbase.basefragment.BaseDetailsFragment;
import com.geya.jbase.constant.RequestType;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/6/8 0008.
 */

public class DetailsFragment extends BaseDetailsFragment<MainPresenter> implements IMainView {

    private ActivityDetailBinding mBinding;

    @Override
    public MainPresenter newPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public int inflateCreateView() {
        return R.layout.activity_detail;
    }

    @Override
    public void initDatas(View view) {
        mBinding = DataBindingUtil.bind(view);
        mBinding.post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> map = new HashMap<>();
                map.put("uid","7826");
                map.put("_token","47e2b91bf3efa5adacfd2e1920e0c030");
                mPresenter.accessServers(RequestType.OKGO_GET, RequestType.ADDRESS, RequestType.LIST, ListData.class,map);
            }
        });

        mBinding.get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> map = new HashMap<>();
                map.put("uid","7826");
                map.put("_token","47e2b91bf3efa5adacfd2e1920e0c030");
                map.put("id","5");
                mPresenter.accessServers(RequestType.OKGO_GET, RequestType.ADDRESS, RequestType.DATA, ObjData.class,map);
            }
        });
    }

    @Override
    public void getDatas(String json, String type) {
        mBinding.tvText.setText(json);
    }
}
