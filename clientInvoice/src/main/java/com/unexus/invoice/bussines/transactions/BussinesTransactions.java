/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unexus.invoice.bussines.transactions;

import com.unexus.invoice.entities.Branch;
import com.unexus.invoice.entities.Customer;
import com.unexus.invoice.exception.BussinesTransactionResponse;
import com.unexus.invoice.repository.BranchRepository;
import com.unexus.invoice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author geova
 */
@Service
public class BussinesTransactions {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BranchRepository branchRepository;

    public Customer createCustomer(Customer customer) throws BussinesTransactionResponse {
        if (customer.getBranches().get(0).getBranchType().equals("MATRIZ") == false) {
            BussinesTransactionResponse exception = new 
                BussinesTransactionResponse("46276", "El campo branchType "
                                   + "acepta solo el tipo de sucursal: MATRIZ",
                                   HttpStatus.PRECONDITION_FAILED);
            throw exception;
        }
        customer.getBranches().get(0).setCustomer(customer);
        Customer save = customerRepository.save(customer);
        return save;
    }

    public Customer putCustomer(long id, Customer input) {
        Customer find = customerRepository.findById(id);
        if (find != null) {
            find.setIdentificationType(input.getIdentificationType());
            find.setIdentificationNumber(input.getIdentificationNumber());
            find.setCompleteNames(input.getCompleteNames());
            find.setEmail(input.getEmail());
            find.setPhone(input.getPhone());
        }
        Customer save = customerRepository.save(find);
        return save;
    }

    public Branch createBranch(Branch branch, Customer customerFind) throws BussinesTransactionResponse {
        if (branch.getBranchType().equals("SUCURSAL") == false) {
            BussinesTransactionResponse exception = new 
                BussinesTransactionResponse("46276", "El campo branchType acepta "
                                     + "solo el tipo de sucursal: SUCURSAL", 
                                     HttpStatus.PRECONDITION_FAILED);
            throw exception;
        }
        branch.setCustomer(customerFind);
        Branch save = branchRepository.save(branch);
        return save;
    }

}
