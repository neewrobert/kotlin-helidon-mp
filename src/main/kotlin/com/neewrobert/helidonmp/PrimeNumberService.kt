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
        }.also {
            println("PrimeNumberService.getPrimeNumbersInRange() took $it ms")
        }

        return primeNumbers
    }

    open fun isPrimeNumber(number: Int): Boolean {
        if (number <= 1) {
            return false
        }

        var isPrime = true
        measureTimeMillis {
            println("isPrimeNumber()")
            var currentNumber = 2
            while (currentNumber * currentNumber <= number) {
                if (number % currentNumber == 0) {
                    isPrime = false
                    break
                }
                currentNumber++
            }
        }.also {
            println("isPrimeNumber() took $it ms")
        }

        return isPrime
    }
}