package com.geya.jbase.uiview;

import android.content.Context;
import android.text.BoringLayout;
import android.widget.Toast;

import com.hjq.toast.ToastUtils;

/**
 * Created by licrynoob on 2016/7/12 <br>
 * Copyright (C) 2016 <br>
 * Email:licrynoob@gmail.com <p>
 * Toast工具类
 * 不连续弹出Toast
 * 需初始化sContext
 */
public class ToastUtil {

    public static Context sContext = null;
    private static Toast sToast = null;
    public static boolean openToast = true;

    /**
     * 短时间显示Toast
     *
     * @param message 信息
     */
    public static void showShort(CharSequence message) {
        ToastUtils.show(message);
    }

    /**
     * 短时间显示Toast
     *
     * @param message 信息
     */
    public static void showShort(int message) {
        ToastUtils.show(message);
    }

    /**
     * 长时间显示Toast
     *
     * @param message 信息
     */
    public static void showLong(CharSequence message) {
        if (sToast == null) {
            sToast = Toast.makeText(sContext, message, Toast.LENGTH_LONG);
        } else {
            sToast.setText(message);
        }
        sToast.show();
    }

    /**
     * 长时间显示Toast
     *
     * @param message 信息
     */
    public static void showLong(int message) {
        if (sToast == null) {
            sToast = Toast.makeText(sContext, message, Toast.LENGTH_LONG);
        } else {
            sToast.setText(message);
        }
        sToast.show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param message  信息
     * @param duration 时长
     */
    public static void showDuration(CharSequence message, int duration) {
        if (sToast == null) {
            sToast = Toast.makeText(sContext, message, duration);
        } else {
            sToast.setText(message);
        }
        sToast.show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param message  信息
     * @param duration 时长
     */
    public static void showDuration(int message, int duration) {
        if (sToast == null) {
            sToast = Toast.makeText(sContext, message, duration);
        } else {
            sToast.setText(message);
        }
        sToast.show();
    }

}
