package com.skin.lib.com.skin.lib.views;

/**
 * Created by cheyanxu on 16/6/21.
 */
public interface Skinnable {
    /**
     * 当UIMode发生改变，通知activity
     */
    void applyDayNight();

    /**
     * 判断activity是否可以进行skinnable
     *
     * @return
     */
    boolean isSkinnable();

    void setSkinnable(boolean skinnable);
}
