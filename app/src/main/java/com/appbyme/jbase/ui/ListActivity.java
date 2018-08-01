package com.appbyme.jbase.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.appbyme.jbase.R;
import com.appbyme.jbase.data.ListData;
import com.appbyme.jbase.data.ListData2;
import com.appbyme.jbase.mvp.presenter.MainPresenter;
import com.appbyme.jbase.mvp.view.IMainView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.geya.jbase.baseactivity.BaseRVActivity;
import com.geya.jbase.constant.RequestType;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/6/8 0008.
 */

public class ListActivity extends BaseRVActivity<ListData2.DataBean,MainPresenter> implements IMainView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvmain);
        initBaseView();
        initRV(0,0);
         //124456
        HashMap<String,Object> map = new HashMap<>();
        map.put("uid","7826");
        map.put("_token","47e2b91bf3efa5adacfd2e1920e0c030");
        requestData(RequestType.OKGO_GET,RequestType.ADDRESS,RequestType.LIST2, ListData2.class,map);
    }

    @Override
    public MainPresenter newP() {
        return new MainPresenter(this);
    }

    @Override
    public Class setClass() {
        return ListData2.DataBean.class;
    }

    @Override
    public BaseQuickAdapter initAdapter(List<ListData2.DataBean> list) {
        return new BaseQuickAdapter<ListData2.DataBean,BaseViewHolder>(R.layout.item_text,list) {

            @Override
            protected void convert(BaseViewHolder helper, ListData2.DataBean item) {
                helper.setText(R.id.name,item.getTitle());
            }
        };
    }
}
