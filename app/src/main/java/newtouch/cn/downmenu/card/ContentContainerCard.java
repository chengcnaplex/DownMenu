package newtouch.cn.downmenu.card;

import android.view.View;

import newtouch.cn.downmenu.R;
import newtouch.cn.downmenu.utils.UiUtils;

/**
 * @创建者 Administrator
 * @创建时间 2016/4/13 17:08
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
public class ContentContainerCard extends BaseCard<String[]>{

    public ContentContainerCard(String item1, String item2) {
        super(item1, item2);

    }

    @Override
    protected String[] initData() {
        //根据item1,item2参数开线程加载数据

        return new String[0];
    }

    @Override
    protected View initView() {
        mView = View.inflate(UiUtils.getContext(), R.layout.activity_main,null);
        return null;
    }
}
