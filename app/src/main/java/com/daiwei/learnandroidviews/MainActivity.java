package com.daiwei.learnandroidviews;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.daiwei.learnandroidviews.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Find activity content view
    // ViewGroup rootView = findViewById(android.R.id.content);

    // Option 1: inflate view with XML layout
    // @SuppressLint("InflateParams") View view = getLayoutInflater().inflate(R.layout.activity_main, null);

    // Option 2: inflate with auto gen view binding class
    ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
    View view = binding.getRoot();

    // Set (display) content
    setContentView(view);

    // Use view binding class
    binding.displayWords.setText("Daiwei");
  }
}
