package org.example;

import org.example.MultiThreading.Atkin.AtkinAlgorthem;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();


            // Run the algorithm
            AtkinAlgorthem sieve = new AtkinAlgorthem(14,16,3);
            sieve.run();
        System.out.println(sieve.getPrimes());

        // End time measurement
        long endTime = System.currentTimeMillis();

        // Calculate and print the elapsed time
        long elapsedTime = endTime - startTime;
        System.out.println("Execution time: " + elapsedTime + " ms");


    }
}