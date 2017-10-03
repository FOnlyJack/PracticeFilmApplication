package com.example.changemax.sqhappy.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.changemax.sqhappy.R;
import com.example.changemax.sqhappy.contract.VideoPlayContract;
import com.example.changemax.sqhappy.dagger.component.activity.DaggerVideoPlayComponent;
import com.example.changemax.sqhappy.dagger.module.activity.VideoPlayModule;
import com.example.changemax.sqhappy.model.network.entity.FilmVideoBean;
import com.example.changemax.sqhappy.presenter.activity.VideoPlayPresenter;
import com.example.changemax.sqhappy.ui.adapter.FilmVideoAdapter;
import com.example.changemax.sqhappy.ui.view.JCVAutoFullVideoView;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by ChangeMax on 2017/3/15.
 */
public class VideoPlayActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, VideoPlayContract.View, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.jc_video)
    JCVAutoFullVideoView jcVideo;
    @BindView(R.id.rv_video_list)
    RecyclerView rvVideoList;
    @BindView(R.id.film_rv_list_video_swip)
    SwipeRefreshLayout filmRvListVideoSwip;

    private VideoPlayContract.Presenter presenter;
    private FilmVideoAdapter filmVideoAdapter;
    private int movieId;
    private String videoHightUrl;
    private String filmName;
    private String vedioImg;
    private int videoId;
    private List<FilmVideoBean.VideoListBean> filmVideoList;

    private int PAGE_SIZE = 20;
    private int mCurrentCounter = 0;
    private boolean isErr = true;
    private int PAGE_INDEX = 1;
    private int totalCount;
    private int totalPageCount;
    @Inject
    VideoPlayPresenter videoPlayPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle("SmallChangeUI");
        DaggerVideoPlayComponent.builder()
                .videoPlayModule(new VideoPlayModule(this))
                .build()
                .inject(this);

        initData();
        initSwipe();
        initRvCleView();
        initPlay();
        initListener();
    }


    private void initSwipe() {
        filmRvListVideoSwip.setOnRefreshListener(this);
        filmRvListVideoSwip.setColorSchemeColors(Color.rgb(47, 223, 189));
    }

    private void initRvCleView() {
        filmVideoList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvVideoList.setLayoutManager(linearLayoutManager);
        rvVideoList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        filmVideoAdapter = new FilmVideoAdapter(R.layout.film_video_rv_list, filmVideoList, jcVideo);
        rvVideoList.setAdapter(filmVideoAdapter);
        mCurrentCounter = filmVideoAdapter.getData().size();
    }

    private void initData() {
        movieId = getIntent().getIntExtra("movieId", -1);
        videoHightUrl = getIntent().getStringExtra("videoHightUrl");
        filmName = getIntent().getStringExtra("filmName");
        vedioImg = getIntent().getStringExtra("vedioImg");
        videoId = getIntent().getIntExtra("videoId", -1);

        assert presenter != null;
        presenter.subscribe();
    }

    private void initPlay() {
        jcVideo.setUp(videoHightUrl, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, filmName);
        Glide.with(this)
                .load(vedioImg)
                .into(jcVideo.thumbImageView);

    }


    private void initListener() {
        filmVideoAdapter.setOnLoadMoreListener(this, rvVideoList);
        rvVideoList.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                FilmVideoBean.VideoListBean msBean = (FilmVideoBean.VideoListBean) adapter.getData().get(position);
                String hightUrl = msBean.getHightUrl();
                String title = msBean.getTitle();
                String image = msBean.getImage();

                if (jcVideo.currentState == JCVideoPlayer.CURRENT_STATE_PLAYING) {
                    JCVideoPlayer.releaseAllVideos();
                }
                presenter.unSubscribe();
                jcVideo.setUp(hightUrl, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, title);
                Glide.with(VideoPlayActivity.this)
                        .load(image)
                        .into(jcVideo.thumbImageView);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
        presenter.unSubscribe();
    }

    @Override
    public void onRefresh() {
        filmVideoList.clear();
        assert presenter != null;
        presenter.subscribe();
        filmVideoAdapter.setEnableLoadMore(false);
//        isErr = true;
//        mCurrentCounter = PAGE_SIZE;
//        PAGE_INDEX = 1;
//        filmVideoAdapter.loadMoreEnd(false);
    }

    @Override
    public void onLoadMoreRequested() {
//        Logger.d(filmVideoAdapter.getData().size() + "-" + mCurrentCounter + "==" + PAGE_SIZE + "+++" + totalCount+"----"+totalPageCount);
//        filmRvListVideoSwip.setEnabled(false);
//        if (filmVideoAdapter.getData().size() < PAGE_SIZE) {
//            filmVideoAdapter.loadMoreEnd(true);
//        } else {
//            if (mCurrentCounter >= totalCount) {
//                filmVideoAdapter.loadMoreEnd(false);
//                PAGE_INDEX = 1;
//            } else {
//                if (isErr) {
//                    if (PAGE_INDEX > totalPageCount) {
//                        filmVideoAdapter.loadMoreEnd(true);
//                        PAGE_INDEX = 1;
//                    } else {
//                        PAGE_INDEX++;
//                        videoPlayPresenter.loadFilmVideoListInfo(PAGE_INDEX, movieId);
//                        filmVideoAdapter.addData(filmVideoList);
//                        mCurrentCounter = filmVideoAdapter.getData().size();
//                        Logger.d("---------------" + mCurrentCounter);
//                        filmVideoAdapter.loadMoreComplete();
//                    }
//                } else {
//                    isErr = false;
//                    PAGE_INDEX = 1;
//                    filmVideoAdapter.loadMoreFail();
//                }
//            }
//            filmRvListVideoSwip.setEnabled(true);
//        }
    }

    @Override
    public void displayFilmHitInformation(List<FilmVideoBean> msBeanList) {
        if (msBeanList != null && msBeanList.size() != 0) {
            List<FilmVideoBean.VideoListBean> videoList = msBeanList.get(0).getVideoList();
            filmVideoList.addAll(videoList);
            totalPageCount = msBeanList.get(0).getTotalPageCount();
            totalCount = msBeanList.get(0).getTotalCount();
        } else {

        }
    }

    @Override
    public void onCompleted() {
        filmVideoAdapter.notifyDataSetChanged();
        filmRvListVideoSwip.setRefreshing(false);
        filmVideoAdapter.setEnableLoadMore(true);
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onError(Throwable e) {
        filmRvListVideoSwip.setRefreshing(false);
        filmVideoAdapter.loadMoreFail();
    }

    @Override
    public void setPresenter(VideoPlayContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }


}
