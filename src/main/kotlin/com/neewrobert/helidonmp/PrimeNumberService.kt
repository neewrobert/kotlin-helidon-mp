package com.neewrobert.helidonmp

import jakarta.enterprise.context.RequestScoped
import kotlin.system.measureTimeMillis

@RequestScoped
open class PrimeNumberService {

    //using sieveOfEratosthenes algorithm
    open fun getPrimeNumbersInRange(rangeLimit: Int): List<Int> {
        val primeNumbers = mutableListOf<Int>()
        measureTimeMillis {
            println("getPrimeNumbersInRange()")
            val isPrime = BooleanArray(rangeLimit + 1) { true }
            findPrimeNumbers(rangeLimit, isPrime)
            for (number in 2..rangeLimit) {
                if (isPrime[number]) {
                    primeNumbers.add(number)
                }
            }
        }.also {
            println("PrimeNumberService.getPrimeNumbersInRange() took $it ms")
        }
        return primeNumbers
    }

    open fun isPrimeNumber(number: Int): Boolean {
        if (number <= 1) return false
        var isPrime = true

        measureTimeMillis {
            println("isPrimeNumber()")
            val isPrimeArray = BooleanArray(number + 1) { true }
            findPrimeNumbers(number, isPrimeArray)
            isPrime = isPrimeArray[number]
        }.also {
            println("isPrimeNumber() took $it ms")
        }

        return isPrime
    }

    private fun findPrimeNumbers(limit: Int, isPrime: BooleanArray) {
        var currentNumber = 2
        while (currentNumber * currentNumber <= limit) {
            if (isPrime[currentNumber]) {
                for (multiple in currentNumber * currentNumber..limit step currentNumber) {
                    isPrime[multiple] = false
                }
            }
            currentNumber++
        }
    }
}