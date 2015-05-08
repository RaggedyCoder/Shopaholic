package com.bytecode.shopaholic.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bytecode.shopaholic.R;
import com.bytecode.shopaholic.application.AppController;
import com.bytecode.shopaholic.items.SignUp;
import com.bytecode.shopaholic.items.receive.SignUpInfo;
import com.bytecode.shopaholic.toolbox.ObjectRequest;
import com.bytecode.shopaholic.utils.Constant;
import com.bytecode.shopaholic.view.widget.CustomButton;
import com.bytecode.shopaholic.view.widget.CustomEditText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by tuman on 8/5/2015.
 */
public class SignUpFragment extends Fragment implements View.OnClickListener, Response.Listener<SignUpInfo>, Response.ErrorListener {

    private View rootView;
    private CustomEditText username;
    private CustomEditText email;
    private CustomEditText password;
    private CustomEditText confirmPassword;
    private CustomButton signUpButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_sign_up, container, false);
        username = (CustomEditText) rootView.findViewById(R.id.username);
        email = (CustomEditText) rootView.findViewById(R.id.email);
        password = (CustomEditText) rootView.findViewById(R.id.password);
        confirmPassword = (CustomEditText) rootView.findViewById(R.id.confirm_password);
        signUpButton = (CustomButton) rootView.findViewById(R.id.sign_up_button);
        return super.onCreateView(inflater, container, savedInstanceState);
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
    public void onErrorResponse(VolleyError volleyError) {

    }

    @Override
    public void onResponse(SignUpInfo signUpInfo) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_up_button:
                SignUp signUp = new SignUp();
                signUp.setUsername(username.getText().toString());
                signUp.setPassword(password.getText().toString());
                signUp.setEmail(email.getText().toString());
                Gson gson = new GsonBuilder().create();
                String json = gson.toJson(signUp);
                byte[] body = json.getBytes();
                ObjectRequest<SignUpInfo> objectRequest = new ObjectRequest<>(Request.Method.POST, Constant.signUpUrl, Constant.headers, null, body, this, this, SignUpInfo.class);
                AppController.getInstance().addToRequestQueue(objectRequest);
                break;
        }
    }
}
