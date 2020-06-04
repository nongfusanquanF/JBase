package com.appbyme.jbase.mvp.presenter;

import com.appbyme.jbase.data.BaseNewsData;
import com.appbyme.jbase.data.GsonUtil;
import com.appbyme.jbase.data.ListData;
import com.appbyme.jbase.data.ListData2;
import com.appbyme.jbase.data.ObjData;
import com.appbyme.jbase.data.RtData;
import com.appbyme.jbase.data.SpDatas;
import com.appbyme.jbase.mvp.view.IMainView;
import com.geya.jbase.mvp.presenter.BasePresenter;

/**
 * Created by Administrator on 2018/6/8 0008.
 */

public class MainPresenter extends BasePresenter<IMainView> {

    public MainPresenter(IMainView mvpView) {
        super(mvpView);
    }

    @Override
    public void serverResponseObj(Object object) {

        System.out.println("------------ 接口数据 " + object.toString());
        if (object instanceof ListData) {
            getView().getDatas("List     : " + object.toString(), "");
        } else if (object instanceof ObjData) {
            getView().getDatas("Obj      : " + object.toString(), "");
        } else if (object instanceof ListData2) {
            getView().getDatas(GsonUtil.GsonString(((ListData2) object).getData()), "");
        } else if (object instanceof RtData) {
            System.out.println("------------ 接口数据 list " + ((RtData) object).getList().toString());
            getView().getDatas(GsonUtil.GsonString(((RtData) object).getList()), "");
        } else if (object instanceof BaseNewsData) {
            getView().getDatas(GsonUtil.GsonString(((BaseNewsData) object).getList()), "");
        }


    }
}
