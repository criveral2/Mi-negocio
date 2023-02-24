/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unexus.invoice.repository;

import com.unexus.invoice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author geova
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    @Query("SELECT c FROM Customer c WHERE c.identificationNumber = ?1 OR UPPER(c.completeNames) = UPPER(?1)")
    public Customer findByCode(String code);
    
    @Query("SELECT c FROM Customer c WHERE c.id = ?1")
    public Customer findById(long id);
    
    
}
