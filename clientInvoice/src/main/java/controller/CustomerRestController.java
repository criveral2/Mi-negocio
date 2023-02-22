/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.unexus.invoice.entities.Customer;
import com.unexus.invoice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author geova
 */
@RestController
@RequestMapping("/customer")
public class CustomerRestController {
    
    @Autowired 
    CustomerRepository customerRepository;
    
    //Primer requerimiento
    @GetMapping()
    public ResponseEntity< List<Customer> > list() {
        List<Customer> customers =  customerRepository.findAll();
        if(customers == null || customers.isEmpty() ){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(customers);
        }
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        return null;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
       
        return null;
    }
    
    
    //Segundo requerimiento
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Customer input) {
        Customer save = customerRepository.save(input);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    
}
