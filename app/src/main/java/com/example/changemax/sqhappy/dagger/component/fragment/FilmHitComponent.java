package com.example.changemax.sqhappy.dagger.component.fragment;

import com.example.changemax.sqhappy.dagger.module.fragment.FilmHitModule;
import com.example.changemax.sqhappy.ui.fragment.FilmHitFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ChangeMax on 2017/3/17.
 */
@Singleton
@Component(modules = FilmHitModule.class)
public interface FilmHitComponent {
    void inject(FilmHitFragment filmHitFragment);
}
