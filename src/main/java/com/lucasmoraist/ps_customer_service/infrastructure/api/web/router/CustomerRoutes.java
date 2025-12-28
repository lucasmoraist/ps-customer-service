package com.lucasmoraist.ps_customer_service.infrastructure.api.web.router;

import com.lucasmoraist.ps_customer_service.infrastructure.api.web.request.CustomerRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/customer")
public interface CustomerRoutes {

    @PostMapping("/register")
    ResponseEntity<Void> registerCustomer(@RequestBody @Valid CustomerRequest request);

}
