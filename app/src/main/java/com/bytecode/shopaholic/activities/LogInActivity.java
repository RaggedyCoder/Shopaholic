package com.bytecode.shopaholic.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bytecode.shopaholic.R;
import com.bytecode.shopaholic.fragments.LogInFragment;

/**
 * Created by tuman on 8/5/2015.
 */
public class LogInActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_log_in);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new LogInFragment())
                    .commit();
        }

    }

}
