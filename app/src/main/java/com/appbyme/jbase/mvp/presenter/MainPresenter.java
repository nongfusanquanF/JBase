package com.appbyme.jbase.mvp.presenter;

import com.appbyme.jbase.data.GsonUtil;
import com.appbyme.jbase.data.ListData;
import com.appbyme.jbase.data.ListData2;
import com.appbyme.jbase.data.ObjData;
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
        if (object instanceof ListData){
            getView().getDatas("List     : " + object.toString(),"");
        }else if (object instanceof ObjData){
            getView().getDatas("Obj      : " + object.toString(),"");
        }else if (object instanceof ListData2){
            getView().getDatas(GsonUtil.GsonString(((ListData2) object).getData()),"");
        }
        else {
            getView().getDatas(object.toString(),"");
        }


    }
}
