/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unexus.invoice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;
import lombok.Data;

/**
 *
 * @author geova
 */
@Entity
@Data
public class Branch {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Pattern(regexp = "[MATRIZ}",message = "El campo acepta solo el tipo de sucursal: MATRIZ o SUCURSAL")
    private String branchType;
    private String province;
    private String city;
    private String address;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
    private Customer customer;
    
}
