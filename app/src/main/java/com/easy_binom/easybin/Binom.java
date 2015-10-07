package com.easy_binom.easybin;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Binom {

    public static String firstBinom(double x, double y) {

        double a = 0;
        double b = 0;

        //Prüfe ob die eingaben größer oder kleiner den zulässigen werten für double sind.
        if (x > Double.MAX_VALUE || x < Double.MIN_VALUE)
            a = 0.0;
        else if (y > Double.MAX_VALUE || y < Double.MIN_VALUE)
            b = 0.0;
        else{
            a = round(x, 1);
            b = round(y, 1);
        }

        return "This was the first binom!" + "\n" + "\n" + "Your input was:" + "\n" + "x= " + a + "  y= " + b + "\n" + "\n" + "Result:" + "\n" + a * a + "a² + " + 2 * a * b + "ab + " + b * b + "b²";

    }

    public static String secondBinom(double x, double y) {

        double a = 0;
        double b = 0;

        //Prüfe ob die eingaben größer oder kleiner den zulässigen werten für double sind.
        if (x > Double.MAX_VALUE || x < Double.MIN_VALUE)
            a = 0.0;
        else if (y > Double.MAX_VALUE || y < Double.MIN_VALUE)
            b = 0.0;
        else{
            a = round(x, 1);
            b = round(y, 1);
        }

        return "This was the second binom!" + "\n" + "\n" + "Your input was:" + "\n" + "x= " + a + "  y= " + b + "\n" + "\n" + "Result:" + "\n" + a * a + "a² - " + 2 * a * b + "ab + " + b * b + "b²" + "\n";

    }

    public static String thirdBinom(double x, double y) {

        double a = 0;
        double b = 0;

        //Prüfe ob die eingaben größer oder kleiner den zulässigen werten für double sind.
        if (x > Double.MAX_VALUE || x < Double.MIN_VALUE)
            a = 0.0;
        else if (y > Double.MAX_VALUE || y < Double.MIN_VALUE)
            b = 0.0;
        else{
            a = round(x, 1);
            b = round(y, 1);
        }

        return "This was the third binom!" + "\n" + "\n" + "Your input was:" + "\n" + "x= " + a + "  y= " + b + "\n" + "\n" + "Result:" + "\n" + a * a + "a² - " + b * b + "b²";

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
