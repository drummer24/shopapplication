/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 todo dorobit filter
login usera 
       - endpoint pre vytvorenie objednavky
       - moznost vylistovat si vlastne objednavky

   auth setup:
       - auth implementovana v aplikacii (nie 3rd party provideri)
       - ponechany na autorovi -  plusove body za JWT, OAuth2

   vseobecne poziadavky:
       - validacia requestov (typove aj semanticky) - postaci vracat 4xx kod
       - user data su secure pred inymi pouzivatelmi (napr. iny pouzivatel nemoze vidiet moju  objednavku)
       - aspon jeden unit a integracny test (bonus - vysoky test coverage, e2e testy)
       - nasadene na cloude + za https (nie nutne ak je to na VPS)
       - zdrojove kody na Githube       
       - nasadenie aplikacii na lubovolne prostredie dostupne z Internetu (napr. Heroku)

*/
package com.project.shop.controllers;

/**
 *
 * @author admin
 */
import com.project.shop.models.product;
import com.project.shop.repozitoris.productepozitory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class productcontroller {
    @Autowired
    productepozitory productrepo;
    static List <product> products= new ArrayList<>();
    //static AtomicLong id= new AtomicLong(0);
   
    @CrossOrigin(origins = "http://localhost:5000")
    @GetMapping("/allproducts/{page}")
    public Iterable<product> allproducts(@PathVariable("page") int pagenum) {
        int pageSize = 2;
        
        Pageable pageable = PageRequest.of(pagenum,pageSize);
        Page<product> allproducts = productrepo.findAll(pageable);
        
        return productrepo.findAll(pageable);
    }  
    
    @CrossOrigin(origins = "http://localhost:5000")
    @GetMapping("/allproducts/detail/{id}")
    public Optional<product> productdetail(@PathVariable("id") long productid) {
      return productrepo.findById(productid);
    }
    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long productid) {
     // productrepo.delete(productid);
       return "product deleted saved successfully ::.";
    }
    
    @CrossOrigin
    @PostMapping("/newproduct")
    String newproduct(@RequestBody product newproduct) {
        
        System.out.println(newproduct.getGallery());
        productrepo.save(newproduct);
        return "product information saved successfully ::." + newproduct.getName();
  }
}
