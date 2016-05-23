package com.yjtc.cbg.yjsapp.View;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.yjtc.cbg.yjsapp.Adapter.FriendListAdapter;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.bean.User;
import com.yjtc.cbg.yjsapp.model.FriendListModel;
import com.yjtc.cbg.yjsapp.model.inter.IFriendListModel;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.HashMap;
import java.util.List;

/**
 * Created by chenboge on 16/5/9.
 */
@ContentView(R.layout.layout_friend_list)
public class FriendListActivity extends BaseActivity {

    @ViewInject(R.id.layout)
    private LinearLayout mLayout;

    @ViewInject(R.id.listView)
    private ListView mLV;

    @ViewInject(R.id.tv)
    private TextView mTV;

    private List<User> SortData;


    private int height;// 字体高度
    private boolean flag = false;

    private IFriendListModel model = new FriendListModel();

    private HashMap<String, Integer> selector;

    private FriendListAdapter mAdapter;

    private LayoutInflater mInflater;

    private View HeaderView=null;

    @Override
    void initData() {
        mInflater=LayoutInflater.from(this);
        HeaderView = mInflater.inflate(R.layout.friend_list_header, null, false);
        mTV.setVisibility(View.GONE);
        SortData = model.getSortList();
        selector = new HashMap<String, Integer>();
        for (int j = 0; j < model.getIndexStr().length; j++) {// 循环字母表，找出newPersons中对应字母的位置
            for (int i = 0; i < SortData.size(); i++) {
                if (SortData.get(i).getUserName().equals(model.getIndexStr()[j])) {
                    selector.put(model.getIndexStr()[j], i);
                }
            }

        }

        mAdapter = new FriendListAdapter(this, SortData);
        mLV.addHeaderView(HeaderView);
        mLV.setAdapter(mAdapter);
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // 在oncreate里面执行下面的代码没反应，因为oncreate里面得到的getHeight=0
        if (!flag) {// 这里为什么要设置个flag进行标记，我这里不先告诉你们，请读者研究，因为这对你们以后的开发有好处
            height = mLayout.getMeasuredHeight() / model.getIndexStr().length;
            getIndexView();
            flag = true;
        }
    }

    /**
     * 绘制索引列表
     */
    public void getIndexView() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, height);
        for (int i = 0; i < model.getIndexStr().length; i++) {
            final TextView tv = new TextView(this);
            tv.setLayoutParams(params);
            tv.setText(model.getIndexStr()[i]);
            tv.setPadding(10, 0, 10, 0);
            mLayout.addView(tv);
            mLayout.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event)

                {

                    float y = event.getY();
                    int index = (int) (y / height);
                    if (index > -1 && index < model.getIndexStr().length) {// 防止越界
                        String key = model.getIndexStr()[index];
                        if (selector.containsKey(key)) {
                            int pos = selector.get(key);
                            if (mLV.getHeaderViewsCount() > 0) {// 防止ListView有标题栏，本例中没有。
                                mLV.setSelectionFromTop(
                                        pos + mLV.getHeaderViewsCount(), 0);
                            } else {
                                mLV.setSelectionFromTop(pos, 0);// 滑动到第一项
                            }
                            mTV.setVisibility(View.VISIBLE);
                            mTV.setText(model.getIndexStr()[index]);
                        }
                    }
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            mLayout.setBackgroundColor(Color
                                    .parseColor("#f5f5f5"));
                            break;

                        case MotionEvent.ACTION_MOVE:

                            break;
                        case MotionEvent.ACTION_UP:
                            mLayout.setBackgroundColor(Color
                                    .parseColor("#00ffffff"));
                            mTV.setVisibility(View.GONE);
                            break;
                    }
                    return true;
                }
            });
        }
    }


}
