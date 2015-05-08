package com.bytecode.shopaholic.items.receive;

/**
 * Created by ultimate on 5/8/2015.
 */
public class ResetPasswordInfo {

    String email;

    public ResetPasswordInfo(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ResetPasswordInfo{" +
                "email='" + email + '\'' +
                '}';
    }
}
