package com.example.changemax.sqhappy;

import android.app.Application;
import android.os.StrictMode;


import com.example.changemax.sqhappy.dagger.ApplicationModule;
import com.example.changemax.sqhappy.dagger.component.ApplicationComponent;
import com.example.changemax.sqhappy.dagger.component.DaggerApplicationComponent;
import com.example.changemax.sqhappy.model.network.ApiClient;
import com.example.changemax.sqhappy.model.network.ApiConstants;
import com.example.changemax.sqhappy.model.network.configuration.ApiConfiguration;
import com.orhanobut.logger.Logger;
import com.zhy.autolayout.config.AutoLayoutConifg;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by ChangeMax on 2017/3/14.
 */

public class FilmApplication extends Application {

    private ApplicationComponent applicationComponent;

    private static FilmApplication filmApplication;

    public static FilmApplication getInstance() {

        return filmApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
        }
        Logger.init("LogTAG");
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule((getApplicationContext())))
                .build();

        filmApplication = this;
        //拿设备的物理高度进行百分比化：
        AutoLayoutConifg.getInstance().useDeviceSize();
        //初始化ApiClient
        ApiConfiguration apiConfiguration = ApiConfiguration.builder()
                .dataSourceType(ApiConstants.FILM_DATA_SOURCE_TYPE_LOCATIONID)
                .build();
        ApiClient.init(apiConfiguration);
    }


    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
