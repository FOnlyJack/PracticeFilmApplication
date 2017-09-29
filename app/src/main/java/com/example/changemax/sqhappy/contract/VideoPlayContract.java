package com.example.changemax.sqhappy.contract;

import com.example.changemax.sqhappy.model.network.entity.FilmVideoBean;
import com.example.changemax.sqhappy.presenter.base.BasePresenter;
import com.example.changemax.sqhappy.presenter.base.BaseView;

import java.util.List;

/**
 * Created by ChangeMax on 2017/3/22.
 */

public interface VideoPlayContract {
    interface View extends BaseView<VideoPlayContract.Presenter> {

        void displayFilmHitInformation(List<FilmVideoBean> msBeanList);

        void onCompleted();

        void onError(Throwable e);
    }

    interface Presenter extends BasePresenter {

        void loadFilmVideoListInfo(int pageIndex, int movieId);
    }
}
