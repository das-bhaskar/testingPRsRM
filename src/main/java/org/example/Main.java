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

        // EXPECT: PURE (direct extraction only)
        final boolean isMacOs = platform.toUpperCase().indexOf("MAC") > -1;
        final boolean isIE = browser.toUpperCase().indexOf("IE") > -1;
        final boolean wasResized = resize > 0;

        if (isMacOs && isIE && wasInitialized() && wasResized) {
            // unchanged behavior
        }
    }

    void case2_nestedPureBaseline() {
        String platform = System.getProperty("os.name").toLowerCase();
        String browser = System.getProperty("browser", "").toLowerCase();

        // EXPECT: PURE (nested extraction + wrapper parentheses)
        final boolean hasLinuxToken = platform.toUpperCase().contains("LINUX");
        final boolean isLinux = (hasLinuxToken);
        final boolean isChrome = ((browser.toUpperCase().contains("CHROME")));

        if ((((isLinux))) && ((isChrome))) {
            // unchanged behavior
        }
    }

    int case3_multiLevelPureBaseline(int w, int h, int padding, int offset) {
        // EXPECT: PURE (multi-level nested extraction)
        final int baseArea = w * h;
        final int intermediate = baseArea + padding;
        final int score = intermediate + offset;
        return score > 100 ? score : 100;
    }

    boolean case4_impureOperatorBaseline() {
        String platform = System.getProperty("os.name").toLowerCase();

        // EXPECT: IMPURE (semantic change: > -1 became > 0)
        final boolean isMacOs = platform.toUpperCase().indexOf("MAC") > 0;
        return isMacOs;
    }

    boolean case5_impureExtraConditionBaseline(int resize) {
        String browser = System.getProperty("browser", "").toLowerCase();

        // EXPECT: IMPURE (added extra condition after extraction)
        final boolean isIE = browser.toUpperCase().indexOf("IE") > -1;
        return isIE && resize > 10;
    }

    boolean case6_repeatedPureBaseline() {
        String platform = System.getProperty("os.name").toLowerCase();

        // EXPECT: PURE (extract repeated expression)
        final boolean isMacOs = platform.toUpperCase().indexOf("MAC") > -1;
        return isMacOs || isMacOs;
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