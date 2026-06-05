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
        final boolean isMacOs = platform.toUpperCase().indexOf("MAC") > -1;
        final boolean isIE = browser.toUpperCase().indexOf("IE") > -1;
        final boolean wasResized = resize > 0;

        if (isMacOs && isIE && wasInitialized() && wasResized) {
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