package com.yjtc.cbg.yjsapp.Presenter;

import com.yjtc.cbg.yjsapp.fragment.inter.IChatFragment;
import com.yjtc.cbg.yjsapp.model.ChatModel;
import com.yjtc.cbg.yjsapp.model.inter.IChatModel;

/**
 * Created by chenboge on 16/5/9.
 */
public class ChatPresenter {

    private IChatModel model = new ChatModel();
    private IChatFragment chatFragment;

    public ChatPresenter(IChatFragment chatFragment) {
        this.chatFragment = chatFragment;
    }

    public void load() {
        chatFragment.loadListView(model.getUser());
    }
}
