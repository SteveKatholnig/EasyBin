package com.easy_binom.easybin;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Binom {

    public static String firstBinom(double x, double y) {

        double a = round(x, 1);
        double b =round(y, 1);

        if (a > Double.MAX_VALUE || a < Double.MIN_VALUE)
            a = 0.0;
        if (b > Double.MAX_VALUE || b < Double.MIN_VALUE)
            b = 0.0;

        return "This was the first binom!" + "\n" + "\n" + "Your input was:" + "\n" + "x= " + a + "  y= " + b + "\n" + "\n" + "Result:" + "\n" + a * a + "a² + " + 2 * a * b + "ab + " + b * b + "b²";

    }

    public static String secondBinom(double x, double y) {

        double a = round(x, 1);
        double b =round(y, 1);

        if (a > Double.MAX_VALUE || a < Double.MIN_VALUE)
            a = 0.0;
        if (b > Double.MAX_VALUE || b < Double.MIN_VALUE)
            b = 0.0;

        return "This was the second binom!" + "\n" + "\n" + "Your input was:" + "\n" + "x= " + a + "  y= " + b + "\n" + "\n" + "Result:" + "\n" + a * a + "a² - " + 2 * a * b + "ab + " + b * b + "b²" + "\n";

    }

    public static String thirdBinom(double x, double y) {

        double a = round(x, 1);
        double b =round(y, 1);

        if (a > Double.MAX_VALUE || a < Double.MIN_VALUE)
            a = 0.0;
        if (b > Double.MAX_VALUE || b < Double.MIN_VALUE)
            b = 0.0;

        return "This was the third binom!" + "\n" + "\n" + "Your input was:" + "\n" + "x= " + a + "  y= " + b + "\n" + "\n" + "Result:" + "\n" + a * a + "a² - " + b * b + "b²";

    }

    public static String squareTerm(double a, double b, double c) {

        double d = (b * b) - (4 * a * c);

        if (d <= 0) {
            return "Keine Lösung";
        } else {
            return "Die zu lösende quadratische Gleichung lautet:\n" + (int) a + "x² + " + (int) b + "x + " + (int) c + "\n" + "\n" + "Lösung:" + "\n" + "x1= " + (((-b + Math.sqrt(d)) / (2 * a))) + "\n" + "x2= " + (((-b - Math.sqrt(d)) / (2 * a)));
        }

    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
