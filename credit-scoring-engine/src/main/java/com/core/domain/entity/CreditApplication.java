package com.core.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreditApplication {
    private Long id;
    private String customerName;
    private BigDecimal salary;
    private BigDecimal monthlyDebts;
    private BigDecimal bureauScore;
    private Integer yearsWorking;
    private BigDecimal requestedAmount;
    private String status;
    private LocalDateTime createdAt;
}
