package com.core.domain.entity;

import java.time.LocalDateTime;

public class DecisionRule {
    private Long id;
    private String ruleCode;
    private String ruleName;
    private Integer execution_order;
    private Boolean enabled;
    private LocalDateTime createdAt;
}
