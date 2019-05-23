/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.shop.repozitoris;
import com.project.shop.models.product;
import java.util.List;


import org.springframework.data.repository.PagingAndSortingRepository;
/**
 *
 * @author admin
 */
public interface productepozitory extends PagingAndSortingRepository<product, Long> {
    // List<Product> findAll(Pageable pageable);
    //public void delete(long productid);


    
}
