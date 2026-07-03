package com.core.domain.model;

public class RuleMessages {
    private RuleMessages() {
    }

    public static final String DEBT_RATIO_ACCEPTED =
            "El cliente posee capacidad de endeudamiento.";

    public static final String DEBT_RATIO_REJECTED =
            "La relación deuda/ingreso supera el máximo permitido.";

    public static final String BUREAU_ACCEPTED =
            "El score del buró cumple la política.";

    public static final String BUREAU_REJECTED =
            "El score del buró es inferior al mínimo permitido.";
}
