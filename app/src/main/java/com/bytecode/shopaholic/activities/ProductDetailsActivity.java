package com.bytecode.shopaholic.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bytecode.shopaholic.R;
import com.bytecode.shopaholic.fragments.ProductDetailsFragment;
import com.bytecode.shopaholic.items.receive.ProductInfo;

/**
 * Created by tuman on 8/5/2015.
 */
public class ProductDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_product_details);
        if (savedInstanceState == null) {
            ProductInfo clusterPagerItem = getIntent().getExtras().getParcelable("product");
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, ProductDetailsFragment.newInstance(clusterPagerItem))
                    .commit();
        }
    }
}
