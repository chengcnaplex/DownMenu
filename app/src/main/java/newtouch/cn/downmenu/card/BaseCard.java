package newtouch.cn.downmenu.card;

import android.view.View;

/**
 * @创建者 Administrator
 * @创建时间 2016/4/13 16:53
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 先给数据 在根据数据设置view
 */
public abstract  class BaseCard<E> {
    protected View mView;
    protected E datas;
    public BaseCard(String item1,String item2){
        datas = initData();
        initView();
    }
    protected abstract E initData();

    protected abstract View initView();

    protected View getRootView(){
        return  mView;
    }
}