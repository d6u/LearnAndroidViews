package com.daiwei.learnandroidviews;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

public final class BitCoinPriceViewModel extends ViewModel {

  @Nullable private MutableLiveData<Integer> currentPrice;
  @Nullable private Timer mTimer;

  public BitCoinPriceViewModel() {}

  MutableLiveData<Integer> getCurrentPrice() {
    if (currentPrice == null) {
      currentPrice = new MutableLiveData<>();
      currentPrice.setValue(0);

      TimerTask timerTask =
          new TimerTask() {
            @Override
            public void run() {
              if (currentPrice != null) {
                // Use postValue() because we are not on main thread here
                currentPrice.postValue(Optional.ofNullable(currentPrice.getValue()).orElse(0) + 1);
              }
            }
          };

      mTimer = new Timer();
      mTimer.scheduleAtFixedRate(timerTask, 2000, 2000);
    }

    return currentPrice;
  }

  @Override
  protected void onCleared() {
    super.onCleared();

    if (mTimer != null) {
      mTimer.cancel();
    }
  }
}
