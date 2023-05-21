package com.neewrobert.helidonmp

import jakarta.enterprise.context.RequestScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.eclipse.microprofile.metrics.annotation.Timed


@Path("/primenumber")
@RequestScoped
open class PrimeNumberResource


@Inject constructor(private val primeNumberService: PrimeNumberService) {


    @Path("/{range}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    open fun getPrimeNumberInARangeOf(@PathParam("range") range: Int): Int{

        return primeNumberService.getPrimeNumbersInRange(range).size
    }
}