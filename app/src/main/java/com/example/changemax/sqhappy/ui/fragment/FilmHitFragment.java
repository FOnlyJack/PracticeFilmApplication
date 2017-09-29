package com.example.changemax.sqhappy.ui.fragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.changemax.sqhappy.FilmApplication;
import com.example.changemax.sqhappy.R;
import com.example.changemax.sqhappy.contract.FilmHitContract;
import com.example.changemax.sqhappy.dagger.component.fragment.DaggerFilmHitComponent;
import com.example.changemax.sqhappy.dagger.module.fragment.FilmHitModule;
import com.example.changemax.sqhappy.model.network.entity.FilmIsHitingBean;
import com.example.changemax.sqhappy.presenter.fragment.FilmHitPresenter;
import com.example.changemax.sqhappy.ui.BaseFragment;
import com.example.changemax.sqhappy.ui.activity.FilmDetailActivity;
import com.example.changemax.sqhappy.ui.adapter.FragHitRvAdapter;
import com.example.changemax.sqhappy.utils.SPUtils;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by ChangeMax on 2017/3/16.
 * 热映
 */

public class FilmHitFragment extends BaseFragment implements FilmHitContract.View, SwipeRefreshLayout.OnRefreshListener {
    public static final String ARG_PAGE = "ARG_PAGE_HIT";
    private int mPage;
    private RecyclerView recyclerView;
    private FragHitRvAdapter fragHitRvAdapter;
    private List<FilmIsHitingBean.MsBean> resultData;
    private FilmHitContract.Presenter presenter;
    private FrameLayout frameLayout;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public static FilmHitFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FilmHitFragment filmHitFragment = new FilmHitFragment();
        filmHitFragment.setArguments(args);
        return filmHitFragment;
    }

    @Inject
    FilmHitPresenter filmHitPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_film_hit;
    }

    @Override
    public void initView() {
        frameLayout = findView(R.id.fr_no_info);
        initSwipeRefreshLayout();
        initRecyclerView();
        initListener();
        initregister();
        DaggerFilmHitComponent.builder()
                .filmHitModule(new FilmHitModule(this))
                .build()
                .inject(this);
    }

    private void initSwipeRefreshLayout() {
        mSwipeRefreshLayout =  findView(R.id.swipeLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
    }

    private void initregister() {
        IntentFilter selectCity = new IntentFilter();
        selectCity.addAction("com.example.changemax.sqhappy.ACTION_SEND_SELECED_CITY");
        getContext().registerReceiver(customCityRegister, selectCity);
    }

    private void initListener() {
        recyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                FilmIsHitingBean.MsBean msBean = (FilmIsHitingBean.MsBean) adapter.getData().get(position);
                presenter.unSubscribe();
                //进入电影详情页面
                SPUtils.put(FilmApplication.getInstance(),"movieID",msBean.getId());
                Intent intent = new Intent(getActivity(), FilmDetailActivity.class);
                startActivity(intent);

            }
        });
    }


    private void initRecyclerView() {
        recyclerView = findView(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        resultData = new ArrayList<>();
        fragHitRvAdapter = new FragHitRvAdapter(R.layout.frag_hit_rv_item, resultData);
        recyclerView.setAdapter(fragHitRvAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        assert mSwipeRefreshLayout != null;
        mSwipeRefreshLayout.setRefreshing(true);
        assert presenter != null;
        presenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unSubscribe();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getContext().unregisterReceiver(customCityRegister);
    }


    @Override
    public void setPresenter(FilmHitContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayFilmHitInformation(List<FilmIsHitingBean.MsBean> msBeanList) {
        if (msBeanList != null && msBeanList.size() != 0) {
            resultData.clear();
            resultData.addAll(msBeanList);
        } else {
            frameLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onCompleted() {
        mSwipeRefreshLayout.setRefreshing(false);
        fragHitRvAdapter.notifyDataSetChanged();
        frameLayout.setVisibility(View.GONE);
    }

    @Override
    public void onError(Throwable e) {

        frameLayout.setVisibility(View.VISIBLE);
    }

    BroadcastReceiver customCityRegister = new BroadcastReceiver() {
        public final static String ACTION_SEND = "com.example.changemax.sqhappy.ACTION_SEND_SELECED_CITY";

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (ACTION_SEND.equals(action)) {
                boolean msg_car = intent.getBooleanExtra("msg_car", false);
                Logger.d(msg_car + "-----------------收到了");
                assert presenter != null;
                presenter.subscribe();
            }
        }
    };

    @Override
    public void onRefresh() {
        /*下拉刷新*/
        assert presenter != null;
        presenter.subscribe();
    }
}
