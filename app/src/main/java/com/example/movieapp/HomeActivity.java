package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    private List<Slide> latestSlide;
    private ViewPager sliderPager;
    private TabLayout indicator;
    private RecyclerView movieRecycler;
    private SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sliderPager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        movieRecycler = findViewById(R.id.rvMovie);
        swipeRefresh = findViewById(R.id.swipeRefresh);

        //swipe method



        latestSlide = new ArrayList<>();
        latestSlide.add(new Slide(R.drawable.slide1,"Movie title /more text here"));
        latestSlide.add(new Slide(R.drawable.slide2,"Movie title /more text here"));
        latestSlide.add(new Slide(R.drawable.slide1,"Movie title /more text here"));
        latestSlide.add(new Slide(R.drawable.slide2,"Movie title /more text here"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this,latestSlide);
        sliderPager.setAdapter(adapter);

        //set timer to indictor
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new HomeActivity.slideTimer(),4000,6000);
        indicator.setupWithViewPager(sliderPager,true);

        List<Movie> latestMovie = new ArrayList<>();
        latestMovie.add(new Movie("Logan",R.drawable.logan));
        latestMovie.add(new Movie("Avatar",R.drawable.avatar));
        latestMovie.add(new Movie("Dora",R.drawable.dora));
        latestMovie.add(new Movie("Blade",R.drawable.blade));
        latestMovie.add(new Movie("Logan",R.drawable.logan));
        latestMovie.add(new Movie("Avatar",R.drawable.avatar));
        latestMovie.add(new Movie("Dora",R.drawable.dora));
        latestMovie.add(new Movie("Blade",R.drawable.blade));

        MovieAdapter movieAdapter = new MovieAdapter(this,latestMovie);
        movieRecycler.setAdapter(movieAdapter);
        movieRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                latestMovie.add(new Movie("New1",R.drawable.slide1));
                latestMovie.add(new Movie("New 2",R.drawable.slide2));

                movieAdapter.notifyDataSetChanged();
                swipeRefresh.setRefreshing(false);
            }
        });

    }
    //method for changing indicator automatically
    class slideTimer extends TimerTask {
        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(sliderPager.getCurrentItem()<latestSlide.size()-1){
                        sliderPager.setCurrentItem(sliderPager.getCurrentItem()+1);
                    }else {
                        sliderPager.setCurrentItem(0);
                    }

                }
            });

        }
    }
}
