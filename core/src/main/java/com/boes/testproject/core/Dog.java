package com.boes.testproject.core;

public class Dog {

    private static int idCount = 0;

    private int id;
    private String name;
    private boolean likesBacon;

    public Dog(String name, boolean likesBacon) {
        this.name = name;
        this.likesBacon = likesBacon;
        this.id = idCount++;
    }

    public Dog(int id, String name, boolean likesBacon) {
        this.name = name;
        this.likesBacon = likesBacon;
        this.id = id;
    }

    public String sendName() {
        return name;
    }

    public boolean isLikesBacon() {
        return likesBacon;
    }

    public int sendID() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        Dog other = (Dog) o;
        return this.id == other.sendID() &&
               this.name.equals(other.sendName()) &&
               this.likesBacon == other.isLikesBacon();
    }

    @Override
    public String toString() {
        return "Dog " + id + ": " + name + " likes bacon: " + likesBacon;
    }

}
