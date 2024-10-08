package org.example.MultiThreading.eratosthenes;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Deleter implements Runnable
{
    private final int limit;
    private final int number;
    private final BitSet primeCandidates;
    public Deleter(int number,BitSet primeCandidates ,int limit) {
        this.number = number;
        this.limit = limit;
        this.primeCandidates = primeCandidates;
    }



    @Override
    public void run() {
        // Mark multiples of the number as non-prime (starting from number*number)
        for (int i = number * number; i <= limit; i += number) {
            primeCandidates.set(i, false);
        }
    }
}
