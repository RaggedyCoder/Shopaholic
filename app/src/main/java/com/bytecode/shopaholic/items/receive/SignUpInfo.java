package com.bytecode.shopaholic.items.receive;

/**
 * Created by tuman on 8/5/2015.
 */
public class SignUpInfo {
    private String createdAt;
    private String email;
    private String emailVerified;
    private String objectId;
    private String sessionToken;
    private String username;
    private String code;
    private String error;

    public SignUpInfo(String createdAt, String email, String emailVerified, String objectId, String sessionToken, String username, String code, String error) {
        this.createdAt = createdAt;
        this.email = email;
        this.emailVerified = emailVerified;
        this.objectId = objectId;
        this.sessionToken = sessionToken;
        this.username = username;
        this.code = code;
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

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
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

    @Override
    public String toString() {
        return "SignUpInfo{" +
                "createdAt='" + createdAt + '\'' +
                ", email='" + email + '\'' +
                ", emailVerified='" + emailVerified + '\'' +
                ", objectId='" + objectId + '\'' +
                ", sessionToken='" + sessionToken + '\'' +
                ", username='" + username + '\'' +
                ", code='" + code + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
