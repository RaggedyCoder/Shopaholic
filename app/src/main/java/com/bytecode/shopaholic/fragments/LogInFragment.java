package com.bytecode.shopaholic.fragments;

import android.app.Dialog;
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
import com.bytecode.shopaholic.activities.ProductActivity;
import com.bytecode.shopaholic.activities.SignUpActivity;
import com.bytecode.shopaholic.appdata.AppManager;
import com.bytecode.shopaholic.application.AppController;
import com.bytecode.shopaholic.items.Login;
import com.bytecode.shopaholic.items.ResetPassword;
import com.bytecode.shopaholic.items.receive.LoginInfo;
import com.bytecode.shopaholic.items.receive.ResetPasswordInfo;
import com.bytecode.shopaholic.toolbox.ObjectRequest;
import com.bytecode.shopaholic.utils.Constant;
import com.bytecode.shopaholic.view.widget.CustomButton;
import com.bytecode.shopaholic.view.widget.CustomEditText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

                final Login login = new Login(username_s, password_s);

                HashMap<String, String> params = new HashMap<String, String>();
                params.put("username", username_s);
                params.put("password", password_s);

                String url = Constant.url_login + "username=" + username_s + "&password=" + password_s;

                ObjectRequest<LoginInfo> objectrequest = new ObjectRequest<>(Request.Method.GET, url, Constant.headers, null, null, new Response.Listener<LoginInfo>() {
                    @Override
                    public void onResponse(LoginInfo loginInfo) {
                        if (loginInfo.getCode() != null || loginInfo.getCode() != "null") {
                            AppManager appManager = new AppManager(getActivity());
                            appManager.setSessionId(loginInfo.getSessionToken());
                            Toast.makeText(getActivity(), loginInfo.toString(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), ProductActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getActivity(), "Invalid username or password", Toast.LENGTH_LONG).show();
                        }




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

                // custom dialog
                final Dialog dialog = new Dialog(this.getActivity());
                dialog.setContentView(R.layout.custom_dialog);
                dialog.setTitle("Please Enter Email");

                // set the custom dialog components - text, image and button
                final CustomEditText email = (CustomEditText) dialog.findViewById(R.id.reset_email_editText);

                CustomButton confirmButton = (CustomButton) dialog.findViewById(R.id.submit_button);

                CustomButton cancelButton = (CustomButton) dialog.findViewById(R.id.cancel_button);





                // if button is clicked, close the custom dialog
                confirmButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       // dialog.dismiss();
                        String email_s=email.getText().toString();

                        ResetPassword resetpassword = new ResetPassword(email_s);
                      //  signUp.setUsernamrText().toString());
                       // signUp.setPassword(password.getText().toString());
                       // signUp.setEmail(email.getText().toString());
                        Gson gson = new GsonBuilder().create();
                        String json = gson.toJson(resetpassword);
                        byte[] body = json.getBytes() ;

                        ObjectRequest<ResetPasswordInfo> objectRequest_reset = new ObjectRequest<>(Request.Method.POST, Constant.resetUrl, Constant.headers, null, body, new Response.Listener<ResetPasswordInfo>() {
                            @Override
                            public void onResponse(ResetPasswordInfo resetinfo) {
                                Toast.makeText(getActivity(), resetinfo.toString(), Toast.LENGTH_SHORT).show();


                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                            }
                        }, ResetPasswordInfo.class);
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
