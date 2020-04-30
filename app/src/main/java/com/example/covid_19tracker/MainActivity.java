package com.example.covid_19tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {
TextView tvCases,tvRecovered,tvCritical,tvActive,tvTodaycases,tvDeaths, tvTodaydeaths,tvAffectedCountries;
SimpleArcLoader simpleArcLoader;
PieChart pieChart;
ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCases= (TextView)findViewById(R.id.tvCases);
        tvRecovered= (TextView)findViewById(R.id.tvRecovered);
        tvCritical= (TextView)findViewById(R.id.tvCritical);
        tvActive= (TextView)findViewById(R.id.tvActive);
        tvTodaycases= (TextView)findViewById(R.id.tvTodaycases);
        tvDeaths= (TextView)findViewById(R.id.tvDeaths);
        tvTodaydeaths= (TextView)findViewById(R.id.tvTodaydeaths);
        tvAffectedCountries= (TextView)findViewById(R.id.tvAffectedCountries);

        simpleArcLoader= findViewById(R.id.loader);
        scrollView= findViewById(R.id.scrollStats);
        pieChart= findViewById(R.id.piechart);

        fetchData();

    }

    private void fetchData() {
        String url= "https://corona.lmao.ninja/v2/all/";

        simpleArcLoader.start();

        StringRequest request= new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());

                            tvCases.setText(jsonObject.getString("cases"));
                            tvRecovered.setText(jsonObject.getString("recovered"));
                            tvCritical.setText(jsonObject.getString("critical"));
                            tvActive.setText(jsonObject.getString("active"));
                            tvTodaycases.setText(jsonObject.getString("todayCases"));
                            tvTodaydeaths.setText(jsonObject.getString("todayDeaths"));
                            tvDeaths.setText(jsonObject.getString("deaths"));
                            tvAffectedCountries.setText(jsonObject.getString("affectedCountries"));

                            pieChart.addPieSlice(new PieModel("Cases",Integer.parseInt(tvCases.getText().toString()), Color.parseColor("#FFA726")));
                            pieChart.addPieSlice(new PieModel("tvRecovered",Integer.parseInt(tvCases.getText().toString()), Color.parseColor("#66BB6A")));
                            pieChart.addPieSlice(new PieModel("tvDeaths",Integer.parseInt(tvCases.getText().toString()), Color.parseColor("#EF5350")));
                            pieChart.addPieSlice(new PieModel("tvActive",Integer.parseInt(tvCases.getText().toString()), Color.parseColor("#29B6F6")));

                            pieChart.startAnimation();

                            simpleArcLoader.stop();
                            simpleArcLoader.setVisibility(View.GONE);
                            scrollView.setVisibility(View.VISIBLE);



                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }
    public void goTrackCountries(View view){
            startActivity(new Intent(getApplicationContext(),AffectedCountries.class));
    }
}
