package com.greetingapp.model;

public class Greeting {

    String greetings;
    long count;

    public Greeting(long count, String greetings) {
        this.count = count;
        this.greetings = greetings;
    }

    public String getGreetings() {
        return greetings;
    }

    public long getCount() {
        return count;
    }
}
