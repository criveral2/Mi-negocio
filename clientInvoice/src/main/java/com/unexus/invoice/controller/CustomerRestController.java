/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unexus.invoice.controller;

import com.unexus.invoice.bussines.transactions.BussinesTransactions;
import com.unexus.invoice.entities.Branch;
import com.unexus.invoice.entities.Customer;
import com.unexus.invoice.exception.BussinesTransactionResponse;
import com.unexus.invoice.repository.BranchRepository;
import com.unexus.invoice.repository.CustomerRepository;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author geova
 */
@RestController
@RequestMapping("/customer")
public class CustomerRestController {
    
    @Autowired 
    CustomerRepository customerRepository;
    
    @Autowired
    BranchRepository branchRepository;
    
    @Autowired
    BussinesTransactions bussinesTransaction;

    
    //Primer requerimiento
    @GetMapping("/find")
    public Customer getByNameOrId(@RequestParam String identification) {
        Customer customer = customerRepository.findByCode(identification);
        return customer;
    }
    
    //Segundo requerimiento
    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody Customer input) throws BussinesTransactionResponse {
        Customer save = bussinesTransaction.createCustomer(input);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
    
    //Tercer requerimiento
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable long id,@Valid @RequestBody Customer input) {
       Customer save = bussinesTransaction.putCustomer(id, input);
       return ResponseEntity.ok(save);
    }
    
  
    //Cuarto requerimiento
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Customer> findCustomer = customerRepository.findById(id);
        if(findCustomer.get() != null){
            HashMap<String, String> response = new HashMap<>();
            response.put("message : ", "Se elimino con exito!!!!");
            response.put("status : ", "200");
            customerRepository.delete(findCustomer.get());
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        return ResponseEntity.ok().build();  
    }
    
    //Quinto requerimiento
    @PostMapping("/branch/{id}")
    public ResponseEntity<?> createBranch(@PathVariable long id,@Valid @RequestBody Branch input) throws BussinesTransactionResponse{
        Customer find = customerRepository.findById(id);
        if(find != null){
            HashMap<String, String> response = new HashMap<>();
            response.put("message : ", "Se creo con exito!!!!");
            response.put("status : ", "201");
            Branch save = bussinesTransaction.createBranch(input, find);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        return ResponseEntity.ok().build();  
    }
    
    //Sexto requerimiento
    @GetMapping("/branch/{id}")
    public ResponseEntity<List<Branch>> getBranches(@PathVariable long id) {
        Customer find = customerRepository.findById(id);
        if(find.getBranches() == null || find.getBranches().isEmpty() ){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(find.getBranches());
        }
    }
    

    
}
