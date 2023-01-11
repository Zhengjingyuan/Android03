package com.example.demo;

import java.io.Serializable;

public class Up implements Serializable {
    private  String name;
    private  int avatar;
    private  int background;
    private  String fans;
    private String intro;

    public Up(String name, int avatar, int background, String fans, String intro) {
        this.name = name;
        this.avatar = avatar;
        this.background = background;
        this.fans = fans;
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public int getAvatar() {
        return avatar;
    }

    public int getBackground() {
        return background;
    }

    public String getFans() {
        return fans;
    }

    public String getIntro() {
        return intro;
    }
}
