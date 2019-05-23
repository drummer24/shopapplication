/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.shop.repozitoris;
import com.project.shop.models.user;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author admin
 */
public interface userrepozitory extends JpaRepository<user, Long> {


    
}
