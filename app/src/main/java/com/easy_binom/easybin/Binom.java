package com.easy_binom.easybin;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Binom {

    public static String firstBinom(double x, double y) {

        double a = x;
        double b = y;

        //Prüfe ob die eingaben größer oder kleiner den zulässigen werten für double sind.
        if (x > Double.MAX_VALUE || x < Double.MIN_VALUE) {
            x = 0.0;
        } else if (y > Double.MAX_VALUE || y < Double.MIN_VALUE) {
            y = 0.0;
        } else {
            a = round(x, 1);
            b = round(y, 1);
        }

        double resa = a * a;
        double resb = 2 * a * b;
        double resc = b * b;


        return "This was the first binom!" + "\n" + "\n" + "Your input was:" + "\n" + "a= " + x + "  b= " + y + "\n" + "\n" + "Result:" + "\n" + round(resa,1) + "x² + " + round(resb,1) + "x + " + round(resc,1) + "\n" + Abc.formel(resa, resb, resc);

    }

    public static String secondBinom(double x, double y) {

        double a = x;
        double b = y;

        //Prüfe ob die eingaben größer oder kleiner den zulässigen werten für double sind.
        if (x > Double.MAX_VALUE || x < Double.MIN_VALUE) {
            x = 0.0;
        } else if (y > Double.MAX_VALUE || y < Double.MIN_VALUE) {
            y = 0.0;
        } else {
            a = round(x, 1);
            b = round(y, 1);
        }

        double resa = a * a;
        double resb = 2 * a * b;
        double resc = round(b * b, 1);

        return "This was the second binom!" + "\n" + "\n" + "Your input was:" + "\n" + "a= " + x + "  b= " + y + "\n" + "\n" + "Result:" + "\n" + round(resa,1) + "x² - " + round(resb,1) + "x + " + round(resc,1) + "\n" + Abc.formel(resa, -resb, resc);

    }

    public static String thirdBinom(double x, double y) {

        double a = x;
        double b = y;

        //Prüfe ob die eingaben größer oder kleiner den zulässigen werten für double sind.
        if (x > Double.MAX_VALUE || x < Double.MIN_VALUE) {
            x = 0.0;
        } else if (y > Double.MAX_VALUE || y < Double.MIN_VALUE) {
            y = 0.0;
        } else {
            a = round(x, 1);
            b = round(y, 1);
        }

        double resa = a * a;
        double resb = 0;
        double resc = round(b * b, 1);

        return "This was the third binom!" + "\n" + "\n" + "Your input was:" + "\n" + "a= " + x + "  b= " + y + "\n" + "\n" + "Result:" + "\n" + round(resa,1) + "x² - " + round(resc,1) + "\n" + Abc.formel(resa, resb, -resc);

    }


    /**
     * Gibt einen gerundeten double Wert abhängig von @param places zurück.
     *
     * @param value  ein double wert der gerundet werden soll
     * @param places die anzahl der digits auf die gerundet werden soll in Form eines integers
     * @return der gerundete double wert
     */
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
