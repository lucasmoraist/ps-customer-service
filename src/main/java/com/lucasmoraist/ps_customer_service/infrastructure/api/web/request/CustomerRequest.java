package com.lucasmoraist.ps_customer_service.infrastructure.api.web.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CustomerRequest(
        @NotBlank(message = "Name is required")
        @Size(min = 3, message = "Name must be at least 3 characters long")
        String name,
        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        String email,
        @Size(min = 6, message = "Password must be at least 6 characters long")
        String password,
        @NotEmpty(message = "At least one document is required")
        List<DocumentRequest> documents,
        List<PaymentKeyRequest> paymentKeys
) {

}
