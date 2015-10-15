package com.easy_binom.easybin;

public class Abc {
    public static double teilergebnis(double a, double b, double c) {
        return (b * b) - (4 * a * c);
    }

    public static String ergebnis1(double teilergebnis, double a, double b) {

        double ergebnis = ((-b) + Math.sqrt(teilergebnis)) / (2 * a);
       /*ergebnis = ergebnis * 100;
        double rest = ergebnis % 10;

        if (rest >= 5) {
            ergebnis = ergebnis + 10 - rest;
            ergebnis = ergebnis / 100;
        } else {
            ergebnis = ergebnis - rest;
            ergebnis = ergebnis / 100;
        }*/

        return "x1 = " + Binom.round(ergebnis,1);
    }

    public static String ergebnis2(double teilergebnis, double a, double b) {

        double ergebnis = ((-b) - Math.sqrt(teilergebnis)) / (2 * a);

        /*ergebnis = ergebnis * 100;
        double rest = ergebnis % 10;

        if (rest >= 5) {
            ergebnis = ergebnis + 10 - rest;
            ergebnis = ergebnis / 100;
        } else {
            ergebnis = ergebnis - rest;
            ergebnis = ergebnis / 100;
        }*/

        return "x2 = " + Binom.round(ergebnis,1);
    }

    public static String formel(double a, double b, double c) {
        if (teilergebnis(a, b, c) < 0) {
            return ("Keine Nullstellen vorhanden!" );
        }
        if (teilergebnis(a, b, c) == 0) {
            return "NS: " + ergebnis1(teilergebnis(a, b, c), a, b);
        }
        return "NS: " + ergebnis1(teilergebnis(a, b, c), a, b) + "  " + ergebnis2(teilergebnis(a, b, c), a, b);
    }
}

