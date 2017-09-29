package com.example.changemax.sqhappy.model.network;

import android.support.annotation.NonNull;

import com.example.changemax.sqhappy.FilmApplication;
import com.example.changemax.sqhappy.model.network.configuration.ApiConfiguration;
import com.example.changemax.sqhappy.model.network.converter.FastJsonConverterFactory;
import com.example.changemax.sqhappy.model.network.service.ApiService;
import com.example.changemax.sqhappy.utils.NetUtil;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by ChangeMax on 2017/3/14.
 * 网络通信服务的启动控制，必须先初始化
 */

public final class ApiClient {


    public static ApiService apiService;
    public static ApiConfiguration configuration;
    //设缓存有效期为1天
    static final long CACHE_STALE_SEC = 60 * 60 * 24 * 1;
    //查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
    private static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;


    public static void init(ApiConfiguration apiConfiguration) {
        configuration = apiConfiguration;
        String filmApiHost;
        switch (configuration.getDataSourceType()) {
            case ApiConstants.FILM_DATA_SOURCE_TYPE_CREDITS_VIDEO_STAGE_COMING_NEW:
                filmApiHost = ApiConstants.FILM_CREDITS_VIDEO_STAGE_COMING_NEW_HOST;
                apiService = initFilmService(filmApiHost, ApiService.class);
                break;
            case ApiConstants.FILM_DATA_SOURCE_TYPE_DETAININFO_REVIEWS:
                filmApiHost = ApiConstants.FILM_DETAININFO_REVIEWS_HOST;
                apiService = initFilmService(filmApiHost, ApiService.class);
                break;
            case ApiConstants.FILM_DATA_SOURCE_TYPE_HITING:
                filmApiHost = ApiConstants.FILM_IS_HITING_HOST;
                apiService = initFilmService(filmApiHost, ApiService.class);
                break;
            case ApiConstants.FILM_DATA_SOURCE_TYPE_LOCATIONID:
                filmApiHost = ApiConstants.FILM_INFORMATION_BASIS_LOCATIONID_HOST;
                apiService = initFilmService(filmApiHost, ApiService.class);
                break;
        }
    }

    public static ApiService getApiService() {
        return apiService;
    }

    private static <T> T initFilmService(String baseUrl, Class<T> apiServiceClass) {

        Cache cache = new Cache(new File(FilmApplication.getInstance().getCacheDir(), "OkHttpCache"), 1024 * 1024 * 100);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().cache(cache)
                .retryOnConnectionFailure(true)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(sRewriteCacheControlInterceptor)
                .addNetworkInterceptor(sRewriteCacheControlInterceptor)
                .connectTimeout(15000, TimeUnit.MILLISECONDS)
                .writeTimeout(15000, TimeUnit.MILLISECONDS)
                .readTimeout(15000, TimeUnit.MILLISECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(apiServiceClass);
    }

    //配置网络缓存的拦截器
    private static final Interceptor sRewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetUtil.isNetworkAvailable(FilmApplication.getInstance())) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
                Logger.e("no network");
            }
            Response originalResponse = chain.proceed(request);
            if (NetUtil.isNetworkAvailable(FilmApplication.getInstance())) {
                //有网的情况下获取接口Header上的配置
                String cacheStr = request.cacheControl().toString();
                return originalResponse.newBuilder().header("Cache-Control", cacheStr)
                        .removeHeader("Pragma")
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, " + CACHE_CONTROL_CACHE)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    };
}
