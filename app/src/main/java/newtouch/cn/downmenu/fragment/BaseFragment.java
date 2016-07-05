package newtouch.cn.downmenu.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import newtouch.cn.downmenu.MainActivity;
import newtouch.cn.downmenu.R;
import newtouch.cn.downmenu.manager.ThreadPoolManager;
import newtouch.cn.downmenu.utils.PreferenceUtils;
import newtouch.cn.downmenu.utils.UiUtils;

/**
 * @创建者 程梦真
 * @创建时间 2016/4/11 10:06
 * @描述 Fragment基类
 * @更新者 程梦真
 * @更新时间 2016/4/11 10:06
 * @更新描述 Fragment基类
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    String className = this.getClass().getName();
    //listView2 的数据集合
    String mCataloguesAll[][];
    //listView1 的数据集合
    String mCatalogues1[];
    //listView2 
    String mCatalogues2[];
    // 下拉容器
    private FrameLayout mDownMenu;
    // listView1
    private ListView item1;
    // listView2
    private ListView mItem2;
    private View mView;
    private int mFoodpoition;
    private Item1Adatper mItem1Adatper;
    private Item2Adatper mItem2Adatper;
    private long mItem1SelectedPosition = 0;
    private long mItem2SelectedPosition = 0;

    protected abstract String [][] setCatalogues2();
    protected abstract String [] setCatalogues1();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initView();
        return mDownMenu;
    }

    @Override
    public void onResume() {
        LoadDataAndSetListener();
        super.onResume();
    }

    private void initView() {
        mDownMenu = (FrameLayout) View.inflate(getActivity(), R.layout.down_menu, null);
        item1 = (ListView) mDownMenu.findViewById(R.id.item1);
        mItem2 = (ListView) mDownMenu.findViewById(R.id.item2);
        mView = mDownMenu.findViewById(R.id.bottom_view);
    }

    private void initListener() {
        mView.setOnClickListener(this);
        item1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d("getChildCount", item1.getChildCount() + "");
//                Log.d("position", position + "");
                /**  用来保持 设置的itme信息**/
                /**---------------做个缓冲--------------------**/
                mItem1SelectedPosition = position;

                for (int i = 0; i < item1.getChildCount(); i++) {
                    //所有listview1 的item 字体颜色设置R.color.itemTextColor
                    ((TextView) (item1.getChildAt(i).findViewById(R.id.textview1))).setTextColor(getResources().getColor(R.color.itemTextColor));
                    //设置 listview1 的 item 未选中背景色 R.color.item1Color
                    item1.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.item1Color));
                }
                //选中条目设置 背景色和字体
                View view1 = mItem1Adatper.getView(position, view, parent);
                view1.setBackgroundColor(getResources().getColor(R.color.item2Color));
                //改变listview的数据
                mCatalogues2 = mCataloguesAll[(int) mItem1SelectedPosition];
                mItem2Adatper.notifyDataSetChanged();
            }
        });
        mItem2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /**  用来保持 设置的itme信息**/
                mItem2SelectedPosition = position;
                PreferenceUtils.setLong(getActivity(), className + "mItem1SelectedPosition", mItem1SelectedPosition);
                PreferenceUtils.setLong(getActivity(), className + "mItem2SelectedPosition", mItem2SelectedPosition);
                for (int i = 0; i < mItem2.getChildCount(); i++) {
                    ((TextView) (mItem2.getChildAt(i).findViewById(R.id.textview))).setTextColor(getResources().getColor(R.color.itemTextColor));
                    mItem2.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.item1Color));
                }
                mItem2Adatper.notifyDataSetChanged();
                //通过监听器
                checkListView2Close(mCatalogues1[(int) mItem1SelectedPosition], mCatalogues2[(int) mItem2SelectedPosition]);
                //获得宿主activity 调用activity的方法
                ((MainActivity)getActivity()).setText(mCatalogues1[(int) mItem1SelectedPosition],mCatalogues2[(int) mItem2SelectedPosition]);

            }
        });
    }
    private class LoadDataTask implements Runnable{
        @Override
        public void run() {
            /**-------------网络请求数据--------------------**/
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            mCataloguesAll = setCatalogues2();
            mCatalogues1 = setCatalogues1();
            /**---------------模拟请求成功--------------------**/
            UiUtils.getMainHandler().post(new Runnable() {
                @Override
                public void run() {
                    Log.d("currentThread", Thread.currentThread() + "");
                    //模拟数据加载
                    initData();
                    initListener();
                }
            });
            /**-----------------------------------------------**/
        }
    }

    private void initData(){
        mItem1SelectedPosition = PreferenceUtils.getLong(getActivity(), className + "mItem1SelectedPosition", 0);
        mItem2SelectedPosition = PreferenceUtils.getLong(getActivity(), className + "mItem2SelectedPosition", 0);
        mCatalogues2 = mCataloguesAll[(int) mItem1SelectedPosition];
        mFoodpoition = 0;
        if (mItem1Adatper == null) {
            mItem1Adatper = new Item1Adatper();
        }
        if (mItem2Adatper == null) {
            mItem2Adatper = new Item2Adatper();
        }
        item1.setAdapter(mItem1Adatper);
        mItem2.setAdapter(mItem2Adatper);
    };

    private void LoadDataAndSetListener() {
        //加载数据 开异步线程
        ThreadPoolManager.getLongPool().execute(new LoadDataTask());
    }
    /**--------------------------关闭监听      --------------------------------------**/
    public interface OnCloseListener{
        void close();
    }
    private OnCloseListener mOnCloseListener;
    public void setOnTouchOutSide2CloseListener(OnCloseListener onCloseListener){
        if (mOnCloseListener == null){
            mOnCloseListener = onCloseListener;
        }
    }
    //通知DownMenu处理关闭事件
    @Override
    public void onClick(View v) {
        ((MainActivity)(getActivity())).closeDownMenu();
//        Log.d("mOnCloseListener != null", (mOnCloseListener != null) + "");
//        if (mOnCloseListener != null){
//            mOnCloseListener.close();
//        }
    }
    /**--------------------------------------------------------------------------------**/

    /**--------------------------回显监听      --------------------------------------**/
    public interface OnSetDataListener{
        void setData(String data1,String data2);
    }
    private OnSetDataListener mOnSetDataListener;
    public void setOnSetDataListener(OnSetDataListener onSetDataListener){
        if (mOnSetDataListener == null){
            mOnSetDataListener = onSetDataListener;
        }
    }
    protected void checkListView2Close(String superPosition,String subPosition){
        if (mOnSetDataListener != null){
            mOnSetDataListener.setData(superPosition,subPosition);
        }
    }
    /**--------------------------------------------------------------------------------**/
    private class Item1Adatper extends BaseAdapter {
        @Override
        public int getCount() {
            return mCatalogues1.length;
        }

        @Override
        public Object getItem(int position) {
            return mCatalogues1[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // TODO Auto-generated method stub
            Item1ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = View.inflate(getActivity(), R.layout.sublist_item, null);
                viewHolder = new Item1ViewHolder();
                viewHolder.textView = (TextView) convertView
                        .findViewById(R.id.textview1);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (Item1ViewHolder) convertView.getTag();
            }
            viewHolder.textView.setText(mCatalogues1[position]);
            viewHolder.textView.setTextColor(getResources().getColor(R.color.itemTextColor));
            //因为数据没变化
            convertView.setBackgroundColor(getResources().getColor(R.color.item1Color));
            //

            if (position == mItem1SelectedPosition){
                viewHolder.textView.setTextColor(getResources().getColor(R.color.buttonSelectColor));
                convertView.setBackgroundColor(getResources().getColor(R.color.item2Color));
            }

            return convertView;
        }
    }

    private class Item2Adatper extends BaseAdapter {


        @Override
        public int getCount() {
            return mCatalogues2.length;
        }

        @Override
        public Object getItem(int position) {
            return mCatalogues2[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            Item2ViewHolder holder = null;
            if (convertView == null) {
                convertView = View.inflate(getActivity(), R.layout.mylist_item, null);
                holder = new Item2ViewHolder();
                holder.textView = (TextView) convertView.findViewById(R.id.textview);
                convertView.setTag(holder);
            } else {
                holder = (Item2ViewHolder) convertView.getTag();
            }
            holder.textView.setText(mCatalogues2[position]);
            holder.textView.setTextColor(getResources().getColor(R.color.itemTextColor));

            mItem2SelectedPosition = PreferenceUtils.getLong(getActivity(),className+"mItem2SelectedPosition",0);
            long currentItem1Postion = PreferenceUtils.getLong(getActivity(),className+"mItem1SelectedPosition",0);

            if (mItem1SelectedPosition == currentItem1Postion && position == mItem2SelectedPosition){
                holder.textView.setTextColor(getResources().getColor(R.color.buttonSelectColor));
            }
            convertView.setBackgroundColor(getResources().getColor(R.color.item2Color));
            return convertView;
        }
    }
    public static class Item1ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public LinearLayout layout;
    }

    public static class Item2ViewHolder {
        public TextView textView;
    }
}
