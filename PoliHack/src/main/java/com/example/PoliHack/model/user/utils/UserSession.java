package com.example.PoliHack.model.user.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSession {

    private static UserSession instance;

    private String userId;
    private String userNickname;

    private UserSession() {}

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void clearSession() {
        this.userId = null;
        this.userNickname = null;
    }
}
