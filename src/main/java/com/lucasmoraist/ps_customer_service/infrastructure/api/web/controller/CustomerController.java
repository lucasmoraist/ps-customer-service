package com.lucasmoraist.ps_customer_service.infrastructure.api.web.controller;

import com.lucasmoraist.ps_customer_service.application.dto.CustomerDTO;
import com.lucasmoraist.ps_customer_service.application.mapper.CustomerMapper;
import com.lucasmoraist.ps_customer_service.application.usecases.customer.CreateCustomerCase;
import com.lucasmoraist.ps_customer_service.application.usecases.customer.FindByCustEmailCase;
import com.lucasmoraist.ps_customer_service.application.usecases.customer.ListCustomersCase;
import com.lucasmoraist.ps_customer_service.domain.model.Customer;
import com.lucasmoraist.ps_customer_service.infrastructure.api.web.request.CustomerRequest;
import com.lucasmoraist.ps_customer_service.infrastructure.api.web.router.CustomerRoutes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomerRoutes {

    private final CreateCustomerCase createCustomerCase;
    private final ListCustomersCase listCustomersCase;
    private final FindByCustEmailCase findByCustEmailCase;

    @Override
    public ResponseEntity<Void> registerCustomer(CustomerRequest request) {
        CustomerDTO dto = CustomerMapper.toDto(request);
        this.createCustomerCase.execute(dto);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<String> getCustomerByEmail(String email) {
        Customer customer = this.findByCustEmailCase.execute(email);
        return ResponseEntity.ok(customer.password());
    }

    @Override
    public ResponseEntity<List<Customer>> listCustomers() {
        List<Customer> customers = this.listCustomersCase.execute();
        return ResponseEntity.ok(customers);
    }

}
