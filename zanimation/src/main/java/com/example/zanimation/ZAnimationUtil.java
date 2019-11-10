package com.example.zanimation;

import android.view.View;
import android.view.animation.TranslateAnimation;

/**
 * 创建时间：2019/11/10  12:03
 * 作者：5#
 * 描述：TODO
 */
public class ZAnimationUtil {
    /**
     * 平移动画
     *
     * @param target
     * @param fromXDelta
     * @param toXDelta
     * @param fromYDelta
     * @param toYDelta
     */
    public static void startAnimation(View target, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
        TranslateAnimation translateAnimation = new TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta);
        translateAnimation.setDuration(3000);
//        translateAnimation.setFillAfter(true);
        translateAnimation.setFillBefore(true);
        target.startAnimation(translateAnimation);
    }


}
