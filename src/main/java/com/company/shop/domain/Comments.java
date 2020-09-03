package com.company.shop.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Comments implements Serializable{

    @DBRef(lazy = true)
    @Field("user")
    private User user;

    @Field("title")
    private String title;

    @Field("body")
    private String body;

    @Field("note")
    private Integer note;

    @Field("date")
    private String date;

    public Comments(){

    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User u) {
        this.user  = u;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Comments(String title, String body, Integer note, String date) {
        this.title = title;
        this.body = body;
        this.note = note;
        this.date = date;
    }
}
