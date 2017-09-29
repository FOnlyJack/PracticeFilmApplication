package com.example.changemax.sqhappy.dagger.component.activity;

import com.example.changemax.sqhappy.dagger.module.activity.FilmDetailModule;
import com.example.changemax.sqhappy.ui.activity.FilmDetailActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ChangeMax on 2017/3/20.
 */

@Singleton
@Component(modules = FilmDetailModule.class)
public interface FilmDetailComponent {
    void inject(FilmDetailActivity filmDetailActivity);
}