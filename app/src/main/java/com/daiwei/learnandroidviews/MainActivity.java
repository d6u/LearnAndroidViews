package com.daiwei.learnandroidviews;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.daiwei.learnandroidviews.databinding.DataBindingActivityMainBinding;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Find activity content view
    // ViewGroup rootView = findViewById(android.R.id.content);

    // Option 1: inflate view with XML layout
    // @SuppressLint("InflateParams") View view = getLayoutInflater().inflate(R.layout.activity_main, null);

    // Option 2: inflate with auto gen view binding class
    // ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
    // View view = binding.getRoot();

    // Option 3: inflate with auto gen data binding class
    // DataBindingActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.data_binding_activity_main);
    // User user = new User("Daiwei", "Lu");
    // binding.setUser(user);

    DataBindingActivityMainBinding binding = DataBindingActivityMainBinding.inflate(getLayoutInflater());
    View view = binding.getRoot();

    // Set (display) content
    setContentView(view);

    binding.setUser(new User("Daiwei", "Lu"));

    // Use view binding class
    // binding.displayWords.setText("Daiwei");
  }
}
