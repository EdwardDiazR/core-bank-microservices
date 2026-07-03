package com.core.application.service;


import com.core.domain.dto.CreditRequest;
import com.core.domain.dto.CreditResponse;
import com.core.domain.enums.Decision;
import com.core.domain.model.CreditContext;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;

@ApplicationScoped
public class CreditService {

    @Inject
    CalculationService calculator;

    @Inject
    RuleEngineService ruleEngine;

    public CreditResponse evaluate(CreditRequest request) {

        // 1. calcular datos
        CreditContext context = calculator.calculate(request);

        // 2. aplicar reglas
        Decision decision = ruleEngine.evaluate(context);

        // 3. devolver respuesta
        return new CreditResponse(
                1L,
                decision.toString(),
                context.getScore(),
                context.getDebtRatio(),
                context.getAvailableCapacity(),
                "REASON"
        );
    }
}
