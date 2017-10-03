package com.example.changemax.sqhappy.dagger.component.fragment;

import com.example.changemax.sqhappy.dagger.module.fragment.FragmentOneModule;
import com.example.changemax.sqhappy.ui.fragment.FragmentOne;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ChangeMax on 2017/3/18.
 * inject方法将FragmentOne注入到FragmentOneComponent
 */
@Singleton
@Component(modules = FragmentOneModule.class)
public interface FragmentOneComponent {
    void inject(FragmentOne fragmentOne);
}
