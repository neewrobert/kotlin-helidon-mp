package com.neewrobert.helidonmp

import io.helidon.microprofile.tests.junit5.HelidonTest
import jakarta.inject.Inject
import jakarta.ws.rs.client.WebTarget
import org.junit.jupiter.api.Test

@HelidonTest
open class PrimeNumberResourceTest {

    @Inject
    private lateinit var target: WebTarget

    @Test
    open fun `should return 4 prime numbers in range 10`() {
        val primeNumbers = target.path("/primenumber/10").request().get(Int::class.java)
        assert(primeNumbers == 4)
    }

    @Test
    open fun `should return true for given prime number`() {
        val isPrime = target.path("/primenumber/verify/11").request().get(Boolean::class.java)
        assert(isPrime)
    }

}