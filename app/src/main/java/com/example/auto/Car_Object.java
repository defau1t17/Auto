package com.example.auto;

public class Car_Object {

    public String name;
    public int image;
    public String info;

    public Car_Object(String name, int image, String info) {
        this.name = name;
        this.image = image;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getInfo() {
        return info;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
