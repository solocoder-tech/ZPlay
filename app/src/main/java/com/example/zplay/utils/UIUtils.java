package com.example.zplay.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * 创建时间：2019/11/10  12:47
 * 作者：5#
 * 描述：TODO
 */
public class UIUtils {
    /**
     * 获取手机屏幕的宽
     *
     * @param context
     * @return
     */
    public static int getScreenWith(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    /**
     * 获取手机屏幕的高
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }
}
