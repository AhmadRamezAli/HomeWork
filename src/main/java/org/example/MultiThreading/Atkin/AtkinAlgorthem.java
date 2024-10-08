package org.example.MultiThreading.Atkin;

import org.example.MultiThreading.Abstraction.PrimeStrategyFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class AtkinAlgorthem extends PrimeStrategyFinder {
    int start;
    int end;
    int threadCount;
    public boolean[] isPrime ;
    public AtkinAlgorthemExecutor atkinAlgorthemExecutor;
    public AtkinAlgorthem(int start, int end, int threadCount) {
        this.start = start;
        this.end = end;
        this.threadCount = threadCount;
        this.executor = Executors.newFixedThreadPool(threadCount);
        this.isPrime = new boolean[this.end + 1];
        atkinAlgorthemExecutor=new AtkinAlgorthemExecutor(start,end);
    }


    public boolean isPrime(int number) {
        return false;
    }

    public void run() throws InterruptedException {
        int threadInterval = (end - start) / threadCount;
        for (int i = 0; i < threadCount; i++) {
            // divid the interval for the i worker
            int rangeStart = start + i * threadInterval;
            int rangeEnd = (i == threadCount - 1) ? end : rangeStart + threadInterval - 1;

            executor.submit(new AtkinAlgorthemExecutor(rangeStart,rangeEnd));

        }


    }

    public List<Integer> getPrimes() {
        List<Integer> primes = new ArrayList<>();
        atkinAlgorthemExecutor.run();
        return atkinAlgorthemExecutor.primes;
    }
}
