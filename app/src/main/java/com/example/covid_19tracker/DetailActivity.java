package com.example.covid_19tracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.leo.simplearcloader.SimpleArcLoader;

public class DetailActivity extends AppCompatActivity {
private int positionCountry;
    TextView tvCases,tvRecovered,tvCritical,tvActive,tvTodaycases,tvDeaths,tvCountry, tvTodaydeaths;
    SimpleArcLoader simpleArcLoader;
    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle("Details Activity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tvCountry=(TextView)findViewById(R.id.tvCountry) ;
        tvCases= (TextView)findViewById(R.id.tvCases);
        tvRecovered= (TextView)findViewById(R.id.tvRecovered);
        tvCritical= (TextView)findViewById(R.id.tvCritical);
        tvActive= (TextView)findViewById(R.id.tvActive);
        tvTodaycases= (TextView)findViewById(R.id.tvTodaycases);
        tvDeaths= (TextView)findViewById(R.id.tvDeaths);
        tvTodaydeaths= (TextView)findViewById(R.id.tvTodaydeaths);


        tvCountry.setText(AffectedCountries.countryModelList.get(positionCountry).getCountry());
        tvCases.setText(AffectedCountries.countryModelList.get(positionCountry).getCases());
        tvRecovered.setText(AffectedCountries.countryModelList.get(positionCountry).getRecovered());
        tvTodaydeaths.setText(AffectedCountries.countryModelList.get(positionCountry).getTodayDeaths());
        tvCritical.setText(AffectedCountries.countryModelList.get(positionCountry).getCritical());
        tvActive.setText(AffectedCountries.countryModelList.get(positionCountry).getActive());
        tvTodaycases.setText(AffectedCountries.countryModelList.get(positionCountry).getTodayCases());
        tvDeaths.setText(AffectedCountries.countryModelList.get(positionCountry).getDeaths());


        simpleArcLoader= findViewById(R.id.loader);
        scrollView= findViewById(R.id.scrollStats);

        Intent intent= new Intent();
        positionCountry= intent.getIntExtra("position",0);
    }
        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if(item.getItemId()==android.R.id.home)
                finish();
            return super.onOptionsItemSelected(item);
        }

}
