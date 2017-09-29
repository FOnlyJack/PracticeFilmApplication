package com.example.changemax.sqhappy.dagger.module.fragment;

import com.example.changemax.sqhappy.contract.FilmHitContract;
import com.example.changemax.sqhappy.presenter.fragment.FilmHitPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ChangeMax on 2017/3/17.
 */
@Module
public class FilmHitModule {

    private FilmHitContract.View view;
    public FilmHitModule(FilmHitContract.View view) {
        this.view=view;
    }



    @Provides
    FilmHitPresenter providerFilmHitFragmentPresenter() {
        return new FilmHitPresenter(view);
    }
}
