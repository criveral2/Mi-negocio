package com.unexus.invoice.controller;


import com.unexus.invoice.bussines.transactions.BussinesTransactions;
import com.unexus.invoice.entities.Branch;
import com.unexus.invoice.entities.Customer;
import com.unexus.invoice.repository.BranchRepository;
import com.unexus.invoice.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author geova
 */
@SpringBootTest
public class CustomerRestControllerTest {
    private MockMvc mockMvc;
    
    @Mock
    CustomerRepository customerRepositoryMock;
    
    @Mock
    BranchRepository branchRepositoryMock;
    
    @Mock
    BussinesTransactions bussinesTransactionMock;
    
    @InjectMocks
    CustomerRestController customerRestControllerMock;
    

    
    @BeforeEach
    public void setUp() throws Exception{
         MockitoAnnotations.openMocks(this);
         this.mockMvc = MockMvcBuilders.standaloneSetup(customerRestControllerMock).build();

    }
    
    @Test
    void customerRestController() throws Exception  {
        List<Branch> miLista = new ArrayList<Branch>();
        Branch branch = new Branch();
        branch.setId(2L);
        branch.setBranchType("MATRIZ");
        branch.setProvince("AZUAY");
        branch.setCity("CUENCA");
        branch.setAddress("Av. Americas");
        miLista.add(branch);
        
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setIdentificationType("CEDULA");
        customer.setIdentificationNumber("0107145633");
        customer.setCompleteNames("CHRISTIAN GEOVANNY RIVERA LOJA");
        customer.setEmail("geovannyr106@gmail.com");
        customer.setPhone("0991748263");
        customer.setBranches(miLista);
        
        //Test requeriment 1
        Mockito.when(customerRepositoryMock.findByCode("0107145633")).thenReturn(customer);
        Customer findCustomer;
        findCustomer = customerRestControllerMock.getByNameOrId("0107145633");
        Assertions.assertEquals("CHRISTIAN GEOVANNY RIVERA LOJA", findCustomer.getCompleteNames());
        Assertions.assertEquals("MATRIZ", findCustomer.getBranches().get(0).getBranchType());
        
        //Test requeriment 2
        Mockito.when(bussinesTransactionMock.createCustomer(customer)).thenReturn(customer);
        ResponseEntity<?> customerCreated;
        customerCreated = customerRestControllerMock.post(customer);
        Assertions.assertEquals(1L, findCustomer.getId());
        
        //Test requeriment 3
        Customer customerUpdated = new Customer();
        customerUpdated.setId(1L);
        customerUpdated.setIdentificationType("CEDULA");
        customerUpdated.setIdentificationNumber("0101010325");
        customerUpdated.setCompleteNames("CHRISTIAN ANDRES RIVERA LOJA");
        customerUpdated.setEmail("andresy45@gmail.com");
        customerUpdated.setPhone("0991748263");
        customerUpdated.setBranches(miLista);
     
        Mockito.when(bussinesTransactionMock.putCustomer(1L, customerUpdated)).thenReturn(customerUpdated);
        ResponseEntity<?> customerUpdate;
        customerUpdate =  customerRestControllerMock.put(1L, customerUpdated);
        Assertions.assertEquals("0101010325", customerUpdated.getIdentificationNumber());
        
        
        //Test requeriment 5
        Branch branchNew = new Branch();
        branchNew.setId(3L);
        branchNew.setBranchType("SUCURSAL");
        branchNew.setProvince("AZUAY");
        branchNew.setCity("CUENCA");
        branchNew.setAddress("Av. Loja");
        miLista.add(branchNew);
        customer.setBranches(miLista);
        
        Mockito.when(customerRepositoryMock.findById(1L)).thenReturn(customer);
        Mockito.when(bussinesTransactionMock.createBranch(branchNew, customer)).thenReturn(branchNew);
        ResponseEntity<?> branchCreated;
        branchCreated=customerRestControllerMock.createBranch(1L, branchNew);
        Assertions.assertEquals(200,branchCreated.getStatusCodeValue());
        
        //Test requeriment 5
        Mockito.when(customerRepositoryMock.findById(1L)).thenReturn(customer);
        ResponseEntity<List<Branch>> findBranches;
        findBranches = customerRestControllerMock.getBranches(1L);
        Assertions.assertEquals("MATRIZ", findBranches.getBody().get(0).getBranchType());
        Assertions.assertEquals("SUCURSAL", findBranches.getBody().get(1).getBranchType());
   
    }
    
   
    
        
}
