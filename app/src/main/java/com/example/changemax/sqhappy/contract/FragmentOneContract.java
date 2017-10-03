package com.example.changemax.sqhappy.contract;

import com.example.changemax.sqhappy.model.network.entity.FilmInfoLocationBean;
import com.example.changemax.sqhappy.model.network.entity.FilmIsHitingBean;
import com.example.changemax.sqhappy.presenter.base.BasePresenter;
import com.example.changemax.sqhappy.presenter.base.BaseView;

import java.util.List;

/**
 * Created by ChangeMax on 2017/3/18.
 * 契约类 把View和Presenter所需的业务和UI层 全部方法展示出来  BasePresenter里可以写全局初始化的方法
 */

public interface FragmentOneContract {

    interface View extends BaseView<FragmentOneContract.Presenter> {

        void displayLocCityInformation(List<FilmInfoLocationBean.PBean> msBeanList);

        void onCompleted();

        void onError(Throwable e);
    }

    interface Presenter extends BasePresenter {

        void loadLocCityInfo();
    }
}
