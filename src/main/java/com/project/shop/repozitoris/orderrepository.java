/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.shop.repozitoris;

import com.project.shop.models.order;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author admin
 */
public interface orderrepository extends PagingAndSortingRepository<order, Long> {
    
}
