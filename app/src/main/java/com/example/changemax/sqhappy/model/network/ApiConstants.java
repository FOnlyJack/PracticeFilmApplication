package com.example.changemax.sqhappy.model.network;


public final class ApiConstants {
    //因为电影的信息会根据地区的不同而不同，所以在 url 后面需要拼接地区 locationId
    public static final String FILM_INFORMATION_BASIS_LOCATIONID_HOST = "https://api-m.mtime.cn/Showtime/HotCitiesByCinema.api/";
    //正在热映
    public static final String FILM_IS_HITING_HOST = "https://api-m.mtime.cn/Showtime/";
    //影片详情  影片评论
    public static final String FILM_DETAININFO_REVIEWS_HOST = "https://ticket-api-m.mtime.cn/movie/";
    //演职员表 预告片&拍摄花絮 剧照 即将上映
    public static final String FILM_CREDITS_VIDEO_STAGE_COMING_NEW_HOST = "https://api-m.mtime.cn/Movie/";

    public static final int FILM_DATA_SOURCE_TYPE_LOCATIONID = 1;
    public static final int FILM_DATA_SOURCE_TYPE_HITING = 2;
    public static final int FILM_DATA_SOURCE_TYPE_DETAININFO_REVIEWS = 3;
    public static final int FILM_DATA_SOURCE_TYPE_CREDITS_VIDEO_STAGE_COMING_NEW = 4;


    //查询网络的Cache-Control设置
    //(假如请求了服务器并在a时刻返回响应结果，则在max-age规定的秒数内，浏览器将不会发送对应的请求到服务器，数据由缓存直接返回)
    public static final String CACHE_CONTROL_NETWORK = "Cache-Control: public, max-age=3600";
    // 避免出现 HTTP 403 Forbidden，参考：http://stackoverflow.com/questions/13670692/403-forbidden-with-java-but-not-web-browser
    public static final String AVOID_HTTP403_FORBIDDEN = "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11";

}
