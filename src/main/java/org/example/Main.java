package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, World!");

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
}