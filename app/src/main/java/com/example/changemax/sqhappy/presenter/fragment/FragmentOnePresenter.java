package com.example.changemax.sqhappy.presenter.fragment;

import com.example.changemax.sqhappy.contract.FilmHitContract;
import com.example.changemax.sqhappy.contract.FragmentOneContract;
import com.example.changemax.sqhappy.model.network.ApiConstants;
import com.example.changemax.sqhappy.model.network.ApiDataManager;
import com.example.changemax.sqhappy.model.network.entity.FilmInfoLocationBean;
import com.example.changemax.sqhappy.model.network.entity.FilmIsHitingBean;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ChangeMax on 2017/3/18.
 */
public class FragmentOnePresenter implements FragmentOneContract.Presenter {
    private final FragmentOneContract.View view;
    private List<FilmInfoLocationBean.PBean> datalist;
    private CompositeSubscription compositeSubscription;

    public FragmentOnePresenter(FragmentOneContract.View view) {
        this.view = view;
        datalist = new ArrayList<>();
        view.setPresenter(this);
        this.compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void loadLocCityInfo() {
        Subscription subscription = ApiDataManager.getFilmLocation(ApiConstants.FILM_INFORMATION_BASIS_LOCATIONID_HOST)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        Logger.d("showLoading");
                    }
                }).subscribe(new Subscriber<FilmInfoLocationBean>() {
                    @Override
                    public void onCompleted() {
                        view.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onError(e);
                    }

                    @Override
                    public void onNext(FilmInfoLocationBean filmInfoLocationBean) {
                        datalist.addAll(filmInfoLocationBean.getP());
                        view.displayLocCityInformation(datalist);
                        datalist.clear();
                    }
                });
        compositeSubscription.add(subscription);
    }

    @Override
    public void subscribe() {
        loadLocCityInfo();
    }

    @Override
    public void unSubscribe() {
        compositeSubscription.clear();
    }
}
