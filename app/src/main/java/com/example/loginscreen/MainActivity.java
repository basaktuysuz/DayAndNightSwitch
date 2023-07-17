package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

public class MainActivity extends AppCompatActivity {
    ImageView sun, dayLand, nightLand;
    View daysky, nightsky;
    DayNightSwitch dayNightSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sun = findViewById(R.id.sun);
        dayLand = findViewById(R.id.day_landscape);
        nightLand = findViewById(R.id.nigth_landscape);
        daysky = findViewById(R.id.day_bg);
        nightsky = findViewById(R.id.night_bg);
        dayNightSwitch = findViewById(R.id.day_night_switch);

        sun.setTranslationY(-110);

        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean is_night) {
                if (is_night) {
                    sun.animate().translationY(110).setDuration(1000);
                    dayLand.animate().alpha(0).setDuration(1300);
                    daysky.animate().alpha(0).setDuration(1300);
                } else {
                    sun.animate().translationY(110).setDuration(1000);
                    dayLand.animate().alpha(1).setDuration(1300);
                    daysky.animate().alpha(1).setDuration(1300);
                }
            }
        });


    }
}