package org.example;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Main {

    public boolean wasInitialized() {
        return true;
    }

    void case1_simplePureBaseline() {
        String platform = System.getProperty("os.name").toLowerCase();
        String browser = System.getProperty("browser", "").toLowerCase();
        int resize = 20;

        if (platform.toUpperCase().indexOf("MAC") > -1
                && browser.toUpperCase().indexOf("IE") > -1
                && wasInitialized()
                && resize > 0) {
            // baseline logic
        }
    }

    void case2_nestedPureBaseline() {
        String platform = System.getProperty("os.name").toLowerCase();
        String browser = System.getProperty("browser", "").toLowerCase();

        if ((((platform.toUpperCase().contains("LINUX"))))
                && ((browser.toUpperCase().contains("CHROME")))) {
            // baseline logic
        }
    }

    int case3_multiLevelPureBaseline(int w, int h, int padding, int offset) {
        int score = (w * h) + padding + offset;
        return score > 100 ? score : 100;
    }

    boolean case4_impureOperatorBaseline() {
        String platform = System.getProperty("os.name").toLowerCase();
        return platform.toUpperCase().indexOf("MAC") > -1;
    }

    boolean case5_impureExtraConditionBaseline(int resize) {
        String browser = System.getProperty("browser", "").toLowerCase();
        return browser.toUpperCase().indexOf("IE") > -1;
    }

    boolean case6_repeatedPureBaseline() {
        String platform = System.getProperty("os.name").toLowerCase();
        return platform.toUpperCase().indexOf("MAC") > -1
                || platform.toUpperCase().indexOf("MAC") > -1;
    }

    public static void main(String[] args) {
        Main app = new Main();

        app.case1_simplePureBaseline();
        app.case2_nestedPureBaseline();
        System.out.println(app.case3_multiLevelPureBaseline(10, 12, 3, 5));
        System.out.println(app.case4_impureOperatorBaseline());
        System.out.println(app.case5_impureExtraConditionBaseline(20));
        System.out.println(app.case6_repeatedPureBaseline());

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        IntStream.range(0, 3).forEach(System.out::println);
    }
}