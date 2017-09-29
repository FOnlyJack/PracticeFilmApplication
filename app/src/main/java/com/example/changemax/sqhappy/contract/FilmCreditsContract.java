package com.example.changemax.sqhappy.contract;

import com.example.changemax.sqhappy.model.network.entity.FilmCreditsBean;
import com.example.changemax.sqhappy.model.network.entity.FilmDetainBean;
import com.example.changemax.sqhappy.model.network.entity.FilmReviewsBean;
import com.example.changemax.sqhappy.presenter.base.BasePresenter;
import com.example.changemax.sqhappy.presenter.base.BaseView;

import java.util.List;

/**
 * Created by ChangeMax on 2017/3/24.
 */

public interface FilmCreditsContract {
    interface View extends BaseView<FilmCreditsContract.Presenter> {

        void displayFilmCreditsInformation(List<FilmCreditsBean> msBeanList);

        void showProgressBar();

        void hideProgressBar();

        void onCompleted();

        void onError(Throwable e);
    }

    interface Presenter extends BasePresenter {

        void loadFilmCreditsInfo(int MovieId);

    }
}
