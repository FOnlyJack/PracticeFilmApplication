package com.example.changemax.sqhappy.dagger.module.activity;

import com.example.changemax.sqhappy.contract.VideoPlayContract;
import com.example.changemax.sqhappy.presenter.activity.VideoPlayPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ChangeMax on 2017/3/22.
 */
@Module()
public class VideoPlayModule {
    private VideoPlayContract.View view;

    public VideoPlayModule(VideoPlayContract.View view) {
        this.view = view;
    }
    @Provides
    VideoPlayPresenter providerFilmVideoAcPresenter() {
        return new VideoPlayPresenter(view);
    }
}
