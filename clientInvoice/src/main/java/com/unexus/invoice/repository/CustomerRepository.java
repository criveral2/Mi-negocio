/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unexus.invoice.repository;

import com.unexus.invoice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author geova
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
