package com.core;


import com.core.domain.dto.CreditRequest;
import com.core.domain.dto.CreditResponse;
import com.core.application.service.CreditDecisionService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/credit")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CreditController {

    @Inject
    CreditDecisionService service;


    @POST
    @Path("/evaluate")
    public CreditResponse evaluate(CreditRequest request) {
        return service.evaluate(request);
    }

}
