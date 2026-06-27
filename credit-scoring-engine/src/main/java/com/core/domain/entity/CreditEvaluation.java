package com.core.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CreditEvaluation {
    private Long id;
    private Long applicationId;
    private BigDecimal debtRatio;
    private BigDecimal capacity;
    private BigDecimal internalScore;
    private String decision;
    private String reason; //can be a list of reasons with one principal
    private LocalDateTime createdAt;

}
