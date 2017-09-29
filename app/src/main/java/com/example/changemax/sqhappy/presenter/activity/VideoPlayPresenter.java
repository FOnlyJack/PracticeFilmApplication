package com.example.changemax.sqhappy.presenter.activity;

import com.example.changemax.sqhappy.FilmApplication;
import com.example.changemax.sqhappy.contract.VideoPlayContract;
import com.example.changemax.sqhappy.model.network.ApiDataManager;
import com.example.changemax.sqhappy.model.network.entity.FilmVideoBean;
import com.example.changemax.sqhappy.utils.SPUtils;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ChangeMax on 2017/3/20.
 */
public class VideoPlayPresenter implements VideoPlayContract.Presenter {
    private VideoPlayContract.View view;
    private List<FilmVideoBean> datalist;
    private CompositeSubscription compositeSubscription;

    public VideoPlayPresenter(VideoPlayContract.View view) {
        this.view = view;
        view.setPresenter(this);
        this.compositeSubscription = new CompositeSubscription();
        datalist = new ArrayList<>();
    }

    @Override
    public void loadFilmVideoListInfo(int pageIndex, int movieId) {

        Subscription subscribe = ApiDataManager.getFilmVideoInfo(pageIndex, movieId).doOnSubscribe(new Action0() {
            @Override
            public void call() {
                Logger.d("showLoading");
            }
        }).subscribe(new Subscriber<FilmVideoBean>() {
            @Override
            public void onCompleted() {
                view.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                view.onError(e);
            }

            @Override
            public void onNext(FilmVideoBean filmVideoBean) {
                datalist.add(filmVideoBean);
                view.displayFilmHitInformation(datalist);
                datalist.clear();
            }
        });
        compositeSubscription.add(subscribe);
    }

    @Override
    public void subscribe() {
        int movieID = (int) SPUtils.get(FilmApplication.getInstance(), "movieID", -1);
        loadFilmVideoListInfo(1, movieID);
    }

    @Override
    public void unSubscribe() {
        compositeSubscription.clear();
    }


}
