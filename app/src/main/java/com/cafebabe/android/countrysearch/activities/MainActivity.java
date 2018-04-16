package com.cafebabe.android.countrysearch.activities;

import android.support.v4.app.Fragment;

import com.cafebabe.android.countrysearch.fragments.MainFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }
}
