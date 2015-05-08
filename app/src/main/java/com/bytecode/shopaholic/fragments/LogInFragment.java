package com.bytecode.shopaholic.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytecode.shopaholic.R;
import com.bytecode.shopaholic.activities.SignUpActivity;
import com.bytecode.shopaholic.application.AppController;
import com.bytecode.shopaholic.items.Login;
import com.bytecode.shopaholic.items.receive.LoginInfo;
import com.bytecode.shopaholic.toolbox.ObjectRequest;
import com.bytecode.shopaholic.utils.Constant;
import com.bytecode.shopaholic.view.widget.CustomButton;
import com.bytecode.shopaholic.view.widget.CustomEditText;

import java.util.HashMap;

public class LogInFragment extends Fragment implements View.OnClickListener {

    private View rootView;
    private CustomButton log_in, create_account, forgot_pass;

    private CustomEditText username, password;


    private String username_s, password_s;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_log_in, container, false);


        initial_ui();


        return rootView;
    }

    private void initial_ui() {
        log_in = (CustomButton) rootView.findViewById(R.id.login_button);
        log_in.setOnClickListener(this);
        create_account = (CustomButton) rootView.findViewById(R.id.create_account_button);
        create_account.setOnClickListener(this);

        forgot_pass = (CustomButton) rootView.findViewById(R.id.forgot_button);
        forgot_pass.setOnClickListener(this);


        username = (CustomEditText) rootView.findViewById(R.id.username_editText);

        password = (CustomEditText) rootView.findViewById(R.id.password_editText);
    }


    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id) {
            case R.id.login_button:

                username_s = username.getText().toString();
                password_s = password.getText().toString();

                Login login = new Login(username_s, password_s);

                HashMap<String, String> params = new HashMap<String, String>();
                params.put("username", username_s);
                params.put("password", password_s);

                String url = Constant.url_login + "username=" + username_s + "&password=" + password_s;

                ObjectRequest<LoginInfo> objectrequest = new ObjectRequest<>(Request.Method.GET, url, Constant.headers, null, null, new Response.Listener<LoginInfo>() {
                    @Override
                    public void onResponse(LoginInfo loginInfo) {
                        Toast.makeText(getActivity(), loginInfo.toString(), Toast.LENGTH_SHORT).show();


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                }, LoginInfo.class);
                AppController.getInstance().addToRequestQueue(objectrequest);

                break;
            case R.id.create_account_button:
                Intent intent = new Intent(getActivity(), SignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.forgot_button:


                break;
        }

    }
}
