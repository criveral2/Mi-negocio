package com.unexus.invoice.controller;

import com.unexus.invoice.entities.Branch;
import com.unexus.invoice.entities.Customer;
import com.unexus.invoice.repository.BranchRepository;
import com.unexus.invoice.repository.CustomerRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author geova
 */
@SpringBootTest
public class CustomerRestControllerTest {
    
//    @Autowired 
//    CustomerRepository customerRepositoryMock = Mockito.mock(CustomerRepository.class);
//    
//    @Autowired
//    BranchRepository branchRepositoryMock = Mockito.mock(BranchRepository.class);
//    
//    @Autowired
//    CustomerRestController customerRestController = new CustomerRestController(customerRepositoryMock, branchRepositoryMock);
//    
//
//    
    @BeforeEach
    void setUp(){
//        Branch branch = new Branch();
//        branch.setId(2L);
//        branch.setBranchType("MATRIZ");
//        branch.setProvince("AZUAY");
//        branch.setCity("CUENCA");
//        branch.setAddress("Av. Americas");
//        Customer customer = new Customer();
//        branch.setCustomer(customer);
//        customer.setId(1L);
//        customer.setIdentificationType("CEDULA");
//        customer.setIdentificationNumber("0107145633");
//        customer.setCompleteNames("CHRISTIAN GEOVANNY RIVERA LOJA");
//        customer.setEmail("geovannyr106@gmail.com");
//        customer.setPhone("0991748263");
//        customer.getBranches().forEach(x -> x.setCustomer(customer));
//
//        Mockito.when(customerRepositoryMock.findByCode("0107145633")).thenReturn(customer);
    }
    
    @Test
    void contextLoads() {
//        
//        Customer findCustomer;
//        findCustomer = customerRestController.getByNameOrId("0107145633");
//        System.out.println(findCustomer);
//   
    }
    
        
}
