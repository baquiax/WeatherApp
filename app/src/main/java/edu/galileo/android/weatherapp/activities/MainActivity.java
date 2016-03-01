package edu.galileo.android.weatherapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.galileo.android.weatherapp.R;
import edu.galileo.android.weatherapp.fragments.ForecastFragment;
import edu.galileo.android.weatherapp.model.WeatherInfo;
import edu.galileo.baquiax.fragments.SearchCommunication;
import edu.galileo.baquiax.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity implements SearchCommunication {
    private final static String TAG = "MainActivity";
    ForecastFragment forecast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.forecast = (ForecastFragment) getSupportFragmentManager().findFragmentById(R.id.forecastFragment);
    }

    @Override
    public void searchCity(String cityName) {
        forecast.searchCity(cityName);
    }
}
