package com.daiwei.learnandroidviews;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.daiwei.learnandroidviews.databinding.ActivityMainBinding;
import com.daiwei.learnandroidviews.databinding.DataBindingActivityMainBinding;
import com.daiwei.learnandroidviews.databinding.DataBindingViewModelBinding;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setUpViewModel();
  }

  // --- All sorts of data related architecture ---

  // custom lifecycle observer (it's observing lifecycle, not data)
  private void addObserver() {
    getLifecycle().addObserver(new BitCoinPriceObserver(getLifecycle()));
  }

  // ViewModel + LiveData
  private void setUpViewModel() {
    final DataBindingViewModelBinding binding =
        DataBindingViewModelBinding.inflate(
            getLayoutInflater(), (ViewGroup) findViewById(android.R.id.content), true);

    BitCoinPriceViewModel viewModel = new ViewModelProvider(this).get(BitCoinPriceViewModel.class);

    viewModel
        .getCurrentPrice()
        .observe(
            this,
            new Observer<Integer>() {
              @Override
              public void onChanged(Integer integer) {
                binding.setPrice(integer);
              }
            });
  }

  // --- All sorts of view related architecture ---

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
    DataBindingActivityMainBinding binding =
        DataBindingUtil.setContentView(this, R.layout.data_binding_activity_main);
    User user = new User("Daiwei", "Lu");
    binding.setUser(user);
  }

  // Option 5: use data binding + inflate + setContentView
  private void setView5() {
    DataBindingActivityMainBinding binding =
        DataBindingActivityMainBinding.inflate(getLayoutInflater());
    User user = new User("Daiwei", "Lu");
    binding.setUser(user);
    setContentView(binding.getRoot());
  }

  // Option 6: use data binding + inflate
  private void setView6() {
    ViewGroup rootView = findViewById(android.R.id.content);
    DataBindingActivityMainBinding binding =
        DataBindingActivityMainBinding.inflate(getLayoutInflater(), rootView, true);
    User user = new User("Daiwei", "Lu");
    binding.setUser(user);
  }
}
