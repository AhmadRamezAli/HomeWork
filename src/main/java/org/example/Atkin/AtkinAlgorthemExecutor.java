package org.example.Atkin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AtkinAlgorthemExecutor implements Runnable {

    private int start;
    private int end;

    public AtkinAlgorthemExecutor(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        boolean[] isPrime = new boolean[this.end + 1];
        Arrays.fill(isPrime, false);

        // Sieve of Atkin Algorithm
        for (int x = 1; x * x <= this.end; x++) {
            for (int y = 1; y * y <= this.end; y++) {
                int n = (4 * x * x) + (y * y);
                if (n <= this.end && (n % 12 == 1 || n % 12 == 5)) {
                    isPrime[n] = !isPrime[n];
                }
                n = (3 * x * x) + (y * y);
                if (n <= this.end && n % 12 == 7) {
                    isPrime[n] = !isPrime[n];
                }
                n = (3 * x * x) - (y * y);
                if (x > y && n <= this.end && n % 12 == 11) {
                    isPrime[n] = !isPrime[n];
                }
            }
        }

        // Mark multiples of squares as non-prime
        for (int r = 5; r * r <= this.end; r++) {
            if (isPrime[r]) {
                for (int i = r * r; i <= this.end; i += r * r) {
                    isPrime[i] = false;
                }
            }
        }

        // Collect primes from the range
        List<Integer> primes = new ArrayList<>();
        if (start <= 2 && this.end >= 2) primes.add(2);
        if (start <= 3 && this.end >= 3) primes.add(3);

        for (int i = Math.max(5, start); i <= this.end; i++) {
            if (isPrime[i]) primes.add(i);
        }


    }
}
