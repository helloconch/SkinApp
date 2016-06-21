package com.skin.main;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by cheyanxu on 16/6/21.
 */
public class App extends Application {

    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
}
