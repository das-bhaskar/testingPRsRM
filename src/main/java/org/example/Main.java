package org.example;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main {

    public boolean wasInitialized() {
        return false;
    }

    void renderBanner() {
        String platform = System.getProperty("os.name").toLowerCase();
        String browser = System.getProperty("browser").toLowerCase();
        int resize = 20;
        if ((platform.toUpperCase().indexOf("MAC") > -1) &&
                (browser.toUpperCase().indexOf("IE") > -1) &&
                wasInitialized() && resize > 0 )
        {
            // do something
        }
    }
    public static void main(String[] args) {

        System.out.println("Hello, World!");

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        IntStream.range(0,3).forEach(System.out::println);
    }
}