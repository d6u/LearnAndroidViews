package com.daiwei.learnandroidviews;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.daiwei.learnandroidviews.databinding.ActivityMainBinding;
import com.daiwei.learnandroidviews.databinding.DataBindingActivityMainBinding;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setView5();
  }

  // Option 1: inflate normal view with XML layout
  private void setView1() {
    ViewGroup rootView = findViewById(android.R.id.content);
    getLayoutInflater().inflate(R.layout.activity_main, rootView);
  }

  // Option 2: inflate normal view with XML layout, can use setContentView() instead of passing root
  private void setView2() {
    View view = getLayoutInflater().inflate(R.layout.activity_main, null);
    setContentView(view);
  }

  // Option 3: use view binding
  private void setView3() {
    ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
    View view = binding.getRoot();
    setContentView(view);
  }

  // Option 4: use data binding + DataBindingUtil
  private void setView4() {
    DataBindingActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.data_binding_activity_main);
    User user = new User("Daiwei", "Lu");
    binding.setUser(user);
  }

  // Option 5: use data binding + inflate + setContentView
  private void setView5() {
    DataBindingActivityMainBinding binding = DataBindingActivityMainBinding.inflate(getLayoutInflater());
    User user = new User("Daiwei", "Lu");
    binding.setUser(user);
    setContentView(binding.getRoot());
  }

  // Option 6: use data binding + inflate
  private void setView6() {
    ViewGroup rootView = findViewById(android.R.id.content);
    DataBindingActivityMainBinding binding = DataBindingActivityMainBinding.inflate(getLayoutInflater(), rootView, true);
    User user = new User("Daiwei", "Lu");
    binding.setUser(user);
  }
}
