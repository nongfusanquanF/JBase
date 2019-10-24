package com.appbyme.jbase.ui;

import com.appbyme.jbase.R;
import com.appbyme.jbase.data.CheckData;
import com.appbyme.jbase.data.ListData2;
import com.appbyme.jbase.data.RtDatas;
import com.appbyme.jbase.data.SpDatas;
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

public class ListFragment extends BaseRvFragment<RtDatas.ListBean,MainPresenter> implements IMainView {
    public static String json = "[\n" +

            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +
            "        {\n" +
            "            \"title\": \"张维国主持市委常委会会议:巩固全市平安和谐稳定局面\",\n" +
            "        },\n" +

            "    ]";
    @Override
    public void inflateCreateView() {
        setRootView(R.layout.activity_rvmain);
    }

    @Override
    public void doRequest() {
        initRV(0,0);
        HashMap<String,Object> map = new HashMap<>();
//        map.put("uid","7826");
//        map.put("_token","47e2b91bf3efa5adacfd2e1920e0c030");
//        requestData(RequestType.OKGO_GET, RequestType.ADDRESS, RequestType.LIST2, ListData2.class,map);
//        HashMap<String,Object> map = new HashMap<>();
//        requestData(RequestType.OKGO_GET, "http://www.syiptv.com/api/v4/","news/index", RtDatas.class,map);
//        requestData(RequestType.OKGO_GET,"http://www.syiptv.com/api/v4/", "news/index/videoshot", SpDatas.class,map);
//        requestData(RequestType.OKGO_GET, "http://www.syiptv.com/api/v4/", "news/index", RtDatas.class,null);

        getDatas(json,"");

    }

    @Override
    public MainPresenter newP() {
        return new MainPresenter(this);
    }

    @Override
    public Class setClass() {
        return RtDatas.ListBean.class;
    }

    @Override
    public BaseQuickAdapter initAdapter(List<RtDatas.ListBean> list) {
        return new BaseQuickAdapter<RtDatas.ListBean,BaseViewHolder>(R.layout.item_text,list) {

            @Override
            protected void convert(BaseViewHolder helper, RtDatas.ListBean item) {
                helper.setText(R.id.name,item.getTitle());
            }
        };
    }
}
