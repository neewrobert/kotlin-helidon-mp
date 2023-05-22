package com.neewrobert.helidonmp

import jakarta.enterprise.context.RequestScoped

@RequestScoped
open class PrimeNumberService {

    //using sieveOfEratosthenes algorithm
    open fun getPrimeNumbersInRange(rangeLimit: Int): List<Int> {

        val isPrime = BooleanArray(rangeLimit + 1) { true }
        val primeNumbers = mutableListOf<Int>()

        var currentNumber = 2
        while (currentNumber * currentNumber <= rangeLimit) {
            if (isPrime[currentNumber]) {
                for (multiple in currentNumber * currentNumber..rangeLimit step currentNumber) {
                    isPrime[multiple] = false
                }
            }
            currentNumber++
        }

        for (number in 2..rangeLimit) {
            if (isPrime[number]) {
                primeNumbers.add(number)
            }
        }

        return primeNumbers
    }

    open fun isPrimeNumber(number: Int): Boolean {

        if (number <= 1) {
            return false
        }
        var currentNumber = 2
        while (currentNumber * currentNumber <= number) {
            if (number % currentNumber == 0) {
                return false
            }
            currentNumber++
        }
        return true
    }

}