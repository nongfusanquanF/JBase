package com.appbyme.jbase.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.appbyme.jbase.R;
import com.appbyme.jbase.data.BaseNewsData;
import com.appbyme.jbase.data.SpDatas;
import com.appbyme.jbase.mvp.presenter.MainPresenter;
import com.appbyme.jbase.mvp.view.IMainView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.geya.jbase.baseactivity.BaseRVActivity;
import com.geya.jbase.baseactivity.BaseRecycleViewActivity;
import com.geya.jbase.constant.RequestType;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/6/8 0008.
 */

public class ListActivity extends BaseRecycleViewActivity<BaseNewsData.ListBeanX,MainPresenter> implements IMainView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvmain);
//        setAutoRefresh(true);
        initBaseView();
//        mTitleButton.setMainColor(0xffFF4081);
        initRV(0,0);
//        setNewsSwitch(false);
         //124456
        HashMap<String,Object> map = new HashMap<>();
//        map.put("uid","7826");
//        map.put("_token","47e2b91bf3efa5adacfd2e1920e0c030");
        requestData(RequestType.OKGO_GET,"http://www.syiptv.com/api/v7/", "news/index", BaseNewsData.class,map);

//        mQuickAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
//            @Override
//            public void onLoadMoreRequested() {
//                onLoadMore();
//            }
//        });
//        mQuickAdapter.setPreLoadNumber(5);


    }

    @Override
    public void getDatas(String json, String type) {
        super.getDatas(json, type);
        mQuickAdapter.loadMoreComplete();
    }

    @Override
    public MainPresenter newP() {
        return new MainPresenter(this);
    }

    @Override
    public Class setClass() {
        return BaseNewsData.ListBeanX.class;
    }

    @Override
    public BaseQuickAdapter initAdapter(List<BaseNewsData.ListBeanX> list) {

        return new BaseQuickAdapter<BaseNewsData.ListBeanX,BaseViewHolder>(R.layout.item_text,list) {
            @Override
            protected void convert(BaseViewHolder helper, BaseNewsData.ListBeanX item) {
                helper.setText(R.id.name,item.getTitle());
            }
        };
    }
}
