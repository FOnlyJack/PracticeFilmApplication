package com.example.changemax.sqhappy.dagger.component;

import android.content.Context;

import com.example.changemax.sqhappy.FilmApplication;
import com.example.changemax.sqhappy.dagger.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ChangeMax on 2017/3/14.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Context getContext();//提供Application的Context
}
