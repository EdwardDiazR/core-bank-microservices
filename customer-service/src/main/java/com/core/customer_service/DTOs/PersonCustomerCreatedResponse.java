package com.core.customer_service.DTOs;

public record PersonCustomerCreatedResponse(String message,
                                            int status,
                                            Object data) {
}
