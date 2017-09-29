package com.example.changemax.sqhappy.model.network.service;

import com.example.changemax.sqhappy.model.network.ApiConstants;
import com.example.changemax.sqhappy.model.network.entity.FilmComingNewBean;
import com.example.changemax.sqhappy.model.network.entity.FilmCreditsBean;
import com.example.changemax.sqhappy.model.network.entity.FilmDetainBean;
import com.example.changemax.sqhappy.model.network.entity.FilmInfoLocationBean;
import com.example.changemax.sqhappy.model.network.entity.FilmIsHitingBean;
import com.example.changemax.sqhappy.model.network.entity.FilmReviewsBean;
import com.example.changemax.sqhappy.model.network.entity.FilmStagePhotoBean;
import com.example.changemax.sqhappy.model.network.entity.FilmVideoBean;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by ChangeMax on 2017/3/14.
 */

public interface ApiService {
    /**
     * 本地的电影信息
     */
    @Headers(ApiConstants.AVOID_HTTP403_FORBIDDEN)
    @GET
    Observable<FilmInfoLocationBean> getFilmInfoLocation(@Url String url);

    /**
     * 正在热映
     */
    @Headers(ApiConstants.CACHE_CONTROL_NETWORK)
    @GET("LocationMovies.api")
    Observable<FilmIsHitingBean> getFilmIsHiting(@Query("locationId") int locationid);

    /**
     * 即将上映
     */
    @Headers(ApiConstants.CACHE_CONTROL_NETWORK)
    @GET("MovieComingNew.api")
    Observable<FilmComingNewBean> getFilmComingNew(@Query("locationId") int locationid);

    /**
     * 影片详情
     */
    @Headers(ApiConstants.CACHE_CONTROL_NETWORK)
    @GET("detail.api")
    Observable<FilmDetainBean> getFilmDetail(@Query("locationId") int locationid, @Query("movieId") int movieId);
    /**
     * 演职员表
     */
    @Headers(ApiConstants.CACHE_CONTROL_NETWORK)
    @GET("MovieCreditsWithTypes.api")
    Observable<FilmCreditsBean> getFilmCredits(@Query("movieId") int movieId);
    /**
     * 影片评论
     */
    @Headers(ApiConstants.CACHE_CONTROL_NETWORK)
    @GET("hotComment.api")
    Observable<FilmReviewsBean> getFilmReviews(@Query("movieId") int movieId);
    /**
     * 预告片&拍摄花絮
     */
    @Headers(ApiConstants.CACHE_CONTROL_NETWORK)
    @GET("Video.api")
    Observable<FilmVideoBean> getFilmVideo(@Query("pageIndex") int pageIndex, @Query("movieId") int movieId);
    /**
     * 剧照  ImageAll.api
     */
    @Headers(ApiConstants.CACHE_CONTROL_NETWORK)
    @GET("ImageAll.api")
    Observable<FilmStagePhotoBean> getFilmStagePto(@Query("movieId") int movieId);
}
