package com.appbyme.jbase.ui;

import com.appbyme.jbase.R;
import com.appbyme.jbase.data.ListData2;
import com.appbyme.jbase.mvp.presenter.MainPresenter;
import com.appbyme.jbase.mvp.view.IMainView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.geya.jbase.basefragment.BaseRvFragment;
import com.geya.jbase.constant.RequestType;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/6/8 0008.
 */

public class ListFragment extends BaseRvFragment<ListData2.DataBean,MainPresenter> implements IMainView {
    @Override
    public void inflateCreateView() {
        setRootView(R.layout.activity_rvmain);
    }

    @Override
    public void doRequest() {
        initRV(0,0);
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
