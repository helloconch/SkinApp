package com.skin.main;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.widget.Button;

import com.skin.lib.SkinAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends SkinAppCompatActivity {

    @BindView(R.id.changeTheme)
    Button changeTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     * 改变样式
     */
    @OnClick(R.id.changeTheme)
    public void onClick() {
        int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        switch (currentNightMode) {
            case Configuration.UI_MODE_NIGHT_NO:
                // Night mode is not active, we're in day time
                setDayNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                // Night mode is active, we're at night!
                setDayNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
            case Configuration.UI_MODE_NIGHT_UNDEFINED:
                // We don't know what mode we're in, assume notnight
                break;
        }
    }
}
