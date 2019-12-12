package ru.smirnov.test.a1c_course_app.models;

import java.util.Date;

public class Note {

    private String id;

    private Date date;

    private String text;

    private String title;

    private int drawableIdRes;

    public Note(String id, Date date, String text, String title, int drawableIdRes) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.title = title;
        this.drawableIdRes = drawableIdRes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDrawableIdRes() {
        return drawableIdRes;
    }

    public void setDrawableIdRes(int drawableIdRes) {
        this.drawableIdRes = drawableIdRes;
    }
}
