package com.example.addprofile;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Post implements Serializable {

    private String date;
    private String name;
    private String body;
    private int following;
    private int followers;
    private int posts;

    public Post(String date, String name, String body, int following, int followers, int posts) {
        this.date = date;
        this.name = name;
        this.body = body;
        this.following = following;
        this.followers = followers;
        this.posts = posts;
    }

    public String getData() {
        return date;
    }

    public void setData(String data) {
        this.date = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }
}
