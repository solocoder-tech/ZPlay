package com.example.zanimation;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

import androidx.annotation.AnimRes;

/**
 * 创建时间：2019/11/10  12:03
 * 作者：5#
 * 描述：TODO
 */
public class ZAnimationUtil {
    /**
     * java代码：平移动画
     *
     * @param target
     * @param fromXDelta
     * @param toXDelta
     * @param fromYDelta
     * @param toYDelta
     */
    public static void startTranslateAnimation(View target, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
        TranslateAnimation translateAnimation = new TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta);
        translateAnimation.setDuration(3000);
        translateAnimation.setFillAfter(true);
        target.startAnimation(translateAnimation);
    }

    /**
     * xml：平移动画
     *
     * @param context
     * @param target
     * @param ResId
     */
    public static void startTranslateAnimationByXML(Context context, View target, @AnimRes int ResId) {
        Animation animation = AnimationUtils.loadAnimation(context, ResId);
        target.startAnimation(animation);
    }

    /**
     * java代码：透明动画
     *
     * @param target
     * @param fromAlpha
     * @param toAlpha
     */
    public static void startAlphaAnimation(View target, int fromAlpha, int toAlpha) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(fromAlpha, toAlpha);
        alphaAnimation.setDuration(3000);
        target.startAnimation(alphaAnimation);
    }

    public static void atartAlphaAnimationByXML(View target, @AnimRes int resId) {
        Animation animation = AnimationUtils.loadAnimation(target.getContext(), resId);
        animation.setDuration(3000);
        target.startAnimation(animation);
    }

}
