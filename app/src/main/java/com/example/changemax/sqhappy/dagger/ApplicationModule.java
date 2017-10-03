package com.example.changemax.sqhappy.dagger;

import android.content.Context;

import com.example.changemax.sqhappy.FilmApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ChangeMax on 2017/3/14.
 * 提供ApplicationComponent里需要注入的对象。
 */
@Module
public class ApplicationModule {
    private final Context mContext;

    public ApplicationModule(Context context) {
        this.mContext = context;
    }

    @Provides
    Context provideApplication() {
        return mContext;
    }
}
