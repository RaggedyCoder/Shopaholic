package com.bytecode.shopaholic.appdata;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class AppManager {

    private static final int PRIVATE_MODE = Context.MODE_PRIVATE;
    private static final String PREF_NAME = "ShopaholicPref";
    private static final String KEY_SESSION_ID = "sessionToken";
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor editor;
    private Activity activity;

    public AppManager(Activity activity) {
        this.activity = activity;
        mSharedPreferences = getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = mSharedPreferences.edit();
        editor.apply();
    }

    private SharedPreferences getSharedPreferences(final String prefName, final int mode) {
        return this.activity.getSharedPreferences(prefName, mode);
    }

    public void setSessionId(String sessionToken) {
        editor.putString(KEY_SESSION_ID, sessionToken);
        editor.apply();
    }

    public String getSessionToken() {
        return mSharedPreferences.getString(KEY_SESSION_ID, "");
    }
}