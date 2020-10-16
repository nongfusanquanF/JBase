package com.geya.jbase.mvp.model;


import com.geya.jbase.constant.BaseData;
import com.geya.jbase.constant.RequestType;
import com.geya.jbase.mvp.presenter.IBasePresenter;
import com.geya.jbase.mvp.view.IokgoCallback;
import com.geya.jbase.utils.GsonUtil;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okrx2.adapter.ObservableResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
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
        switch (method) {
            case RequestType.OKGO_GET:
                okRxGET(url, obj, map);
                break;
            case RequestType.OKGO_GET_CACHE:
                okRxCacheGET(url, obj, map);
                break;
            case RequestType.OKGO_POST_CACHE:
                okRxCachePOSt(url, obj, map);
                break;
            case RequestType.OKGO_POST:
                okRxPOST(url, obj, map);
                break;

        }
    }

    @Override
    public void sendRequestToServersObj(String method, String url, Class obj, HashMap<String, Object> map) {
        switch (method) {
            case RequestType.OKGO_POST_JSON:
                okRxPostJson(url, obj, map,null);
                break;
            case RequestType.OKGO_PUT:
                okRxPutJson(url, obj, map,null);
                break;
            case RequestType.OKGO_DELETE:
                okRxDeleteJson(url, obj, map,null);
                break;
        }
    }

    @Override
    public void sendRequestToServersObj(String method, String url, Class obj, HashMap<String, Object> map, IokgoCallback iokgoCallback) {
        switch (method) {
            case RequestType.OKGO_POST_JSON:
                okRxPostJson(url, obj, map,iokgoCallback);
                break;
            case RequestType.OKGO_PUT:
                okRxPutJson(url, obj, map,iokgoCallback);
                break;
            case RequestType.OKGO_DELETE:
                okRxDeleteJson(url, obj, map,iokgoCallback);
                break;
        }
    }

    @Override
    public void sendRequestToServers(String method, String url, Class obj, HashMap<String, String> map, IokgoCallback iokgoCallback) {
        switch (method) {
            case RequestType.OKGO_GET:
                okRxGET(url, obj, map, iokgoCallback);
                break;
            case RequestType.OKGO_GET_CACHE:
                okRxCacheGET(url, obj, map);
                break;
            case RequestType.OKGO_POST_CACHE:
                okRxCachePOSt(url, obj, map);
                break;
            case RequestType.OKGO_POST:
                okRxPOST(url, obj, map, iokgoCallback);
                break;

        }
    }

    @Override
    public void sendRequestToServers(String method, String url, Class obj, HashMap<String, String> map, HttpHeaders headers) {
        switch (method) {
            case RequestType.OKGO_GET:
                okRxGET(url, obj, map, headers);
                break;
            case RequestType.OKGO_GET_CACHE:
                okRxCacheGET(url, obj, map);
                break;
            case RequestType.OKGO_POST_CACHE:
                okRxCachePOSt(url, obj, map);
                break;
            case RequestType.OKGO_POST:
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
                        BaseData data = GsonUtil.GsonToBean(stringResponse.body(), BaseData.class);
                        if (data != null) {
                            if (data.isSuccess()) {
                                return GsonUtil.GsonToBean(stringResponse.body(), obj);
                            } else {
                                return data;
                            }
                        } else {
                            return null;
                        }


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

    private void okRxPostJson(String url, final Class obj, Map<String, Object> map, final IokgoCallback iokgoCallback) {

        OkGo.<String>post(url)
                .upJson(convertJson("",map))
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
                        BaseData data = GsonUtil.GsonToBean(stringResponse.body(), BaseData.class);
                        if (data != null) {
                            if (data.isSuccess()) {
                                return GsonUtil.GsonToBean(stringResponse.body(), obj);
                            } else {
                                return data;
                            }
                        } else {
                            return null;
                        }


                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object serverModel) {
                        if (iokgoCallback != null) {
                            iokgoCallback.onSucceed(serverModel);
                        }
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

    private void okRxPutJson(String url, final Class obj, Map<String, Object> map, final IokgoCallback iokgoCallback) {

        OkGo.<String>put(url)
                .upJson(convertJson("",map))
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
                        BaseData data = GsonUtil.GsonToBean(stringResponse.body(), BaseData.class);
                        if (data != null) {
                            if (data.isSuccess()) {
                                return GsonUtil.GsonToBean(stringResponse.body(), obj);
                            } else {
                                return data;
                            }
                        } else {
                            return null;
                        }


                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object serverModel) {
                        if (iokgoCallback != null) {
                            iokgoCallback.onSucceed(serverModel);
                        }
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

    private void okRxDeleteJson(String url, final Class obj, Map<String, Object> map, final IokgoCallback iokgoCallback) {

        OkGo.<String>delete(url)
                .upJson(convertJson("",map))
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
                        BaseData data = GsonUtil.GsonToBean(stringResponse.body(), BaseData.class);
                        if (data != null) {
                            if (data.isSuccess()) {
                                return GsonUtil.GsonToBean(stringResponse.body(), obj);
                            } else {
                                return data;
                            }
                        } else {
                            return null;
                        }


                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object serverModel) {
                        if (iokgoCallback != null) {
                            iokgoCallback.onSucceed(serverModel);
                        }
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




    private void okRxGET(String url, final Class obj, Map<String, String> map, final IokgoCallback iokgoCallback) {

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
                        BaseData data = GsonUtil.GsonToBean(stringResponse.body(), BaseData.class);
                        if (data != null) {
                            if (data.isSuccess()) {
                                return GsonUtil.GsonToBean(stringResponse.body(), obj);
                            } else {
                                return data;
                            }
                        } else {
                            return null;
                        }


                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object serverModel) {
                        if (iokgoCallback != null) {
                            iokgoCallback.onSucceed(serverModel);
                        }
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

    private void okRxGET(String url, final Class obj, Map<String, String> map, HttpHeaders headers) {

        OkGo.<String>get(url)
                .params(map)
                .headers(headers)
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
                        BaseData data = GsonUtil.GsonToBean(stringResponse.body(), BaseData.class);
                        if (data != null) {
                            if (data.isSuccess()) {
                                return GsonUtil.GsonToBean(stringResponse.body(), obj);
                            } else {
                                return data;
                            }
                        } else {
                            return null;
                        }


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

    private void okRxCacheGET(String url, final Class obj, Map<String, String> map) {

        OkGo.<String>get(url)
                .params(map)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .cacheKey(url)
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
                        BaseData data = GsonUtil.GsonToBean(stringResponse.body(), BaseData.class);
                        if (data != null) {
                            if (data.isSuccess()) {
                                return GsonUtil.GsonToBean(stringResponse.body(), obj);
                            } else {
                                return data;
                            }
                        } else {
                            return null;
                        }


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

    private void okRxCachePOSt(String url, final Class obj, Map<String, String> map) {

        OkGo.<String>get(url)
                .params(map)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .cacheKey(url)
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
                        BaseData data = GsonUtil.GsonToBean(stringResponse.body(), BaseData.class);
                        if (data != null) {
                            if (data.isSuccess()) {
                                return GsonUtil.GsonToBean(stringResponse.body(), obj);
                            } else {
                                return data;
                            }
                        } else {
                            return null;
                        }


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

                        BaseData data = GsonUtil.GsonToBean(stringResponse.body(), BaseData.class);
                        if (data != null) {
                            if (data.isSuccess()) {
                                return GsonUtil.GsonToBean(stringResponse.body(), obj);
                            } else {
                                return data;
                            }
                        } else {
                            return null;
                        }


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

    private void okRxPOST(String url, final Class obj, Map<String, String> map, final IokgoCallback iokgoCallback) {

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

                        BaseData data = GsonUtil.GsonToBean(stringResponse.body(), BaseData.class);
                        if (data != null) {
                            if (data.isSuccess()) {
                                return GsonUtil.GsonToBean(stringResponse.body(), obj);
                            } else {
                                return data;
                            }
                        } else {
                            return null;
                        }


                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object serverModel) {
                        if (iokgoCallback != null) {
                            iokgoCallback.onSucceed(serverModel);
                        }
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
                            basePresenter.okgoError(0, RequestType.SERVER_ERROR, "");
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
                            basePresenter.okgoError(0, RequestType.SERVER_ERROR, "");
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
            if (obj != null) {
                basePresenter.accessSucceedObj(obj, new Gson().toJson(obj));
            } else {
                basePresenter.okgoError(0, "数据解析异常", "");
            }

        }
    }

    private void onErrors(Throwable e) {
//        if (e instanceof UnknownHostException || e instanceof ConnectException) {
//            if (basePresenter != null) {
//                basePresenter.okgoError(0, RequestType.INTERNET_ERROR, ""); //当前网络不可用
//            }
//        }else {
//            basePresenter.okgoError(0, RequestType.SERVER_ERROR, ""); //当前网络不可用
//        }

        if (e instanceof UnknownHostException) {
            if (basePresenter != null) {
                basePresenter.okgoError(0, RequestType.INTERNET_ERROR, ""); //当前网络不可用
            }
        } else if (e instanceof SocketTimeoutException) {
            if (basePresenter != null) {
                basePresenter.okgoError(0, "连接超时", ""); //当前网络不可用
            }
        } else {
            if (basePresenter != null) {
                basePresenter.okgoError(0, RequestType.SERVER_ERROR, ""); //当前网络不可用
            }
        }

    }


}
