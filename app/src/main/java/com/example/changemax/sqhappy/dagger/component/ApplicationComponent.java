package com.example.changemax.sqhappy.dagger.component;

import android.content.Context;

import com.example.changemax.sqhappy.FilmApplication;
import com.example.changemax.sqhappy.dagger.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ChangeMax on 2017/3/14.
 * 生命周期和Application一样的组件,可注入到自定义的Application类中
 */
@Singleton //Singleton代表注入的对象为单例
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Context getContext();//提供Application的Context
}
