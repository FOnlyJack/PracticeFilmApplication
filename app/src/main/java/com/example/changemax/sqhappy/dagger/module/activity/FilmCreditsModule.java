package com.example.changemax.sqhappy.dagger.module.activity;

import com.example.changemax.sqhappy.contract.FilmCreditsContract;
import com.example.changemax.sqhappy.presenter.activity.FilmCreditsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ChangeMax on 2017/3/24.
 */
@Module
public class FilmCreditsModule {
    private FilmCreditsContract.View view;

    public FilmCreditsModule(FilmCreditsContract.View view) {
        this.view = view;
    }

    @Provides
    FilmCreditsPresenter providerFilmCreditsAcPresenter() {
        return new FilmCreditsPresenter(view);
    }
}
