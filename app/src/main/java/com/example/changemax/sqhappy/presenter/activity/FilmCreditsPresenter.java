package com.example.changemax.sqhappy.presenter.activity;

import com.example.changemax.sqhappy.FilmApplication;
import com.example.changemax.sqhappy.contract.FilmCreditsContract;
import com.example.changemax.sqhappy.model.network.ApiDataManager;
import com.example.changemax.sqhappy.model.network.entity.FilmCreditsBean;
import com.example.changemax.sqhappy.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ChangeMax on 2017/3/24.
 */

public class FilmCreditsPresenter implements FilmCreditsContract.Presenter {

    private List<FilmCreditsBean> filmCreditsBeanList;
    private FilmCreditsContract.View view;
    private CompositeSubscription compositeSubscription;

    public FilmCreditsPresenter(FilmCreditsContract.View view) {
        this.view = view;
        view.setPresenter(this);
        filmCreditsBeanList = new ArrayList<>();
        compositeSubscription = new CompositeSubscription();
    }


    @Override
    public void loadFilmCreditsInfo(int MovieId) {
        Subscription subscribe = ApiDataManager.getFilmCreditInfo(MovieId).doOnSubscribe(new Action0() {
            @Override
            public void call() {
                view.showProgressBar();
            }
        }).subscribe(new Subscriber<FilmCreditsBean>() {
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
            public void onNext(FilmCreditsBean filmCreditsBean) {
                filmCreditsBeanList.add(filmCreditsBean);
                view.displayFilmCreditsInformation(filmCreditsBeanList);
                filmCreditsBeanList.clear();
            }
        });
        compositeSubscription.add(subscribe);
    }

    @Override
    public void subscribe() {
        int movieID = (int) SPUtils.get(FilmApplication.getInstance(), "movieID", -1);
        loadFilmCreditsInfo(movieID);
    }

    @Override
    public void unSubscribe() {
        compositeSubscription.clear();
    }
}
