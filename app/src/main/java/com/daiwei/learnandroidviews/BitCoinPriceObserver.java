package com.daiwei.learnandroidviews;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import java.util.Timer;
import java.util.TimerTask;

final class BitCoinPriceObserver implements LifecycleObserver {

  private static final String TAG = BitCoinPriceObserver.class.getSimpleName();
  private final Lifecycle mLifecycle;
  private Timer mTimer;

  BitCoinPriceObserver(Lifecycle lifecycle) {
    mLifecycle = lifecycle;
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void onResume() {
    Log.d(TAG, "onResume");

    if (mLifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
      mTimer = new Timer();
      TimerTask timerTask =
          new TimerTask() {
            @Override
            public void run() {
              Log.d(TAG, "something something");
            }
          };
      mTimer.scheduleAtFixedRate(timerTask, 0, 2000);
    }
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onPause() {
    Log.d(TAG, "onPause");
    mTimer.cancel();
  }
}
