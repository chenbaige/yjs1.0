package com.yjtc.cbg.yjsapp.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.yjtc.cbg.yjsapp.Adapter.BaseAdapter;
import com.yjtc.cbg.yjsapp.Adapter.ChatNewsAdapter;
import com.yjtc.cbg.yjsapp.Adapter.DividerItemDecoration;
import com.yjtc.cbg.yjsapp.Presenter.ChatPresenter;
import com.yjtc.cbg.yjsapp.R;
import com.yjtc.cbg.yjsapp.View.FriendListActivity;
import com.yjtc.cbg.yjsapp.Widget.MyPopupWindow;
import com.yjtc.cbg.yjsapp.bean.User;
import com.yjtc.cbg.yjsapp.fragment.inter.IChatFragment;
import com.yjtc.cbg.yjsapp.util.ToastUtil;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by chenboge on 16/4/30.
 */
@ContentView(R.layout.chat)
public class ChatFragment extends BaseFragment implements IChatFragment ,View.OnClickListener,BaseAdapter.onItemClickListener {

    @ViewInject(R.id.id_chat_refresh)
    private MaterialRefreshLayout mLayout;

    @ViewInject(R.id.id_chat_recyclerview)
    private RecyclerView mView;

    private ChatNewsAdapter mAdapter;

    private ChatPresenter mPresenter;

    private LayoutInflater mInflater;

    private View HeaderView=null;


    @Override
    void initData() {
        mInflater = LayoutInflater.from(getActivity());
        HeaderView = mInflater.inflate(R.layout.chat_header,null,false);
        HeaderView.findViewById(R.id.id_paivate_message).setOnClickListener(this);
        HeaderView.findViewById(R.id.id_message_center).setOnClickListener(this);
        HeaderView.findViewById(R.id.id_add_friend).setOnClickListener(this);
        HeaderView.findViewById(R.id.id_search).setOnClickListener(this);
        mPresenter = new ChatPresenter(this);
        mPresenter.load();
    }

    @Override
    void leftClick() {
        startActivity(new Intent(getActivity(), FriendListActivity.class));
    }

    @Override
    void rightClick() {
        Toast.makeText(getActivity(), "rightchat", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refresh() {

    }

    @Override
    public void loadListView(List<User> users) {
        mAdapter = new ChatNewsAdapter(getActivity(), users, R.layout.template_chat_news_item);
        mAdapter.setmHeaderView(HeaderView);
        //mAdapter.setOnItemClickListener(this);
        mView.setAdapter(mAdapter);
        mView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //点击私信
            case R.id.id_paivate_message:
                ToastUtil.showToast(getActivity(),"私信");
            break;

            //点击消息中心
            case R.id.id_message_center:
                ToastUtil.showToast(getActivity(),"消息中心");
                break;

            //点击添加好友
            case R.id.id_add_friend:
                ToastUtil.showToast(getActivity(),"添加好友");
                break;

            //点击搜索框
            case R.id.id_search:
                ToastUtil.showToast(getActivity(),"搜索");
                break;
        }
    }

    @Override
    public void onClick(View view, int position) {
        ToastUtil.showToast(getActivity(),"item"+position);
    }
}
