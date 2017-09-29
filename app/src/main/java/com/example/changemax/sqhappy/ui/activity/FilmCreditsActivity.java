package com.example.changemax.sqhappy.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.changemax.sqhappy.R;
import com.example.changemax.sqhappy.contract.FilmCreditsContract;
import com.example.changemax.sqhappy.dagger.component.activity.DaggerFilmCreditsComponent;
import com.example.changemax.sqhappy.dagger.module.activity.FilmCreditsModule;
import com.example.changemax.sqhappy.model.network.entity.FilmCreditsBean;
import com.example.changemax.sqhappy.presenter.activity.FilmCreditsPresenter;
import com.example.changemax.sqhappy.ui.BaseActivity;
import com.example.changemax.sqhappy.ui.adapter.FIlmCreditsRvAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ChangeMax on 2017/3/24.  职员表
 */

public class FilmCreditsActivity extends BaseActivity implements FilmCreditsContract.View {
    @BindView(R.id.film_cresits_toolbar)
    Toolbar filmCresitsToolbar;
    @BindView(R.id.film_cresits_rv)
    RecyclerView filmCresitsRv;

    private List<FilmCreditsBean.TypesBean> dataList;
    private FIlmCreditsRvAdapter animalsHeadersAdapter;
    @Inject
    FilmCreditsPresenter filmCreditsPresenter;
    private FilmCreditsContract.Presenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_cresits);
        ButterKnife.bind(this);
        DaggerFilmCreditsComponent.builder()
                .filmCreditsModule(new FilmCreditsModule(this))
                .build()
                .inject(this);
        initToolbar();
        initRv();
        assert presenter != null;
        presenter.subscribe();

    }

    private void initToolbar() {
        setSupportActionBar(filmCresitsToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        filmCresitsToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initRv() {
        dataList = new ArrayList<>();
        LinearLayoutManager linearLayoutManagerPingLun = new LinearLayoutManager(this);
        linearLayoutManagerPingLun.setOrientation(LinearLayoutManager.VERTICAL);
        filmCresitsRv.setLayoutManager(linearLayoutManagerPingLun);
        filmCresitsRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        animalsHeadersAdapter = new FIlmCreditsRvAdapter(R.layout.film_credits_rv_item_persion, dataList);
        filmCresitsRv.setAdapter(animalsHeadersAdapter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unSubscribe();
    }

    @Override
    public void displayFilmCreditsInformation(List<FilmCreditsBean> msBeanList) {
        if (msBeanList != null && msBeanList.size() != 0) {

            dataList.addAll(msBeanList.get(0).getTypes());
        }
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void onCompleted() {
        animalsHeadersAdapter.notifyDataSetChanged();
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void setPresenter(FilmCreditsContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
