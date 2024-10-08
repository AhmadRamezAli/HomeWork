package org.example.MultiThreading.eratosthenes;

import org.example.MultiThreading.Abstraction.PrimeStrategyFinder;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EratosthenesAlgorthem extends PrimeStrategyFinder
{
    private int start;
    private int end;
    private final BitSet primeCandidates;

    public EratosthenesAlgorthem(int start,int end, int threadCount) {
    this.start=start;
    this.end=end;
        // Initialize the BitSet where true represents a prime candidate
        primeCandidates = new BitSet(end + 1);
        primeCandidates.set(2, end + 1); // Mark all numbers as prime candidates starting from 2
        this.executor = Executors.newFixedThreadPool(threadCount); // Create a fixed thread pool
    }

    public void run() throws InterruptedException {
        int sqrtLimit = (int) Math.sqrt(end);

        for (int number = 2; number <= sqrtLimit; number++) {

            if (primeCandidates.get(number)) {
                // Submit a task to mark multiples of the current prime number
                executor.submit(new Deleter(number, primeCandidates, end));
            }
        }

        // Shutdown the executor and wait for all tasks to finish
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }

    public List<Integer> getPrimes() {
        List<Integer> primes = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if (primeCandidates.get(i)) {

                primes.add(i);
            }
        }
        return primes;
    }

    public boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }



}
