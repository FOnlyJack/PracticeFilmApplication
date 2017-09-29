package com.example.changemax.sqhappy.contract;

import com.example.changemax.sqhappy.model.network.entity.FilmDetainBean;
import com.example.changemax.sqhappy.model.network.entity.FilmIsHitingBean;
import com.example.changemax.sqhappy.model.network.entity.FilmReviewsBean;
import com.example.changemax.sqhappy.presenter.base.BasePresenter;
import com.example.changemax.sqhappy.presenter.base.BaseView;

import java.util.List;

/**
 * Created by ChangeMax on 2017/3/17.
 */

public interface FilmDetailContract {
    interface View extends BaseView<Presenter> {

        void displayFilmDetailInformation(List<FilmDetainBean.DataBean> msBeanList);

        void displayFileHotCommentInformation(List<FilmReviewsBean.DataBean> msBeanList);

        void showProgressBar();

        void hideProgressBar();

        void onCompleted();

        void onError(Throwable e);
    }

    interface Presenter extends BasePresenter {

        void loadFilmDetailInfo(int locationId, int MovieId);

        void loadFileHotComment(int MovieId);
    }
}
