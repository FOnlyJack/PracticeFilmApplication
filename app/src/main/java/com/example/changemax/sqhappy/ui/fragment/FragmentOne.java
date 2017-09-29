package com.example.changemax.sqhappy.ui.fragment;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.example.changemax.sqhappy.FilmApplication;
import com.example.changemax.sqhappy.R;
import com.example.changemax.sqhappy.contract.FragmentOneContract;
import com.example.changemax.sqhappy.dagger.component.fragment.DaggerFragmentOneComponent;
import com.example.changemax.sqhappy.dagger.module.fragment.FragmentOneModule;
import com.example.changemax.sqhappy.model.network.entity.FilmInfoLocationBean;
import com.example.changemax.sqhappy.presenter.fragment.FragmentOnePresenter;
import com.example.changemax.sqhappy.ui.BaseFragment;
import com.example.changemax.sqhappy.ui.adapter.TabPagerAdapter;
import com.example.changemax.sqhappy.ui.view.AutoTabLayout;
import com.example.changemax.sqhappy.utils.SPUtils;
import com.orhanobut.logger.Logger;
import com.zaaach.citypicker.CityPickerActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static android.app.Activity.RESULT_OK;

/**
 * Created by ChangeMax on 2017/3/15.
 */
public class FragmentOne extends BaseFragment implements FragmentOneContract.View {
    private static final int REQUEST_CODE_PICK_CITY = 0;
    private AutoTabLayout autoTabLayout;
    private ViewPager viewPager;
    private TextView tv_location;
    private List<Fragment> mViewList = new ArrayList<>();//页卡视图集合
    private FilmHitFragment filmHitFragment;
    private FilmComingFragment filmComingFragment;
    private FragmentOneContract.Presenter presenter;
    @Inject
    FragmentOnePresenter fragmentOnePresenter;
    private String city;


    @Override
    public int getLayoutRes() {
        return R.layout.fragment_tab_one;
    }

    @Override
    public void initView() {
        autoTabLayout = findView(R.id.film_tab_layout);
        viewPager = findView(R.id.tab_view_pager);
        tv_location = findView(R.id.tv_location);
        initTabLayout();
        initListener();
        DaggerFragmentOneComponent.builder()
                .fragmentOneModule(new FragmentOneModule(this))
                .build()
                .inject(this);
    }

    private void initTabLayout() {
        filmHitFragment = FilmHitFragment.newInstance(1);
        filmComingFragment = FilmComingFragment.newInstance(2);
        mViewList.add(filmHitFragment);
        mViewList.add(filmComingFragment);
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getChildFragmentManager(), getActivity(), mViewList);
        viewPager.setAdapter(tabPagerAdapter);
        autoTabLayout.setupWithViewPager(viewPager);
        autoTabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < autoTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = autoTabLayout.getTabAt(i);
            tab.setCustomView(tabPagerAdapter.getTabView(i));
        }
    }

    private void initListener() {
        tv_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击进入城市选择页面
                startActivityForResult(new Intent(getActivity(), CityPickerActivity.class), REQUEST_CODE_PICK_CITY);
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                tv_location.setText(city);
                //联网获取城市的ID
                assert presenter != null;
                presenter.subscribe();
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unSubscribe();
    }


    @Override
    public void displayLocCityInformation(List<FilmInfoLocationBean.PBean> msBeanList) {
        for (int i = 0; i < msBeanList.size(); i++) {
            String n = msBeanList.get(i).getN();
            if (city.contains(n)) {
                int cityId = msBeanList.get(i).getId();
                if (SPUtils.contains(FilmApplication.getInstance(), "locationId")) {
                    SPUtils.remove(FilmApplication.getInstance(), "locationId");
                    SPUtils.put(FilmApplication.getInstance(), "locationId", cityId);
                } else {
                    SPUtils.put(FilmApplication.getInstance(), "locationId", cityId);
                }
                Logger.d("传递的城市ID" + cityId);
            }
        }
    }

    @Override
    public void onCompleted() {
        Intent intent = new Intent("com.example.changemax.sqhappy.ACTION_SEND_SELECED_CITY");
        intent.putExtra("msg_car", true);
        getContext().sendBroadcast(intent);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void setPresenter(FragmentOneContract.Presenter presenter) {
        this.presenter = presenter;
    }


}
