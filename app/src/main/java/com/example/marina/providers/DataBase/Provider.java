package com.example.marina.providers.DataBase;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Provider {
    @Id
    private Long id;
    private String name;
    private String quality;
    private String delivery;
    private int distance;
    private int price;
    private int term;
    private int assortment;

    @Generated(hash = 639277608)
    public Provider(Long id, String name, String quality, String delivery,
            int distance, int price, int term, int assortment) {
        this.id = id;
        this.name = name;
        this.quality = quality;
        this.delivery = delivery;
        this.distance = distance;
        this.price = price;
        this.term = term;
        this.assortment = assortment;
    }
    @Generated(hash = 2018611927)
    public Provider() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getQuality() {
        return this.quality;
    }
    public void setQuality(String quality) {
        this.quality = quality;
    }
    public String getDelivery() {
        return this.delivery;
    }
    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }
    public int getDistance() {
        return this.distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getTerm() {
        return this.term;
    }
    public void setTerm(int term) {
        this.term = term;
    }
    public int getAssortment() {
        return this.assortment;
    }
    public void setAssortment(int assortment) {
        this.assortment = assortment;
    }
}