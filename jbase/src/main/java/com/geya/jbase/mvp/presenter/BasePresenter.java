package com.geya.jbase.mvp.presenter;


import android.content.Intent;

import com.geya.jbase.constant.RequestType;
import com.geya.jbase.mvp.model.IBaseModel;
import com.geya.jbase.mvp.model.OkGoModel;
import com.geya.jbase.mvp.view.IMvpView;
import com.geya.jbase.mvp.view.IokgoCallback;
import com.lzy.okgo.model.HttpHeaders;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/14.
 */

public abstract class BasePresenter<T extends IMvpView> implements IBasePresenter {

    /**
     * 从服务器获取的数据 交由具体子类实现
     */
//    public abstract void serverResponse(String data,String type);
    public abstract void serverResponseObj(Object object);


    private IBaseModel baseModel;

    private WeakReference<T> mvpView;


    private HashMap<String, Object> map;


    public BasePresenter(T mvpView) {
//        this.mvpView = mvpView;
        this.mvpView = new WeakReference<>(mvpView);
        this.baseModel = new OkGoModel(this);
        map = new HashMap<>();
    }

    public T getView() {
        return mvpView.get();
    }

    //访问服务器
    @Override
    public void accessServer() {
        //参数设置完毕后，请求服务器数据
//        mvpView.showProgress(true);//通知View层显示等待界面
//        getModel().sendRequestToServer();//向服务器发送请求

    }
//
//    //服务器成功响应
//    @Override
//    public void accessSucceed(String response, String type) {
//
//        /**
//         * 通知View 服务器成功响应，关闭进度显示
//         */
////        mvpView.showProgress(false);
//
//        /**
//         * 在实际设计系统的时候，通过状态码来判断服务器是否正确响应
//         * 如果响应错误，可以在这里直接通知view层错误情况
//         * 以下为根据百度api的数据格式设计的回调处理
//         * errorNum = 0 时，响应成功
//         *
//         *  根据和后台的约定 判断这次请求在服务器端是否请求成功
//         *  成功：将数据交由子类
//         *  失败：通知view显示失败原因
//         *
//         *  下方的true应该通过接口返回的Json数据 得到
//         *  为true时 将View需要的自动 传递给子类处理
//         *  为false时 传递服务器提示的错误MSG
//         */
//
//        //此处还需判断是否是 列表类请求的数据，如果是列表类请求的代码，需要返回arrlist字段
//
//        try {
//            System.out.println("!!!!!!!!!!!!!!!! 解析数据"+response);
//            JSONObject jsonObject=new JSONObject(response);
//            //此处判断默认和服务器端约定的是Boolean类型，可根据需求做相应修改
//            if (jsonObject.optBoolean(RequestType.IS_SUCCESS)){
//                //正确的数据交由子类处理
//                System.out.println("!!!!!!!!!!!!!!!! 解析数据 传递给子类");
////                serverResponse(response,type);
//            }else {
//                //将服务器返回的错误码或错误信息返回
////                System.out.println("!!!!!!!!!!!!!!!! 解析数据 错误" + response );
////                serverResponse(response,type);
////                mvpView.showServerError(0,jsonObject.optString(RequestType.MESSAGE));
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//            //数据解析异常
//            System.out.println("!!!!!!!!!!!!!!!! 解析数据 异常");
////            mvpView.showServerError(0,RequestType.DATA_ERROR);
//            mvpView.get().showServerError(0,RequestType.DATA_ERROR);
//        }
//
//    }


    @Override
    public void accessSucceedObj(Object object, String json) {
        mvpView.get().showProgress(false);
        try {
            JSONObject jsonObject = new JSONObject(json);

            if (RequestType.IS_STRING) {
                //此处判断默认和服务器端约定的是Boolean类型，可根据需求做相应修改
                if (jsonObject.optString(RequestType.IS_SUCCESS).equals(RequestType.STRING_CODE) || jsonObject.optInt("code") == 0) {
                    //正确的数据交由子类处理
                    serverResponseObj(object);
                } else {
                    if (jsonObject.optString(RequestType.IS_SUCCESS).equals( RequestType.AGAIN_LOGIN) ) {
                        Intent intent = new Intent();
                        intent.setAction("IS_LOGIN");
                        intent.putExtra("info", "-2");
                        RequestType.mContext.sendBroadcast(intent);
                    }

                    mvpView.get().showServerError( jsonObject.optInt("code"), jsonObject.optString(RequestType.MESSAGE));
                }
            } else {
                //此处判断默认和服务器端约定的是Boolean类型，可根据需求做相应修改
                if (jsonObject.optInt(RequestType.IS_SUCCESS) == RequestType.INT_CODE || jsonObject.optInt("code") == 0) {
                    //正确的数据交由子类处理
                    serverResponseObj(object);
                }
                else {

                    if (jsonObject.optInt(RequestType.IS_SUCCESS) == Integer.parseInt(RequestType.AGAIN_LOGIN)) {
                        Intent intent = new Intent();
                        intent.setAction("IS_LOGIN");
                        intent.putExtra("info", "-2");
                        RequestType.mContext.sendBroadcast(intent);
                    }

                    mvpView.get().showServerError(jsonObject.optInt("code"), jsonObject.optString(RequestType.MESSAGE));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
            //数据解析异常
//            mvpView.showServerError(0,RequestType.DATA_ERROR);
            mvpView.get().showServerError(0, RequestType.DATA_ERROR);
        }

    }

    @Override
    public Map getParams() {
        return this.map;
    }

    @Override
    public void setParams(String key, Object v) {
        this.map.put(key, v);
    }

    @Override
    public void emptyParams() {
        this.map.clear();
    }

    @Override
    public IBaseModel getModel() {
        return this.baseModel;
    }

    @Override
    public void cancelRequest(String type) {
        baseModel.cancelRequest(type);
    }

    @Override
    public void okgoError(int errorCode, String errorDesc, String type) {
        //网络请求错误 通知View层显示 错误信息或做相关操作
//        mvpView.showNetworkError(errorCode,errorDesc,type);
        mvpView.get().showNetworkError(errorCode, errorDesc, type);
    }

    @Override
    public void okgoProgress(long currentSize, long totalSize, float progress, long networkSpeed) {

    }

    @Override
    public void downloadFile(File file) {

    }

    @Override
    public void dealloc() {
        //释放资源

        if (this.mvpView != null) {
            this.mvpView.clear();
        }

        if (this.baseModel != null) {
            this.baseModel.dealloc();
        }
    }




    public void accessServers(String Method, String address, String url, Class type, HashMap<String, String> map) {
        getModel().sendRequestToServers(Method, address + url, type, map);
    }
    public void accessServersObj(String Method, String address, String url, Class type, HashMap<String, Object> map) {
        getModel().sendRequestToServersObj(Method, address + url, type, map);
    }

    public void accessServers(String Method, String address, String url, Class type, HashMap<String, String> map, IokgoCallback iokgoCallback) {
        getModel().sendRequestToServers(Method, address + url, type, map,iokgoCallback);
    }

    public void accessServers(String Method, String address, String url, Class type, HashMap<String, String> map, HttpHeaders headers) {

        getModel().sendRequestToServers(Method, address + url, type, map,headers);
    }




    public void accessServers(String Method, String url, Class type, HashMap<String, String> map) {

        getModel().sendRequestToServers(Method, RequestType.ADDRESS + url, type, map);
    }


}
