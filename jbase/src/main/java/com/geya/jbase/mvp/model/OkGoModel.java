package com.geya.jbase.mvp.model;



import com.geya.jbase.constant.RequestTypes;
import com.geya.jbase.mvp.presenter.IBasePresenter;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okrx2.adapter.ObservableResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2016/12/10.
 * <p>
 * 通过okgo框架从服务器获取数据
 */

public class OkGoModel implements IBaseModel {


    private Class object;

    private static CompositeDisposable mDisposable = new CompositeDisposable();

    /**
     * 主持者 实列
     */
    private IBasePresenter basePresenter;

    public OkGoModel(IBasePresenter basePresenter) {
        this.basePresenter = basePresenter;
    }


    @Override
    public void sendRequestToServers(String method, String url, Class obj, HashMap<String, String> map) {
        System.out.println("----------------  sendRequestToServers ");
        switch (method) {
            case RequestTypes.OKGO_GET:
                okRxGET(url, obj, map);
                break;
            case RequestTypes.OKGO_GET_CACHE:
                okRxCacheGET(url, obj, map);
                break;
            case RequestTypes.OKGO_POST:
                okRxPOST(url, obj, map);
                break;
        }
    }


    @Override
    public void cancelRequest(String identify) {
        if (identify.equals("")) {
            //取消所有请求
            OkGo.getInstance().cancelAll();
        } else {
            //根据请求标识 取消对应请求
            OkGo.getInstance().cancelTag(identify);
        }
    }

    @Override
    public void dealloc() {
        if (basePresenter != null) {
//            mDisposable.dispose();
            basePresenter = null;
        }
    }


    @Override
    public void setClassTyer(Class obj) {
        this.object = obj;
    }

    private void okRxGET(String url, final Class obj, Map<String, String> map) {

        OkGo.<String>get(url)
                .params(map)
                .converter(new StringConvert())
                .adapt(new ObservableResponse<String>())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        mDisposable.add(disposable);
                    }
                })
                .map(new Function<Response<String>, Object>() {

                    @Override
                    public Object apply(Response<String> stringResponse) {
                        System.out.println("-----------------  apply  " + stringResponse.body());
                        return new Gson().fromJson(stringResponse.body(), obj);
//                        BaseData data = new Gson().fromJson(stringResponse.body(), BaseData.class);
//                        if (data.getRetcode() == 200) {
//                            return new Gson().fromJson(stringResponse.body(), obj);
//                        } else {
//                            return data;
//                        }
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object serverModel) {
                        System.out.println("--------------------  onNext " +   serverModel.toString());
                        onSuccess(serverModel);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        onErrors(e);
                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }

    private void okRxCacheGET(String url, final Class obj, Map<String, String> map) {

        OkGo.<String>get(url)
                .params(map)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .converter(new StringConvert())
                .adapt(new ObservableResponse<String>())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        mDisposable.add(disposable);
                    }
                })
                .map(new Function<Response<String>, Object>() {

                    @Override
                    public Object apply(Response<String> stringResponse) throws Exception {
                        return new Gson().fromJson(stringResponse.body(), obj);
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object serverModel) {
                        onSuccess(serverModel);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        onErrors(e);
                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }

    private void okRxPOST(String url, final Class obj, Map<String, String> map) {

        OkGo.<String>post(url)
                .params(map)
                .converter(new StringConvert())
                .adapt(new ObservableResponse<String>())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        mDisposable.add(disposable);
                    }
                })
                .map(new Function<Response<String>, Object>() {

                    @Override
                    public Object apply(Response<String> stringResponse) throws Exception {

                        return new Gson().fromJson(stringResponse.body(), obj);
//                        BaseData data = new Gson().fromJson(stringResponse.body(), BaseData.class);
//                        if (data.getRetcode() == 200) {
//                            return new Gson().fromJson(stringResponse.body(), obj);
//                        } else {
//                            return data;
//                        }

                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object serverModel) {
                        onSuccess(serverModel);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        onErrors(e);
                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }


    private void okgoDownload(final String url) {

        OkGo.<File>get(url)
                .tag(this)
                .execute(new FileCallback() {
                    @Override
                    public void onSuccess(Response<File> response) {
                        // file 即为文件数据，文件保存在指定目录
                        if (basePresenter != null) {
                            basePresenter.downloadFile(response.body());
                        }
                    }

                    @Override
                    public void onError(Response<File> response) {
                        if (basePresenter != null) {
                            basePresenter.okgoError(0, RequestTypes.SERVER_ERROR, "");
                        }
                    }

                    @Override
                    public void downloadProgress(Progress progress) {
                        if (basePresenter != null) {
                            basePresenter.okgoProgress(progress.currentSize, progress.totalSize, 0, 0);
                        }
                    }
                });

    }


    /**
     * 文件上传
     *
     * @param url
     */
    private void okgoPOSTFile(final String url, List<File> list) {

        OkGo.<String>post(url)                               // 请求方式和请求url
                .tag(this)
//                .isMultipart(true)
                .params(basePresenter.getParams())
                .addFileParams("avatar", list)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (basePresenter != null) {
//                            basePresenter.accessSucceed(response.body(), "");
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        if (basePresenter != null) {
                            basePresenter.okgoError(0, RequestTypes.SERVER_ERROR, "");
                        }
                    }

                    @Override
                    public void uploadProgress(Progress progress) {
                        if (basePresenter != null) {
                            basePresenter.okgoProgress(progress.currentSize, progress.totalSize, 0, 0);
                        }
                    }
                });


    }

    /**
     * 把参数组合成字符串
     *
     * @param jsonName 最外层对象名
     * @param map      具体内容
     * @param <K>
     * @param <V>
     */
    private <K, V> String convertJson(String jsonName, Map<K, V> map) {
        JSONObject obj = new JSONObject(map);
        if (jsonName.equals("")) {
            return obj.toString();
        } else {
            JSONObject object = new JSONObject();
            try {
                object.put(jsonName, obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return object.toString();
        }

    }


    private void onSuccess(Object obj) {
        if (basePresenter != null) {
            basePresenter.accessSucceedObj(obj, new Gson().toJson(obj));
        }
    }

    private void onErrors(Throwable e) {
        if (e instanceof UnknownHostException || e instanceof ConnectException) {
            if (basePresenter != null) {
                basePresenter.okgoError(0, RequestTypes.INTERNET_ERROR, ""); //当前网络不可用
            }
        }

    }


}
