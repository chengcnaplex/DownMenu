package newtouch.cn.downmenu.view;

import android.content.Context;
import android.widget.RelativeLayout;

/**
 * @创建者 Administrator
 * @创建时间 2016/4/12 13:18
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
//implements View.OnClickListener,BaseFragment.OnCloseListener,BaseFragment.OnSetDataListener
public class DownMenu extends RelativeLayout {

//    private Button mButton1;
//    private Button mButton2;
//    private Button mButton3;
//    private Drawable mButtonBackground;
//    private int mButtonTextColor;
//    private float mButtonTextSize;
//
//    private FrameLayout mDownMuneContainer;
//    private int checkedbutton = -1;
//    private FrameLayout mContentContainer;
//    private Context mcontext;
    public DownMenu(Context context) {
        super(context, null);
    }
//
//    public DownMenu(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        this.mcontext = context;
//        initView(context);
//        initData(context, attrs);
//        initListener();
//
//    }
//
//    public DownMenu(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//    private void initView(Context context) {
//        View.inflate(context, R.layout.down_menu_view, this);
//        mButton1 = (Button) findViewById(R.id.b1);
//        mButton2 = (Button) findViewById(R.id.b2);
//        mButton3 = (Button) findViewById(R.id.b3);
//        mContentContainer = (FrameLayout) findViewById(R.id.tv_content);
//        mDownMuneContainer = (FrameLayout) findViewById(R.id.down_menu_container);
//    }
//
//    private void initData(Context context, AttributeSet attrs) {
//        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.DownMenu);
//        mButtonBackground = ta.getDrawable(R.styleable.DownMenu_buttonBackgroud);
//        mButtonTextColor = ta.getColor(R.styleable.DownMenu_buttonTextColor, Color.BLACK);
//        mButtonTextSize = ta.getDimension(R.styleable.DownMenu_buttonTextSize, 18);
//        setbuttonStyle(mButtonBackground,mButtonTextColor,mButtonTextSize);
//        ta.recycle();
//    }
//
//    private void setbuttonStyle(Drawable buttonBackground, int buttonTextColor, float buttonTextSize) {
//        if (buttonBackground != null){
//            mButton1.setBackgroundDrawable(buttonBackground);
//            mButton2.setBackgroundDrawable(buttonBackground);
//            mButton3.setBackgroundDrawable(buttonBackground);
//        }
////        if (buttonTextColor != -1){
////            mButton1.setTextColor(buttonTextColor);
////            mButton2.setTextColor(buttonTextColor);
////            mButton3.setTextColor(buttonTextColor);
////        }
////        if (buttonTextSize != -1){
////            mButton1.setTextSize(buttonTextSize);
////            mButton2.setTextSize(buttonTextSize);
////            mButton3.setTextSize(buttonTextSize);
////        }
//    }
//
//
//    private void initListener() {
//        mButton1.setOnClickListener(this);
//        mButton2.setOnClickListener(this);
//        mButton3.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        setButtonColor(v.getId());
//        if (checkedbutton == v.getId()) {
//            mDownMuneContainer.setVisibility(View.GONE);
//            checkedbutton = -1;
//            return;
//        } else {
//            /**----------解决闪烁的问题----------**/
//            mDownMuneContainer.removeAllViews();
//            MenuFragmentFactory.removeFragment(v.getId());
//            /**---------------------------------**/
//            showItem(v.getId());
//            mDownMuneContainer.setVisibility(View.VISIBLE);
//            checkedbutton = v.getId();
//        }
//    }
//
//    private void setButtonColor(int id) {
//        switch (id) {
//            case R.id.b1:
//                setBtn1();
//                break;
//            case R.id.b2:
//                setBtn2();
//                break;
//            case R.id.b3:
//                setBtn3();
//                break;
//        }
//    }
//    private void showItem(int id) {
//        chooseFragmentById(id);
//    }
//    private void chooseFragmentById(int id)
//    {
//        FragmentManager fm = ((FragmentActivity)(mcontext)).getSupportFragmentManager();
//
//        // 开启事务
//        FragmentTransaction transaction = fm.beginTransaction();
//        BaseFragment fragment = MenuFragmentFactory.getFragment(id);
//
//        fragment.setOnSetDataListener(this);
//        fragment.setOnTouchOutSide2CloseListener(this);
//        // 加载左侧
//        transaction.replace(R.id.down_menu_container, MenuFragmentFactory.getFragment(id));
//
//        transaction.commit();
//    }
//    public void closeDownMenu(){
//        setBtnClose();
//        mDownMuneContainer.setVisibility(View.GONE);
//        checkedbutton = -1;
//    }
//    private void setBtnClose() {
//        mButton1.setTextColor(getResources().getColor(R.color.buttonNormalColor));
//        mButton2.setTextColor(getResources().getColor(R.color.buttonNormalColor));
//        mButton3.setTextColor(getResources().getColor(R.color.buttonNormalColor));
//    }
//
//
//    private void setBtn1() {
//        if (checkedbutton != R.id.b1) {
//            mButton1.setTextColor(getResources().getColor(R.color.buttonSelectColor));
//            mButton2.setTextColor(getResources().getColor(R.color.buttonNormalColor));
//            mButton3.setTextColor(getResources().getColor(R.color.buttonNormalColor));
//        } else {
//            mButton1.setTextColor(getResources().getColor(R.color.buttonNormalColor));
//        }
//    }
//
//    private void setBtn2() {
//        if (checkedbutton != R.id.b2) {
//            mButton2.setTextColor(getResources().getColor(R.color.buttonSelectColor));
//            mButton1.setTextColor(getResources().getColor(R.color.buttonNormalColor));
//            mButton3.setTextColor(getResources().getColor(R.color.buttonNormalColor));
//        } else {
//            mButton2.setTextColor(getResources().getColor(R.color.buttonNormalColor));
//        }
//    }
//
//    private void setBtn3() {
//        if (checkedbutton != R.id.b3) {
//            mButton3.setTextColor(getResources().getColor(R.color.buttonSelectColor));
//            mButton2.setTextColor(getResources().getColor(R.color.buttonNormalColor));
//            mButton1.setTextColor(getResources().getColor(R.color.buttonNormalColor));
//        } else {
//            mButton3.setTextColor(getResources().getColor(R.color.buttonNormalColor));
//        }
//    }
//    public void setText(String item1,String item2) {
//        Log.d("close", "close");
//        closeDownMenu();
//
////        mContentContainer.setText(item1 + "   " + item2);
////        BaseController controller = mPagerDatas.get(position);
////
////        View rootView = controller.getRootView();
////        // 添加到container --->View
////        container.addView(rootView);
//        //1.开线程访问网络
//        //2.加载数据
//        //  -----成功 返回成功的view
//        //  -----失败 返回失败的view
////        mContentContainer.addView();
//    }
//    @Override
//    public void close() {
//        Log.d("close","close");
//        closeDownMenu();
//    }
//
//    @Override
//    public void setData(String data1, String data2) {
//        setText(data1,data2);
//    }
}
