package com.cyk.bookinfo.entity;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private double price;
    private int tid;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pubDate;
    private String descri;
    private String photo;
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", tid=" + tid +
                ", pubDate=" + pubDate +
                ", descri='" + descri + '\'' +
                ", photo='" + photo + '\'' +
                ", type=" + type +
                '}';
    }
}
