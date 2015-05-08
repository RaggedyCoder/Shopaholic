package com.bytecode.shopaholic.items;

/**
 * Created by ultimate on 5/8/2015.
 */
public class ResetPassword {

    String email;

    public ResetPassword(String email) {
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
        return "ResetPassword{" +
                "email='" + email + '\'' +
                '}';
    }
}
