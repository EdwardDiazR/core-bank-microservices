package com.core.application.service;


import com.core.domain.dto.CreditRequest;
import com.core.domain.dto.CreditResponse;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;

@ApplicationScoped
public class CreditDecisionService {

    private static final double MAX_DEBT_RATIO = 0.40;

    public CreditResponse evaluate(CreditRequest request) {

        BigDecimal maxDebtAllowed =
                request.monthlyIncome()
                        .multiply(BigDecimal.valueOf(MAX_DEBT_RATIO));

        BigDecimal availableCapacity =
                maxDebtAllowed.subtract(request.currentDebt());

        double debtRatio =
                request.currentDebt().doubleValue()
                        / request.monthlyIncome().doubleValue();

        double capacityScore =
                (availableCapacity.doubleValue()
                        / request.monthlyIncome().doubleValue()) * 50;

        double bureauScore =
                ((double) request.bureauScore() / 850) * 30;

        double laborScore =
                ((double) request.yearsAtWork() / 10) * 20;

        double finalScore =
                capacityScore + bureauScore + laborScore;

        String decision;

        if (finalScore >= 20) {
            decision = "APPROVED";
        } else if (finalScore >= 0) {
            decision = "MANUAL_REVIEW";
        } else {
            decision = "REJECTED";
        }

        return new CreditResponse(
                availableCapacity,
                debtRatio,
                finalScore,
                decision
        );
    }
}
