/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unexus.invoice.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author geova
 */
@Entity
@Data
public class Customer {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String identificationType;
    
    @NotNull(message = "La identificacion no puede ser nula")
    @NotBlank(message = "La identificacion no puede estar vacia")
    @Column(unique = true)
    private String identificationNumber;
    
    @NotNull(message = "Este campo no puede ser nulo")
    @NotBlank(message = "Este campo no puede estar vacio")
    private String completeNames;
    
    @Email
    private String email;
    private String phone;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Branch> branches;

    
    
    
    
    
}
