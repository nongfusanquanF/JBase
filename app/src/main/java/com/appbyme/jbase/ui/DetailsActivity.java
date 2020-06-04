package com.appbyme.jbase.ui;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.appbyme.jbase.Event.EventMsg;
import com.appbyme.jbase.R;
import com.appbyme.jbase.data.CheckData;
import com.appbyme.jbase.data.ListData;
import com.appbyme.jbase.databinding.ActivityDetailBinding;
import com.appbyme.jbase.mvp.presenter.MainPresenter;
import com.appbyme.jbase.mvp.view.IMainView;
import com.geya.jbase.baseactivity.BaseDetailsActivity;
import com.geya.jbase.constant.RequestType;
import com.geya.jbase.mvp.view.IokgoCallback;
import com.geya.jbase.uiview.ToastUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/6/8 0008.
 */

public class DetailsActivity extends BaseDetailsActivity<MainPresenter> implements IMainView {

   private ActivityDetailBinding mBinding;

    @Override
    public MainPresenter newPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void init() {
        mTitleButton.setrImgSrc(R.mipmap.icon_bac);
        mTitleButton.setImgReturn(R.mipmap.icon_bac, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showShort("关闭");
                mTitleButton.setImgReturnVisibility(View.GONE);
            }
        });
        mTitleButton.setImgReturnVisibility(View.VISIBLE);

        mTitleButton.setMainColor(0xffff0000);
        mTitleButton.setTitles("首页首页首页首页首页首页首页首页首页首页首页首页首页首页");
        mTitleButton.setRButtonText("保存");



         mBinding.post.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 HashMap<String,String> map = new HashMap<>();
                 map.put("uid","7826");
                 map.put("_token","47e2b91bf3efa5adacfd2e1920e0c030");
                 mPresenter.accessServers(RequestType.OKGO_GET, RequestType.ADDRESS, RequestType.LIST, ListData.class,map);
                 EventBus.getDefault().post(new EventMsg("EventBus消息回传"));
             }
         });

         mBinding.get.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 HashMap<String,String> map = new HashMap<>();
                 map.put("uid","7826");
                 map.put("_token","47e2b91bf3efa5adacfd2e1920e0c030");
//                 map.put("id","5");
                 mPresenter.accessServers(RequestType.OKGO_GET, "http://www.syiptv.com/api/v1", "/version/check", CheckData.class, map, new IokgoCallback() {
                     @Override
                     public void onSucceed(Object object) {
                         mBinding.tvText.setText(object.toString());
                         if (object instanceof  CheckData){
                             System.out.println("----------- " + (((CheckData) object).getRetcode()+100));
                         }

                     }
                 });
             }
         });
    }

    @Override
    public void setContentView() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
    }

    @Override
    public void getDatas(String json, String type) {
          mBinding.tvText.setText(json);
    }
}
