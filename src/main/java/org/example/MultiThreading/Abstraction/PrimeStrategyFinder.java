package org.example.MultiThreading.Abstraction;

import java.util.List;
import java.util.concurrent.ExecutorService;

public abstract class PrimeStrategyFinder {

    public ExecutorService executor = null;
    public abstract boolean isPrime(int number) ;
    public abstract void run() throws InterruptedException;
    public abstract List<Integer>getPrimes();
}