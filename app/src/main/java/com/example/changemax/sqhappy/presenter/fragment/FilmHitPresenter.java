package com.example.changemax.sqhappy.presenter.fragment;

import com.example.changemax.sqhappy.FilmApplication;
import com.example.changemax.sqhappy.contract.FilmHitContract;
import com.example.changemax.sqhappy.model.network.ApiDataManager;
import com.example.changemax.sqhappy.model.network.entity.FilmIsHitingBean;
import com.example.changemax.sqhappy.utils.SPUtils;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by ChangeMax on 2017/3/17.
 */
public class FilmHitPresenter implements FilmHitContract.Presenter {

    private final FilmHitContract.View view;
    private List<FilmIsHitingBean.MsBean> datalist;
    private CompositeSubscription compositeSubscription;

    public FilmHitPresenter(FilmHitContract.View view) {
        this.view = view;
        this.compositeSubscription = new CompositeSubscription();
        datalist = new ArrayList<>();
        view.setPresenter(this);
    }

    @Override
    public void loadFilmHitInfo(int locationId) {

        Subscription subscription = ApiDataManager.getFilmHiting(locationId)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        Logger.d("showLoading");
                    }
                }).subscribe(new Subscriber<FilmIsHitingBean>() {
                    @Override
                    public void onCompleted() {
                        view.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError(e);
                    }

                    @Override
                    public void onNext(FilmIsHitingBean filmIsHitingBean) {
                        datalist.addAll(filmIsHitingBean.getMs());
                        view.displayFilmHitInformation(datalist);
                        datalist.clear();
                    }

                });
        compositeSubscription.add(subscription);
    }

    @Override
    public void subscribe() {

        int locationId = (int) SPUtils.get(FilmApplication.getInstance(), "locationId", 290);
        loadFilmHitInfo(locationId);
    }

    @Override
    public void unSubscribe() {
        compositeSubscription.clear();
    }
}
