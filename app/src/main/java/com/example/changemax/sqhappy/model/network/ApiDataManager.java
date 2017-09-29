package com.example.changemax.sqhappy.model.network;

import com.example.changemax.sqhappy.model.network.configuration.ApiConfiguration;
import com.example.changemax.sqhappy.model.network.entity.FilmComingNewBean;
import com.example.changemax.sqhappy.model.network.entity.FilmCreditsBean;
import com.example.changemax.sqhappy.model.network.entity.FilmDetainBean;
import com.example.changemax.sqhappy.model.network.entity.FilmInfoLocationBean;
import com.example.changemax.sqhappy.model.network.entity.FilmIsHitingBean;
import com.example.changemax.sqhappy.model.network.entity.FilmReviewsBean;
import com.example.changemax.sqhappy.model.network.entity.FilmStagePhotoBean;
import com.example.changemax.sqhappy.model.network.entity.FilmVideoBean;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ChangeMax on 2017/3/15.
 * 各个请求接口方法的管理
 */

public class ApiDataManager {


    /**
     * 获取本地电影的location
     */
    public static Observable<FilmInfoLocationBean> getFilmLocation(String url) {
        initApiConfigutation(ApiConstants.FILM_DATA_SOURCE_TYPE_LOCATIONID);
        return ApiClient.getApiService().getFilmInfoLocation(url)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 正在热映
     */
    public static Observable<FilmIsHitingBean> getFilmHiting(int locationid) {
        initApiConfigutation(ApiConstants.FILM_DATA_SOURCE_TYPE_HITING);
        return ApiClient.getApiService().getFilmIsHiting(locationid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 即将上映
     */
    public static Observable<FilmComingNewBean> getFilmComingNew(int locationid) {
        initApiConfigutation(ApiConstants.FILM_DATA_SOURCE_TYPE_CREDITS_VIDEO_STAGE_COMING_NEW);
        return ApiClient.getApiService().getFilmComingNew(locationid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 影片详情
     */
    public static Observable<FilmDetainBean> getFilmDetainInfo(int locationid, int movieid) {
        initApiConfigutation(ApiConstants.FILM_DATA_SOURCE_TYPE_DETAININFO_REVIEWS);
        return ApiClient.getApiService().getFilmDetail(locationid, movieid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 演职员表 没有做人员详细信息 url：https://ticket-api-m.mtime.cn/person/detail.api?personId=?&cityId=？
     */
    public static Observable<FilmCreditsBean> getFilmCreditInfo(int movieid) {
        initApiConfigutation(ApiConstants.FILM_DATA_SOURCE_TYPE_CREDITS_VIDEO_STAGE_COMING_NEW);
        return ApiClient.getApiService().getFilmCredits(movieid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 影片评论
     */
    public static Observable<FilmReviewsBean> getFilmCommentInfo(int movieid) {
        initApiConfigutation(ApiConstants.FILM_DATA_SOURCE_TYPE_DETAININFO_REVIEWS);
        return ApiClient.getApiService().getFilmReviews(movieid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 预告片&拍摄花絮
     */
    public static Observable<FilmVideoBean> getFilmVideoInfo(int pageIndex , int movieid) {
        initApiConfigutation(ApiConstants.FILM_DATA_SOURCE_TYPE_CREDITS_VIDEO_STAGE_COMING_NEW);
        return ApiClient.getApiService().getFilmVideo(pageIndex , movieid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 剧照
     */
    public static Observable<FilmStagePhotoBean> getFilmStageInfo(int movieid) {
        initApiConfigutation(ApiConstants.FILM_DATA_SOURCE_TYPE_DETAININFO_REVIEWS);
        return ApiClient.getApiService().getFilmStagePto(movieid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private static void initApiConfigutation(int dataSourceType) {
        ApiConfiguration apiConfiguration = ApiConfiguration.builder()
                .dataSourceType(dataSourceType)
                .build();
        ApiClient.init(apiConfiguration);
    }
}
