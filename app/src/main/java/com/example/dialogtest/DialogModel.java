package com.example.dialogtest;

import java.lang.reflect.Array;

public class DialogModel {

    String name;
    String age;
    String address;

    public DialogModel(String name, String  age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public DialogModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
