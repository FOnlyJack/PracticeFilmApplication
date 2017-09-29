package com.example.changemax.sqhappy.contract;

import com.example.changemax.sqhappy.model.network.entity.FilmIsHitingBean;
import com.example.changemax.sqhappy.presenter.base.BasePresenter;
import com.example.changemax.sqhappy.presenter.base.BaseView;

import java.util.List;

/**
 * Created by ChangeMax on 2017/3/17.
 */

public interface FilmHitContract {
    interface View extends BaseView<Presenter> {

        void displayFilmHitInformation(List<FilmIsHitingBean.MsBean> msBeanList);

        void onCompleted();

        void onError(Throwable e);
    }

    interface Presenter extends BasePresenter {

        void loadFilmHitInfo(int locationId);
    }
}
