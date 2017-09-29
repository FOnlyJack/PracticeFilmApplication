package com.example.changemax.sqhappy.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.changemax.sqhappy.R;
import com.example.changemax.sqhappy.contract.FilmDetailContract;
import com.example.changemax.sqhappy.dagger.component.activity.DaggerFilmDetailComponent;
import com.example.changemax.sqhappy.dagger.module.activity.FilmDetailModule;
import com.example.changemax.sqhappy.model.network.entity.ActorsBean;
import com.example.changemax.sqhappy.model.network.entity.FilmDetainBean;
import com.example.changemax.sqhappy.model.network.entity.FilmReviewsBean;
import com.example.changemax.sqhappy.presenter.activity.FilmDetailPresenter;
import com.example.changemax.sqhappy.ui.BaseActivity;
import com.example.changemax.sqhappy.ui.adapter.FIlmShortPLRvAdapter;
import com.example.changemax.sqhappy.ui.adapter.FilmDetailRvAdapter;
import com.example.changemax.sqhappy.utils.StretchUtil;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ChangeMax on 2017/3/19.
 */

public class   FilmDetailActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, FilmDetailContract.View {
    @BindView(R.id.iv_movie_play_bg)
    ImageView iv_movie_play_bg;
    @BindView(R.id.play_vedio)
    ImageView playVedio;
    @BindView(R.id.tv_film_name_en)
    TextView tvFilmNameEn;
    @BindView(R.id.tv_film_time)
    TextView tvFilmTime;
    @BindView(R.id.tv_overallrating)
    TextView tvOverallrating;
    @BindView(R.id.tv_overallrating_nb)
    TextView tvOverallratingNb;
    @BindView(R.id.tv_film_type)
    TextView tvFilmType;
    @BindView(R.id.tv_releasedate)
    TextView tvReleasedate;
    @BindView(R.id.tv_releasearea)
    TextView tvReleasearea;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.tv_story)
    TextView tvStory;
    @BindView(R.id.iv_story_arrow)
    ImageView ivStoryArrow;
    @BindView(R.id.rv_credits)
    RecyclerView rvCredits;
    @BindView(R.id.ln_into_credits)
    AutoLinearLayout lnIntoCredits;
    @BindView(R.id.tv_film_movie_detail_counts)
    TextView tvFilmMovieDetailCounts;
    @BindView(R.id.tv_film_phone_detail_counts)
    TextView tvFilmPhoneDetailCounts;
    @BindView(R.id.rl_to_movie_play)
    AutoRelativeLayout rlToMoviePlay;
    @BindView(R.id.rl_to_show_photo_detail)
    AutoRelativeLayout rlToShowPhotoDetail;
    @BindView(R.id.film_detail_swip)
    SwipeRefreshLayout filmDetailSwip;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;
    @BindView(R.id.iv_to_movie_show)
    ImageView ivToMovieShow;
    @BindView(R.id.iv_to_photo_show)
    ImageView ivToPhotoShow;
    @BindView(R.id.ln_film_story)
    AutoLinearLayout lnFilmStory;
    @BindView(R.id.tv_ranking)
    TextView tvRanking;
    @BindView(R.id.tv_todayboxdes)
    TextView tvTodayboxdes;
    @BindView(R.id.tv_totalbox)
    TextView tvTotalbox;
    @BindView(R.id.rl_to_short_pinglun)
    AutoRelativeLayout rlToShortPinglun;
    @BindView(R.id.rv_short_pinglun)
    RecyclerView rvShortPinglun;
    @BindView(R.id.tv_show_more_short_pinglun)
    TextView tvShowMoreShortPinglun;
    @BindView(R.id.rl_to_long_pinglun)
    AutoRelativeLayout rlToLongPinglun;
    @BindView(R.id.tv_long_rv_pinglun_content)
    TextView tvLongRvPinglunContent;
    @BindView(R.id.iv_long_hear_pingluner)
    ImageView ivLongHearPingluner;
    @BindView(R.id.tv_long_rv_name)
    TextView tvLongRvName;
    @BindView(R.id.tv_show_more_long_pinglun)
    TextView tvShowMoreLongPinglun;
    @BindView(R.id.tv_todayBoxDesUnit)
    TextView tvTodayBoxDesUnit;
    @BindView(R.id.tv_totalBoxUnit)
    TextView tvTotalBoxUnit;
    @BindView(R.id.fr_main_appbar)
    AutoFrameLayout frMainAppbar;

    private FilmDetailRvAdapter filmDetailRvAdapter;
    private FIlmShortPLRvAdapter fIlmShortPLRvAdapter;
    private FilmDetailContract.Presenter presenter;
    private List<FilmDetainBean.DataBean> dataBeanList;
    private List<FilmReviewsBean.DataBean.MiniBean.ListBean> reviewList;
    private List<ActorsBean> actorsBeanList;

    @Inject
    FilmDetailPresenter filmDetailPresenter;
    private int movieId;
    private String videoHightUrl;
    private String name;
    private String videoimg;
    private int videoId;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);

        DaggerFilmDetailComponent.builder()
                .filmDetailModule(new FilmDetailModule(this))
                .build()
                .inject(this);
        ButterKnife.bind(this);

        //Toolbar
        initToobar();
        initSwipFrash();
        StretchUtil.getInstance(tvStory, 3, ivStoryArrow, R.drawable.wallet__arrow_up, R.drawable.wallet__arrow_down).initStretch();
        initRv();
        initListener();

        assert presenter != null;
        presenter.subscribe();
    }

    private void initListener() {
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset >= 0) {
                    filmDetailSwip.setEnabled(true);
                } else {
                    filmDetailSwip.setEnabled(false);
                }
            }
        });
        //点击进入预告片 播放列表
        rlToMoviePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FilmDetailActivity.this, VideoPlayActivity.class);
                intent.putExtra("movieId", movieId);
                intent.putExtra("videoHightUrl", videoHightUrl);
                intent.putExtra("filmName",name);
                intent.putExtra("vedioImg",videoimg);
                intent.putExtra("vedioId",videoId);
                startActivity(intent);
            }
        });
        frMainAppbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FilmDetailActivity.this, VideoPlayActivity.class);
                intent.putExtra("movieId", movieId);
                intent.putExtra("videoHightUrl", videoHightUrl);
                intent.putExtra("filmName",name);
                intent.putExtra("vedioImg",videoimg);
                intent.putExtra("vedioId",videoId);
                startActivity(intent);
            }
        });
        //进入职员
        lnIntoCredits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FilmDetailActivity.this, FilmCreditsActivity.class);
                intent.putExtra("movieId", movieId);
                startActivity(intent);
            }
        });
        //点击进入剧照列表
        rlToShowPhotoDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //进入短评
        rlToShortPinglun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //进入长评
        rlToLongPinglun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initRv() {
        reviewList = new ArrayList<>();
        dataBeanList = new ArrayList<>();
        actorsBeanList = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvCredits.setLayoutManager(linearLayoutManager);
        rvCredits.setNestedScrollingEnabled(false);
        filmDetailRvAdapter = new FilmDetailRvAdapter(actorsBeanList);
        rvCredits.setAdapter(filmDetailRvAdapter);


        LinearLayoutManager linearLayoutManagerPingLun = new LinearLayoutManager(this);
        linearLayoutManagerPingLun.setOrientation(LinearLayoutManager.VERTICAL);
        rvShortPinglun.setLayoutManager(linearLayoutManagerPingLun);
        rvShortPinglun.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        rvShortPinglun.setNestedScrollingEnabled(false);
        fIlmShortPLRvAdapter = new FIlmShortPLRvAdapter(R.layout.film_short_pinglun_rv_item, reviewList);
        rvShortPinglun.setAdapter(fIlmShortPLRvAdapter);
    }

    private void initSwipFrash() {
        filmDetailSwip.setOnRefreshListener(this);
        filmDetailSwip.setColorSchemeColors(Color.rgb(47, 223, 189));
    }

    private void initToobar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unSubscribe();
    }

    @Override
    public void onRefresh() {

        assert presenter != null;
        presenter.subscribe();

    }

    @Override
    public void displayFilmDetailInformation(List<FilmDetainBean.DataBean> msBeanList) {
        if (msBeanList != null && msBeanList.size() != 0) {
            dataBeanList.clear();
            actorsBeanList.clear();
            dataBeanList.addAll(msBeanList);

            List<FilmDetainBean.DataBean.BasicBean.ActorsBean> actors = dataBeanList.get(0).getBasic().getActors();
            FilmDetainBean.DataBean.BasicBean.DirectorBean director = dataBeanList.get(0).getBasic().getDirector();

            ActorsBean directorBean = new ActorsBean(2);
            directorBean.setActorId(director.getDirectorId());
            directorBean.setImg(director.getImg());
            directorBean.setName(director.getName());
            actorsBeanList.add(directorBean);
            ActorsBean yanyuan = new ActorsBean(0);
            FilmDetainBean.DataBean.BasicBean.ActorsBean actorsBean1 = actors.get(0);
            yanyuan.setActorId(actorsBean1.getActorId());
            yanyuan.setImg(actorsBean1.getImg());
            yanyuan.setName(actorsBean1.getName());
            yanyuan.setNameEn(actorsBean1.getNameEn());
            yanyuan.setRoleName(actorsBean1.getRoleName());
            actorsBeanList.add(yanyuan);
            for (int i = 1; i < actors.size(); i++) {
                ActorsBean actorsBean = new ActorsBean(1);
                actorsBean.setActorId(actors.get(i).getActorId());
                actorsBean.setImg(actors.get(i).getImg());
                actorsBean.setNameEn(actors.get(i).getNameEn());
                actorsBean.setName(actors.get(i).getName());
                actorsBean.setRoleName(actors.get(i).getRoleName());
                actorsBeanList.add(actorsBean);
            }


            showFilmData();
        } else {

        }
    }

    @Override
    public void displayFileHotCommentInformation(List<FilmReviewsBean.DataBean> msBeanList) {
        if (msBeanList != null && msBeanList.size() != 0) {
            reviewList.clear();
            reviewList.addAll(msBeanList.get(0).getMini().getList());
            FilmReviewsBean.DataBean.PlusBean plus = msBeanList.get(0).getPlus();
            int total = plus.getTotal();
            FilmReviewsBean.DataBean.PlusBean.ListBeanX listBeanX = plus.getList().get(0);
            String content = listBeanX.getContent();
            String headImg = listBeanX.getHeadImg();
            String nickname = listBeanX.getNickname();
            tvLongRvPinglunContent.setText(content);
            tvLongRvName.setText(nickname);
            glideShowPic(headImg, ivLongHearPingluner);
            tvShowMoreShortPinglun.setText("查看更多" + msBeanList.get(0).getMini().getTotal() + "条短评");
            tvShowMoreLongPinglun.setText("查看更多" + total + "条长评");
        } else {

        }
    }

    private void showFilmData() {

        FilmDetainBean.DataBean.BasicBean basic = dataBeanList.get(0).getBasic();
        FilmDetainBean.DataBean.BoxOfficeBean boxOffice = dataBeanList.get(0).getBoxOffice();
        FilmDetainBean.DataBean.BasicBean.VideoBean video = basic.getVideo();
        FilmDetainBean.DataBean.BasicBean.StageImgBean stageImg = basic.getStageImg();

        movieId = boxOffice.getMovieId();
        videoHightUrl = video.getHightUrl();

        List<String> type = basic.getType();
        tvFilmType.setText(type.toString());
        String img = basic.getImg();
        glideShowPic(img, iv_movie_play_bg);
        name = basic.getName();
        collapsingToolbar.setTitle(name);
        String nameEn = basic.getNameEn();
        tvFilmNameEn.setText(nameEn);
        int ranking = boxOffice.getRanking();
        tvRanking.setText(ranking + "");
        double overallRating = basic.getOverallRating();
        if (overallRating == -1) {
            tvOverallratingNb.setText("暂无评分");
        } else {
            tvOverallratingNb.setText(String.valueOf(overallRating));
        }

        String releaseArea = basic.getReleaseArea();
        tvReleasearea.setText(releaseArea + " 上映");
        String releaseDate = basic.getReleaseDate();
        tvReleasedate.setText(releaseDate);
        String mins = basic.getMins();
        tvFilmTime.setText(mins);

        String story = basic.getStory();
        tvStory.setText(story);
        int videocount = video.getCount();
        videoId = video.getVideoId();
        tvFilmMovieDetailCounts.setText(String.valueOf(videocount));
        videoimg = video.getImg();
        glideShowPic(videoimg, ivToMovieShow);
        int photocount = stageImg.getCount();
        tvFilmPhoneDetailCounts.setText(String.valueOf(photocount));
        String photoimgUrl = stageImg.getList().get(0).getImgUrl();
        glideShowPic(photoimgUrl, ivToPhotoShow);


        String todayBoxDes = boxOffice.getTodayBoxDes();
        String totalBoxDes = boxOffice.getTotalBoxDes();
        String todayBoxDesUnit = boxOffice.getTodayBoxDesUnit();
        String totalBoxUnit = boxOffice.getTotalBoxUnit();


        isEmpty(todayBoxDes, totalBoxDes, todayBoxDesUnit, totalBoxUnit);
    }

    private void isEmpty(String todayBoxDes, String totalBoxDes, String todayBoxDesUnit, String totalBoxUnit) {
        if (TextUtils.isEmpty(todayBoxDes)) {
            tvTodayboxdes.setText("----");
        } else {
            tvTodayboxdes.setText(todayBoxDes);
        }
        if (TextUtils.isEmpty(totalBoxDes)) {
            tvTotalbox.setText("----");
        } else {
            tvTotalbox.setText(totalBoxDes);
        }
        if (TextUtils.isEmpty(todayBoxDesUnit)) {
            tvTodayBoxDesUnit.setText("----");
        } else {
            tvTodayBoxDesUnit.setText(todayBoxDesUnit);
        }
        if (TextUtils.isEmpty(totalBoxUnit)) {
            tvTotalBoxUnit.setText("----");
        } else {
            tvTotalBoxUnit.setText(totalBoxUnit);
        }
    }

    private void glideShowPic(String img, ImageView drawable) {
        Glide.with(this)
                .load(img)
                .fitCenter()
                .centerCrop()
                .into(drawable);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void onCompleted() {

        filmDetailRvAdapter.notifyDataSetChanged();
        fIlmShortPLRvAdapter.notifyDataSetChanged();
        filmDetailSwip.setRefreshing(false);
    }

    @Override
    public void onError(Throwable e) {
        filmDetailSwip.setRefreshing(false);
    }

    @Override
    public void setPresenter(FilmDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
