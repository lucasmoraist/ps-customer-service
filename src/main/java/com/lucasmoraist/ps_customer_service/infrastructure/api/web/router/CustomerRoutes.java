package com.lucasmoraist.ps_customer_service.infrastructure.api.web.router;

import com.lucasmoraist.ps_customer_service.domain.model.Customer;
import com.lucasmoraist.ps_customer_service.infrastructure.api.web.request.CustomerRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/v1/customer")
public interface CustomerRoutes {

    @PostMapping("/register")
    ResponseEntity<Void> registerCustomer(@RequestBody @Valid CustomerRequest request);

    @GetMapping
    ResponseEntity<String> getCustomerByEmail(@RequestHeader("X-Customer-Email") String email);

    @GetMapping("/list")
    ResponseEntity<List<Customer>> listCustomers();

}
