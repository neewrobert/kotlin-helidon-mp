package com.neewrobert.helidonmp

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PrimeNumberServiceTest {

    @Test
    fun `should return 4 prime numbers in range 10`() {
        val primeNumberService = PrimeNumberService()
        val primeNumbers = primeNumberService.getPrimeNumbersInRange(10)
        assert(primeNumbers.size == 4)
    }

    @Test
    fun `should return 25 prime numbers in range 100`() {
        val primeNumberService = PrimeNumberService()
        val primeNumbers = primeNumberService.getPrimeNumbersInRange(100)
        assert(primeNumbers.size == 25)
    }

    @ParameterizedTest
    @ValueSource(ints = [2, 3, 5, 7, 11])
    fun `should return true for prime numbers`(number: Int) {
        val primeNumberService = PrimeNumberService()
        val isPrime = primeNumberService.isPrimeNumber(number)
        assert(isPrime)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 4, 6, 8, 9, 10])
    fun `should return false for non prime numbers`(number: Int) {
        val primeNumberService = PrimeNumberService()
        val isPrime = primeNumberService.isPrimeNumber(number)
        assert(!isPrime)
    }


}