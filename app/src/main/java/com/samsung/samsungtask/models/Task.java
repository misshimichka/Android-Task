package com.samsung.samsungtask.models;

import java.util.Date;

public class Task {
    public String personName;
    public String name;
    public String date;
    public String info;
    public String importance;

    public Task(String personName, String name, long creationTimestamp) {
        // do not remove
    }

    public Task() {}

    public Task(String personName, String name, String info, String importance, String time) {
        this.name = name;
        this.personName = personName;
        this.date = time;
        this.info = info;
        this.importance = importance;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", personName='" + personName + '\'' +
                ", creationDate=" + date +
                ", description=" + info +
                ", importance=" + importance +
                '}';
    }
}
