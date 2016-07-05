package newtouch.cn.downmenu;

import android.app.Application;
import android.content.Context;
import android.os.Looper;

import android.os.Handler;


/**
 * @创建者 Administrator
 * @创建时间 2016/4/13 14:03
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class BaseApplication extends Application
{

    private static Context	mContext;
    private static Handler mHandler;
    private static Thread	mMainThread;
    private static long		mMainThreadId;
    private static Looper	mMainThreadLooper;

    @Override
    public void onCreate()
    {
        super.onCreate();

        // 程序的入口
        mContext = this;

        // handler,用来子线程和主线程通讯
        mHandler = new Handler();

        // 主线程
        mMainThread = Thread.currentThread();
        // id
        // mMainThreadId = mMainThread.getId();
        mMainThreadId = android.os.Process.myTid();

        // looper
        mMainThreadLooper = getMainLooper();
    }

    public static Context getContext()
    {
        return mContext;
    }

    public static Handler getHandler()
    {
        return mHandler;
    }

    public static Thread getMainThread()
    {
        return mMainThread;
    }

    public static long getMainThreadId()
    {
        return mMainThreadId;
    }

    public static Looper getMainThreadLooper()
    {
        return mMainThreadLooper;
    }

}
