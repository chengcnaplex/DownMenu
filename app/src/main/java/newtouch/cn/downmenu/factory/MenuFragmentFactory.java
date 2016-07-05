package newtouch.cn.downmenu.factory;

import android.support.v4.util.SparseArrayCompat;

import newtouch.cn.downmenu.R;
import newtouch.cn.downmenu.fragment.AddressFragemnt;
import newtouch.cn.downmenu.fragment.BaseFragment;
import newtouch.cn.downmenu.fragment.CatalogueFragment;
import newtouch.cn.downmenu.fragment.SortFragment;

/**
 * @创建者 Administrator
 * @创建时间 2016/4/11 10:04
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class MenuFragmentFactory {
    private static SparseArrayCompat<BaseFragment> mCaches	= new SparseArrayCompat<BaseFragment>();
    public static void removeFragment(int position){
        BaseFragment fragment = mCaches.get(position);
        if (fragment != null) {
            mCaches.remove(position);
        }
    }
    public static BaseFragment getFragment(int position)
    {
        BaseFragment fragment = mCaches.get(position);

        if (fragment != null) { return fragment; }

        switch (position)
        {
            case R.id.b1:
                // 目录
                fragment = new CatalogueFragment();
                break;
            case R.id.b2:
                // 地区
                fragment = new AddressFragemnt();
                break;
            case R.id.b3:
                // 排序
                fragment = new SortFragment();
                break;
            default:
                break;

        }

        // 存储
        mCaches.put(position, fragment);

        return fragment;
    }
}
