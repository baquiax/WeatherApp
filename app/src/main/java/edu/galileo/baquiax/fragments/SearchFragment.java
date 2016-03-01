package edu.galileo.baquiax.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.weatherapp.R;
import edu.galileo.android.weatherapp.activities.WeatherDetailActivity;
import edu.galileo.android.weatherapp.adapter.CustomRecyclerAdapter;
import edu.galileo.android.weatherapp.adapter.OnItemClickListener;
import edu.galileo.android.weatherapp.model.WeatherInfo;


public class SearchFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.btnSubmit)
    Button btnSubmit;
    @Bind(R.id.inputCity)
    EditText inputCity;
    SearchCommunication channel;
    public SearchFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, view);
        btnSubmit.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSubmit) {
            Log.d("onClick", "onClick: " + inputCity.getText().toString());
            if (this.channel != null && inputCity.getText().toString().length() > 0) {
                this.channel.searchCity(inputCity.getText().toString());
            }
        }
    }

    @Override
    public void  onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof  SearchCommunication) {
            this.channel = (SearchCommunication)context;
        }
    }

    @Override
    public void  onResume() {
        super.onResume();
        if (this.channel != null && inputCity.getText().toString().length() > 0) {
            this.channel.searchCity(inputCity.getText().toString());
        }
    }
}
