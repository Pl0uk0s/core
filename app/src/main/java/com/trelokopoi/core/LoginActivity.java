package com.trelokopoi.core;

import android.app.Activity;
import android.os.Bundle;

import com.trelokopoi.core.util.Tools;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Tools.setupGoogleAnalytics(LoginActivity.this);

        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume()
    {
        // TODO Auto-generated method stub
        super.onResume();
    }
}
