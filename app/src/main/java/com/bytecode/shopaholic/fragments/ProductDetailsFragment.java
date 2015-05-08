package com.bytecode.shopaholic.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytecode.shopaholic.R;
import com.bytecode.shopaholic.application.AppController;
import com.bytecode.shopaholic.items.AddToCart;
import com.bytecode.shopaholic.items.Scart;
import com.bytecode.shopaholic.items.receive.AddToCartInfo;
import com.bytecode.shopaholic.items.receive.ProductInfo;
import com.bytecode.shopaholic.items.receive.ResetPasswordInfo;
import com.bytecode.shopaholic.toolbox.ObjectRequest;
import com.bytecode.shopaholic.utils.Constant;
import com.bytecode.shopaholic.view.widget.CustomButton;
import com.bytecode.shopaholic.view.widget.CustomEditText;
import com.bytecode.shopaholic.view.widget.CustomTextView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by tuman on 8/5/2015.
 */
public class ProductDetailsFragment extends Fragment implements View.OnClickListener {

    public static String key = "product_list";
    private View rootView;
    private ImageView product_image;
    private ImageButton favourite_button;
    private CustomTextView product_name, product_price, product_details;
    private ProductInfo product_info = new ProductInfo();

    public static ProductDetailsFragment newInstance(Parcelable parcelable) {
        Bundle bundle = new Bundle();
        ProductDetailsFragment fragment = new ProductDetailsFragment();
        bundle.putParcelable(key, parcelable);
        fragment.setArguments(bundle);

        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            product_info = getArguments().getParcelable(key);

        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_product_details, container, false);
        initialize();
        return rootView;
    }

    public void initialize() {
        product_image = (ImageView) rootView.findViewById(R.id.product_image);

        favourite_button = (ImageButton) rootView.findViewById(R.id.favourite_button);

        product_name = (CustomTextView) rootView.findViewById(R.id.product_name);
        product_name.setText(product_info.getName());

        product_price = (CustomTextView) rootView.findViewById(R.id.product_price);
        product_price.setText(product_info.getPrice());

        product_details = (CustomTextView) rootView.findViewById(R.id.product_details);
        product_details.setText(product_info.getDescription());

        favourite_button.setOnClickListener(this);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.favourite_button:


                final Dialog dialog = new Dialog(this.getActivity());
                dialog.setContentView(R.layout.custom_dialog);
                dialog.setTitle("Please Enter Email");

                // set the custom dialog components - text, image and button
                final CustomEditText numberOfitem = (CustomEditText) dialog.findViewById(R.id.numberOfitem_editText);

                CustomButton confirmButton = (CustomButton) dialog.findViewById(R.id.submit_button);

                CustomButton cancelButton = (CustomButton) dialog.findViewById(R.id.cancel_button);


                // if button is clicked, close the custom dialog
                confirmButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // dialog.dismiss();
                        String number = numberOfitem.getText().toString();

                        Scart abc = new Scart("Pointer", "Cart", "cartId");

                        Scart abc_2 = new Scart("Pointer", "Product", "productId");

                        AddToCart AddToCart = new AddToCart(abc, abc_2, number);
                        //  signUp.setUsernamrText().toString());
                        // signUp.setPassword(password.getText().toString());
                        // signUp.setEmail(email.getText().toString());
                        Gson gson = new GsonBuilder().create();
                        String json = gson.toJson(AddToCart);
                        byte[] body = json.getBytes();

                        ObjectRequest<AddToCartInfo> objectRequest_reset = new ObjectRequest<>(Request.Method.POST, Constant.addUrl, Constant.headers, null, body, new Response.Listener<AddToCartInfo>() {
                            @Override
                            public void onResponse(AddToCartInfo resetinfo) {
                                Toast.makeText(getActivity(), resetinfo.toString(), Toast.LENGTH_SHORT).show();


                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                            }
                        }, AddToCartInfo.class);
                        AppController.getInstance().addToRequestQueue(objectRequest_reset);


                    }
                });
                // if button is clicked, close the custom dialog
                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();

                break;
        }
    }
}
