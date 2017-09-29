package com.example.changemax.sqhappy.dagger.module.activity;

import com.example.changemax.sqhappy.contract.FilmDetailContract;
import com.example.changemax.sqhappy.presenter.activity.FilmDetailPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ChangeMax on 2017/3/20.
 */
@Module
public class FilmDetailModule {

    private FilmDetailContract.View view;

    public FilmDetailModule(FilmDetailContract.View view) {
        this.view = view;
    }


    @Provides
    FilmDetailPresenter providerFilmDetailAcPresenter() {
        return new FilmDetailPresenter(view);
    }
}
