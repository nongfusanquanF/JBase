package com.geya.jbase.mvp.presenter;





import com.geya.jbase.mvp.model.IBaseModel;

import java.io.File;
import java.util.Map;


/**
 * Created by Administrator on 2016/12/11.
 * presenter基类
 * 提交到服务器的参数类
 */

public interface IBasePresenter {
    /**
     * 访问服务器
     * 这个方法主要是在View层中调用，通过该方法通知Model层向服务器发起请求，params可为空。
     * @param
     */
    void accessServer();


    /**
     * 访问成功
     * 这个方法在Model层中调用，通过该方法把服务器返回的数据传递给Presenter层处理。

     */
//    void accessSucceed(String response, String type);

    void accessSucceedObj(Object object,String json);

    /**
     * 获取接口所需字段参数参数
     * 该方法在Model层中调用，Model层通过该方法获取Presenter处理好的参数。
     * @return
     */
    Map getParams();

    /**
     * 设置参数
     * @param key
     * @param v
     */
    void setParams(String key, Object v);

    /**
     * 清空参数
     */
    void emptyParams();

    /**
     * 模型类接接口实列来获取服务器数据
     * 该方法主要在子类中调用，用于获取Model对象。
     * @return
     */
    IBaseModel getModel();


    /**
     *  * 取消请求
     * 该方法在View层中调用，作用时通知Model层取消请求。
     * @param type 类型 标识
     */
    void cancelRequest(String type);



    /**
     *   请求失败
     * 当产生网络错误时，Model层就会调用该方法。
     * @param errorCode 错误码
     * @param errorDesc 错误原因
     * @param type 类型
     */
    void okgoError(int errorCode, String errorDesc, String type);

    /**
     *  Activity 终止时 释放资源
     *   此方法由View调用
     */
    void dealloc();

    /**
     *  上传进度
     * @param currentSize
     * @param totalSize
     * @param progress
     * @param networkSpeed
     */
    void okgoProgress(long currentSize, long totalSize, float progress, long networkSpeed);

    /**
     * 下载完成后路径
     * @param file
     */
    void downloadFile(File file);



}
