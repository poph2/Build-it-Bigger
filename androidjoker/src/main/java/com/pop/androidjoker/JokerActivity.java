package com.pop.androidjoker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class JokerActivity extends AppCompatActivity {

    public static final String JOKE_EXTRA = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joker);
    }
}
