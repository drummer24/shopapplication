/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.shop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity

@Table(name="orders")
public class order {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private int orderstate;
    
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private user user;
    
    private double price;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orders_products",
    joinColumns = { @JoinColumn(name = "order_id") },
    inverseJoinColumns = { @JoinColumn(name = "product_id") })
    private List<product> products;

    public order() {
        super();
    }

    
    public order(long id, int orderstate, user user, double price, List<product> products) {
        super();
        this.id = id;
        this.orderstate = orderstate;
        this.user = user;
        this.price = price;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(int orderstate) {
        this.orderstate = orderstate;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<product> getProducts() {
        return products;
    }

    public void setProducts(List<product> products) {
        this.products = products;
    }
     
}
