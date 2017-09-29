package com.example.changemax.sqhappy.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by ChangeMax on 2017/3/17.
 */

public abstract class BaseFragment extends Fragment {
    private View mLayoutView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (mLayoutView == null) {
            mLayoutView = getCreateView(inflater, container);
        }
        // 缓存的rootView需要判断是否已经被加过parent，如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) mLayoutView.getParent();
        if (parent != null) {
            parent.removeView(mLayoutView);
        }
        initView();
        return mLayoutView;
    }
    /**
     * 初始化布局
     */
    public abstract int getLayoutRes();

    /**
     * 初始化视图
     */
    public abstract void initView();

    /**
     * 获取Fragment布局文件的View
     *
     * @param inflater
     * @param container
     * @return
     */
    private View getCreateView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(getLayoutRes(), container, false);
    }

    /**
     * FindViewById
     *
     * @param ResourceID
     * @param <T>
     * @return
     */
    public <T extends View> T findView(int ResourceID) {
        return (T) mLayoutView.findViewById(ResourceID);
    }
}

