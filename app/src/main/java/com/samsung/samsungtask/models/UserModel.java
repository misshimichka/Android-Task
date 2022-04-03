package com.samsung.samsungtask.models;

import java.util.ArrayList;

public class UserModel {
    public String username;
    public String email;
    public String password;
    public String info;
    public int imageURL;

    public UserModel() {
        //do not remove
    }

    public UserModel(String username, String email, String password, String info, int imageURL) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.info = info;
        this.imageURL = imageURL;
    }
}
