package com.cafebabe.android.countrysearch.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.cafebabe.android.countrysearch.R;



public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.base_container);  // Находит фрагмент по идентификатору
        if (fragment == null) {
            fragment = createFragment();
            fragmentManager.beginTransaction().add(R.id.base_container, fragment).commit();
        }
    }

    protected abstract Fragment createFragment();

}
