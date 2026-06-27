package com.core.domain.entity;

import java.time.LocalDateTime;

public class DecisionParameter {
    private Long id;
    private String parameterKey;
    private String parameterValue;
    private String description;
    private Boolean enabled;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
