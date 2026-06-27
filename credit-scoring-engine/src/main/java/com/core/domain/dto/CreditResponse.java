package com.core.domain.dto;

import java.math.BigDecimal;

public record CreditResponse(
        Long applicationId,
        String decision,
        BigDecimal internalScore,
        BigDecimal debtRatio,
        BigDecimal availableCapacity,
        String reason
) {
}
