package com.example.changemax.sqhappy.dagger.component.activity;

import com.example.changemax.sqhappy.dagger.module.activity.VideoPlayModule;
import com.example.changemax.sqhappy.ui.activity.VideoPlayActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ChangeMax on 2017/3/22.
 */
@Singleton
@Component(modules = VideoPlayModule.class)
public interface VideoPlayComponent {
    void inject(VideoPlayActivity videoPlayActivity);
}
