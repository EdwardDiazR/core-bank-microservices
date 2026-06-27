package com.core.domain.dto;

import java.math.BigDecimal;

public record CreditRequest(
        BigDecimal monthlyIncome,
        BigDecimal currentDebt,
        Integer bureauScore,
        Integer yearsAtWork
) {
}