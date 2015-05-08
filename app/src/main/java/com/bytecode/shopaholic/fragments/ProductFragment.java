package com.bytecode.shopaholic.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytecode.shopaholic.R;
import com.bytecode.shopaholic.activities.ProductDetailsActivity;
import com.bytecode.shopaholic.adapters.ProductListAdapter;
import com.bytecode.shopaholic.application.AppController;
import com.bytecode.shopaholic.items.receive.ProductClusterInfo;
import com.bytecode.shopaholic.items.receive.ProductInfo;
import com.bytecode.shopaholic.toolbox.ObjectRequest;
import com.bytecode.shopaholic.utils.Constant;

import java.util.List;


public class ProductFragment extends Fragment {

    private View rootView;
    private ListView listView;
    private int count = 0;
    ProductListAdapter productListAdapter;
    List<ProductInfo> productInfoList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_product, container, false);
        listView = (ListView) rootView.findViewById(R.id.product_list);
        String url = Constant.productUrl + "skip=" + count + "&limit=10";
        ObjectRequest<ProductClusterInfo> objectRequest = new ObjectRequest<ProductClusterInfo>(Request.Method.GET, url, Constant.headers, null, null, new Response.Listener<ProductClusterInfo>() {
            @Override
            public void onResponse(ProductClusterInfo productClusterInfo) {
                if (productListAdapter == null) {
                    productListAdapter = new ProductListAdapter(getActivity(), productClusterInfo.getResults());
                    listView.setAdapter(productListAdapter);
                    productInfoList = productClusterInfo.getResults();
                } else {
                    productListAdapter.addMore(productClusterInfo.getResults());
                    productInfoList = productListAdapter.getProductInfos();
                }

                Toast.makeText(getActivity(), productClusterInfo.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }, ProductClusterInfo.class);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
                intent.putExtra("product", productInfoList.get(position));
                startActivity(intent);
            }
        });
        AppController.getInstance().addToRequestQueue(objectRequest);
        return rootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
}
