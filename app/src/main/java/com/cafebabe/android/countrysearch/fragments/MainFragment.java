package com.cafebabe.android.countrysearch.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.cafebabe.android.countrysearch.R;
import com.cafebabe.android.countrysearch.models.Parser;



public class MainFragment extends Fragment {

    public static final String TAG = "MainFragment";

    private String mCity;

    private EditText mCityField;
    private EditText mCountryField;
    private Button mSearchButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mCityField = (EditText) view.findViewById(R.id.city_field);
        mCountryField = (EditText) view.findViewById(R.id.country_field);
        mSearchButton = (Button) view.findViewById(R.id.search_button);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCity = mCityField.getText().toString();
                Log.i(TAG, mCity);
                new SearchTask().execute();

            }
        });
        return view;
    }


    private class SearchTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            String country = new Parser().search(mCity);
            Log.i(TAG, country);
            return country;
        }

        @Override
        protected void onPostExecute(String country) {
            mCity = country;
            mCountryField.setText(country);
        }
    }

}
