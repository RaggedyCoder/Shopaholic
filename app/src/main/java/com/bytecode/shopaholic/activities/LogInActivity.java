package com.bytecode.shopaholic.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bytecode.shopaholic.R;
import com.bytecode.shopaholic.appdata.AppManager;
import com.bytecode.shopaholic.fragments.LogInFragment;

/**
 * Created by tuman on 8/5/2015.
 */
public class LogInActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        AppManager appManager = new AppManager(this);
        if (!appManager.getSessionToken().equals("")) {
            Intent intent = new Intent(this, ProductActivity.class);
            finish();
            startActivity(intent);
        }
        setContentView(R.layout.activity_log_in);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new LogInFragment())
                    .commit();
        }
    }
}
