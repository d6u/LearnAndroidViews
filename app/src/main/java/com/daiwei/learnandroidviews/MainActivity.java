package com.daiwei.learnandroidviews;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Find activity content view
    // ViewGroup rootView = findViewById(android.R.id.content);

    @SuppressLint("InflateParams") View view = getLayoutInflater().inflate(R.layout.activity_main, null);

    setContentView(view);
  }
}
