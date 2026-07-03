# 🏦 Credit Decision Engine

> Motor de decisión crediticia inspirado en la arquitectura utilizada por entidades financieras. Desarrollado con **Quarkus** para simular el proceso de evaluación de solicitudes de crédito mediante reglas de negocio, cálculos financieros y parámetros configurables.

![Java](https://img.shields.io/badge/Java-21-red)
![Quarkus](https://img.shields.io/badge/Quarkus-3.x-blue)
![Estado](https://img.shields.io/badge/Estado-En%20desarrollo-success)

---

# 📖 Descripción

Este proyecto simula el funcionamiento de un **Motor de Decisión Crediticia**, componente fundamental dentro de un proceso de originación de créditos (Loan Origination System).

El sistema recibe una solicitud de crédito, calcula indicadores financieros, ejecuta un conjunto de reglas de negocio y genera una decisión automática acompañada de las razones que justifican el resultado.

Su objetivo es demostrar una arquitectura limpia y escalable inspirada en sistemas bancarios reales, utilizando tecnologías modernas del ecosistema Java.

---

# 🎯 Objetivos del proyecto

* Simular el proceso de evaluación de créditos utilizado por un banco.
* Implementar un motor de reglas desacoplado.
* Separar la lógica de cálculo de la lógica de decisión.
* Permitir que las políticas de crédito sean configurables.
* Aplicar buenas prácticas de arquitectura empresarial.
* Servir como proyecto de portafolio para demostrar conocimientos en desarrollo backend.

---

# ✨ Características

* Evaluación de solicitudes de crédito.
* Cálculo de capacidad de endeudamiento.
* Cálculo de relación deuda / ingreso (Debt To Income).
* Cálculo de score interno.
* Motor de reglas de negocio.
* Decisiones automáticas:

  * ✅ Aprobado
  * ⚠️ Revisión Manual
  * ❌ Rechazado
* Lista de razones que justifican la decisión.
* Razón principal de la evaluación.
* Arquitectura desacoplada y escalable.
* API REST desarrollada con Quarkus.

---

# 💳 Productos soportados

Actualmente:

* ✅ Préstamo Personal

Próximamente:

* Tarjeta de Crédito
* Préstamo Vehicular
* Hipoteca
* Crédito Comercial

Cada producto podrá contar con:

* Reglas propias
* Parámetros independientes
* Cálculos específicos
* Políticas de riesgo distintas

---

# 🏗 Arquitectura

```text
Cliente

    │

    ▼

REST API

    │

    ▼

Credit Controller

    │

    ▼

Credit Service

    │

    ▼

Calculator Factory

    │

    ├───────────────┐
    ▼               ▼

Loan Calculator   Credit Card Calculator

    │

    ▼

Credit Context

    │

    ▼

Rule Engine

    │

    ▼

Reglas de Negocio

    │

    ▼

Decisión Final
```

---

# 📂 Estructura del proyecto

```text
src/main/java

com.edward.credit.engine

├── api
│
├── application
│
├── domain
│   ├── model
│   ├── entity
│   ├── repository
│   └── rule
│
├── infrastructure
│
├── configuration
│
└── shared
```

---

# 🧩 Componentes principales

## Credit Controller

Expone los endpoints REST del sistema.

---

## Credit Service

Coordina todo el flujo de evaluación.

No contiene cálculos ni reglas.

Su responsabilidad es orquestar el proceso.

---

## Calculator

Calcula indicadores financieros como:

* Relación deuda / ingreso.
* Capacidad de endeudamiento.
* Cuota mensual del préstamo.
* Score interno.

---

## Rule Engine

Ejecuta todas las reglas activas del sistema.

Cada regla es independiente y puede aprobar, rechazar o solicitar revisión manual.

---

## Credit Context

Objeto compartido durante toda la evaluación.

Contiene:

* Solicitud recibida.
* Indicadores calculados.
* Parámetros cargados.
* Resultados de las reglas.

---

# 📋 Reglas implementadas

Actualmente el motor puede evaluar reglas como:

* Relación deuda / ingreso.
* Score mínimo del buró.
* Capacidad de pago.
* Monto solicitado.
* Antigüedad laboral.

Cada regla genera un resultado independiente.

Ejemplo:

```text
✔ Relación deuda/ingreso aceptable.

✔ Score crediticio aceptable.

✔ Capacidad de pago suficiente.

✖ Antigüedad laboral insuficiente.
```

Al finalizar la evaluación el motor determina la decisión global.

---

# ⚙ Parámetros configurables

El objetivo del proyecto es permitir que las políticas de negocio puedan modificarse sin recompilar la aplicación.

Ejemplos:

| Parámetro             | Descripción                          |
| --------------------- | ------------------------------------ |
| MAX_DEBT_RATIO        | Relación máxima deuda/ingreso        |
| MIN_BUREAU_SCORE      | Score mínimo permitido               |
| AUTO_APPROVE_SCORE    | Score para aprobación automática     |
| MAX_INSTALLMENT_RATIO | Porcentaje máximo destinado a cuotas |

---

# 📥 Ejemplo de solicitud

```json
{
    "customerId":"123456",
    "productType":"PERSONAL_LOAN",
    "monthlyIncome":50000,
    "monthlyDebts":12000,
    "requestedAmount":300000,
    "termInMonths":24,
    "bureauScore":720,
    "yearsWorking":4
}
```

---

# 📤 Ejemplo de respuesta

```json
{
    "decision":"APPROVED",
    "primaryReason":"El cliente cumple con todas las políticas de crédito.",
    "reasons":[
        "La relación deuda/ingreso es aceptable.",
        "El score del buró es aceptable.",
        "La capacidad de pago es suficiente."
    ],
    "score":82.4,
    "debtRatio":0.24,
    "availableCapacity":10000,
    "monthlyInstallment":14875.62
}
```

---

# 🚀 Tecnologías

* Java 21
* Quarkus
* RESTEasy Reactive
* Hibernate ORM
* Panache
* PostgreSQL
* Flyway
* Maven

---

# 🔮 Próximas mejoras

* Reglas dinámicas desde base de datos.
* Parámetros configurables sin redespliegue.
* Versionado de políticas de crédito.
* Motor de reglas por producto financiero.
* Auditoría de decisiones.
* Historial de evaluaciones.
* Caché de parámetros.
* Docker.
* Kubernetes.
* Integración con Kafka.
* Observabilidad con OpenTelemetry.

---

# 🎓 Conceptos aplicados

Este proyecto busca poner en práctica conceptos utilizados en aplicaciones empresariales del sector financiero:

* Arquitectura por capas.
* Separación de responsabilidades.
* Principio de Responsabilidad Única (SRP).
* Patrón Strategy.
* Motor de reglas de negocio.
* Organización orientada al dominio.
* APIs REST.
* Configuración dinámica de políticas.
* Simulación de evaluación crediticia.

---

# 👨‍💻 Autor

**Edward A. Díaz**

Proyecto desarrollado con fines educativos y de fortalecimiento del portafolio profesional, inspirado en la arquitectura de motores de decisión utilizados por entidades financieras.
