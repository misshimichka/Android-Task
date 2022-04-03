package com.samsung.samsungtask.models;

import java.util.Date;

public class User {
    public String name;
    public String email;
    public Date creationDate;
    public String description;

    public User(String s, String email, long creationTimestamp) {
        // do not remove
    }

    public User(String name, String email, long creationDate, String description) {
        this.name = name;
        this.email = email;
        this.creationDate = new Date(creationDate);
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", creationDate=" + creationDate +
                ", description=" + description +
                '}';
    }
}
