package com.example.changemax.sqhappy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.changemax.sqhappy.R;
import com.example.changemax.sqhappy.ui.fragment.FragmentOne;
import com.example.changemax.sqhappy.ui.fragment.FragmentTwo;
import com.example.changemax.sqhappy.ui.fragment.FragmentThree;
import com.example.changemax.sqhappy.ui.fragment.FragmentFour;
import com.example.changemax.sqhappy.ui.view.FragmentTabHost;
import com.orhanobut.logger.Logger;


/**
 * Created by ChangeMax on 2017/3/15.
 */

public class MainActivity extends BaseActivity {
    private FragmentTabHost fragmentTabHost;
    private String[] tabText = {"聊天", "朋友", "通讯录", "设置"};
    private int[] imageRes = new int[]{R.drawable.homepage_selector, R.drawable.nailartist_selector, R.drawable.search_selector, R.drawable.me_selector};
    private Class[] fragments = new Class[]{FragmentOne.class, FragmentThree.class, FragmentTwo.class, FragmentFour.class};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        fragmentTabHost = (FragmentTabHost) findViewById(R.id.fg_tabhost);
        fragmentTabHost.setup(this, getSupportFragmentManager(), R.id.flContainer);
        fragmentTabHost.getTabWidget().setDividerDrawable(null);
        for (int i = 0; i < tabText.length; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.tab_item_view, null);
            ((TextView) view.findViewById(R.id.textview)).setText(tabText[i]);
            ((ImageView) view.findViewById(R.id.imageview)).setImageResource(imageRes[i]);
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(tabText[i]).setIndicator(view);
            fragmentTabHost.addTab(tabSpec, fragments[i], null);
            fragmentTabHost.setTag(i);
        }
    }
}
