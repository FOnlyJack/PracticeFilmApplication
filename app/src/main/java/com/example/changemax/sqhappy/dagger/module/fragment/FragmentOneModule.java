package com.example.changemax.sqhappy.dagger.module.fragment;

import com.example.changemax.sqhappy.contract.FragmentOneContract;
import com.example.changemax.sqhappy.presenter.fragment.FragmentOnePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ChangeMax on 2017/3/18.
 */
@Module
public class FragmentOneModule {
    private FragmentOneContract.View view;

    public FragmentOneModule(FragmentOneContract.View view) {
        this.view = view;
    }


    @Provides
    FragmentOnePresenter providerFilmHitFragmentPresenter() {
        return new FragmentOnePresenter(view);
    }
}
