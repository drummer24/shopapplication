/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.shop.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author admin
 */
@Entity

@Table(name="products")
public class product {

   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    
    private String description;
    
    private double price;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<image> gallery;
    
    @ManyToMany(mappedBy = "products")
    private List<order> orders;

    public product(long id, String name, String description, double price, List<image> gallery) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.gallery = gallery;
    }

    

    public product() {
        super();
    }

   
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  
   public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
  
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<image> getGallery() {
        return gallery;
    }

    public void setGallery(List<image> gallery) {
        this.gallery = gallery;
    }

    public List<order> getOrders() {
        return orders;
    }

    public void setOrders(List<order> orders) {
        this.orders = orders;
    }
   
}
