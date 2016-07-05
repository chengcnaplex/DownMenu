package newtouch.cn.downmenu.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import android.os.Handler;

import newtouch.cn.downmenu.BaseApplication;

/**
 * @创建者 Administrator
 * @创建时间 2016/4/13 14:02
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class UiUtils {
    /**
     * 获得上下文
     *
     * @return
     */
    public static Context getContext() {
        return BaseApplication.getContext();
    }

    /**
     * 获得资源
     *
     * @return
     */
    public static Resources getResources() {
        return getContext().getResources();
    }

    /**
     * 获得string类型的数据
     *
     * @param resId
     * @return
     */
    public static String getString(int resId) {
        return getContext().getResources().getString(resId);
    }

    /**
     * 获取string类型
     *
     * @param resId
     * @param formatArgs
     * @return
     */
    public static String getString(int resId, Object... formatArgs) {
        return getContext().getResources().getString(resId, formatArgs);
    }

    /**
     * 获得数组集合
     *
     * @param resId
     * @return
     */
    public static String[] getStringArray(int resId) {
        return getResources().getStringArray(resId);
    }

    /**
     * 获得颜色值
     *
     * @param resId
     * @return
     */
    public static int getColor(int resId) {
        return getResources().getColor(resId);
    }

    /**
     * 获得handler
     *
     * @return
     */
    public static Handler getMainHandler() {
        return BaseApplication.getHandler();
    }

    /**
     * 在主线程中执行任务
     *
     * @param task
     */
    public static void post(Runnable task) {
        getMainHandler().post(task);
    }

    /**
     * 延时执行任务
     *
     * @param task
     * @param delayMillis
     */
    public static void postDelayed(Runnable task, long delayMillis) {
        getMainHandler().postDelayed(task, delayMillis);
    }

    /**
     * 从消息队列中移除任务
     *
     * @param task
     */
    public static void removeCallbacks(Runnable task) {
        getMainHandler().removeCallbacks(task);
    }

    /**
     * 像素转dp
     *
     * @param px
     * @return
     */
    public static int px2dp(int px) {
        // px = dp * (dpi / 160)
        // dp = px * 160 / dpi

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int dpi = metrics.densityDpi;
        return (int) (px * 160f / dpi + 0.5f);
    }

    /**
     * dp转px
     *
     * @param dp
     * @return
     */
    public static int dp2px(int dp) {
        // px = dp * (dpi / 160)
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int dpi = metrics.densityDpi;

        return (int) (dp * (dpi / 160f) + 0.5f);
    }

    /**
     * 获得包名
     *
     * @return
     */
    public static String getPackageName() {
        return getContext().getPackageName();
    }

    public static int px2sp(int px) {
        float scaledDensity = getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (px / scaledDensity + 0.5f);
    }

    public static int sp2px(int sp) {
        float scaledDensity = getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (sp * scaledDensity + 0.5f);
    }
}
