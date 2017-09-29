package com.example.changemax.sqhappy.presenter.activity;

import com.example.changemax.sqhappy.FilmApplication;
import com.example.changemax.sqhappy.contract.FilmDetailContract;
import com.example.changemax.sqhappy.model.network.ApiDataManager;
import com.example.changemax.sqhappy.model.network.entity.FilmDetainBean;
import com.example.changemax.sqhappy.model.network.entity.FilmReviewsBean;
import com.example.changemax.sqhappy.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ChangeMax on 2017/3/20.
 */
public class FilmDetailPresenter implements FilmDetailContract.Presenter {
    private FilmDetailContract.View view;
    private List<FilmDetainBean.DataBean> datalist;
    private List<FilmReviewsBean.DataBean> reviewlist;
    private CompositeSubscription compositeSubscription;

    public FilmDetailPresenter(FilmDetailContract.View view) {
        this.view = view;
        view.setPresenter(this);
        this.compositeSubscription = new CompositeSubscription();
        datalist = new ArrayList<>();
        reviewlist = new ArrayList<>();
    }


    @Override
    public void loadFilmDetailInfo(int locationId,int MovieId) {

        Subscription subscription = ApiDataManager.getFilmDetainInfo(locationId, MovieId)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        view.showProgressBar();
                    }
                }).subscribe(new Subscriber<FilmDetainBean>() {
                    @Override
                    public void onCompleted() {
                        view.onCompleted();
                        view.hideProgressBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError(e);
                    }

                    @Override
                    public void onNext(FilmDetainBean filmDetainBean) {
                        datalist.add(filmDetainBean.getData());
                        view.displayFilmDetailInformation(datalist);
                        datalist.clear();
                    }
                });
        compositeSubscription.add(subscription);
    }

    @Override
    public void loadFileHotComment(int MovieId) {
        Subscription subscription = ApiDataManager.getFilmCommentInfo(MovieId)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        view.showProgressBar();
                    }
                }).subscribe(new Subscriber<FilmReviewsBean>() {
                    @Override
                    public void onCompleted() {
                        view.onCompleted();
                        view.hideProgressBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError(e);
                    }

                    @Override
                    public void onNext(FilmReviewsBean filmReviewsBean) {
                        reviewlist.add(filmReviewsBean.getData());
                        view.displayFileHotCommentInformation(reviewlist);
                        reviewlist.clear();
                    }
                });
        compositeSubscription.add(subscription);
    }

    @Override
    public void subscribe() {
        int locationId = (int) SPUtils.get(FilmApplication.getInstance(), "locationId", 290);
        int movieID = (int) SPUtils.get(FilmApplication.getInstance(), "movieID", -1);
        loadFilmDetailInfo(locationId,movieID);
        loadFileHotComment(movieID);
    }

    @Override
    public void unSubscribe() {
        compositeSubscription.clear();
    }
}
