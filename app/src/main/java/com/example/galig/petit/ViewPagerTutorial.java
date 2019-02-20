package com.example.galig.petit;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class ViewPagerTutorial extends FragmentActivity {
    private  static  final int numpag = 4;

    private ViewPager mPager;

    private PagerAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial00)
    }
}
