package com.example.changemax.sqhappy.dagger.component.activity;

import com.example.changemax.sqhappy.dagger.module.activity.FilmCreditsModule;
import com.example.changemax.sqhappy.ui.activity.FilmCreditsActivity;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by ChangeMax on 2017/3/24.
 */
@Singleton
@Component(modules = FilmCreditsModule.class)
public interface FilmCreditsComponent {
    void inject(FilmCreditsActivity filmDetailActivity);
}
