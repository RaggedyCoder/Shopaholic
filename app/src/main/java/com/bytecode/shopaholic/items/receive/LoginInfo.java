package com.bytecode.shopaholic.items.receive;

/**
 * Created by ultimate on 5/8/2015.
 */
public class LoginInfo {
    private String code;
    private String error;
    private String createdAt;
    private String email;
    private String emailVerified;
    private String sessionToken;
    private String updatedAt;
    private String username;

    public LoginInfo(String code, String error, String createdAt, String email, String emailVerified, String sessionToken, String updatedAt, String username) {
        this.code = code;
        this.error = error;
        this.createdAt = createdAt;
        this.email = email;
        this.emailVerified = emailVerified;
        this.sessionToken = sessionToken;
        this.updatedAt = updatedAt;
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(String emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "code='" + code + '\'' +
                ", error='" + error + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", email='" + email + '\'' +
                ", emailVerified='" + emailVerified + '\'' +
                ", sessionToken='" + sessionToken + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
