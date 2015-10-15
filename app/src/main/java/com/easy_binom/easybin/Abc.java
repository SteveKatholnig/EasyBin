package com.easy_binom.easybin;

public class Abc {
    public static double teilergebnis(double a, double b, double c) throws NumberFormatException{
        return (b * b) - (4 * a * c);
    }

    public static String ergebnis1(double teilergebnis, double a, double b) throws NumberFormatException{

        double ergebnis = ((-b) + Math.sqrt(teilergebnis)) / (2 * a);

        return "x1 = " + Binom.round(ergebnis,1);
    }

    public static String ergebnis2(double teilergebnis, double a, double b) throws NumberFormatException{

        double ergebnis = ((-b) - Math.sqrt(teilergebnis)) / (2 * a);

        return "x2 = " + Binom.round(ergebnis,1);
    }

    public static String formel(double a, double b, double c) {
        try{
            if (teilergebnis(a, b, c) < 0) {
                return ("Keine Nullstellen vorhanden!" );
            }
            if (teilergebnis(a, b, c) == 0) {
                return "Nullstelle: " + ergebnis1(teilergebnis(a, b, c), a, b);
            }
            return "Nullstellen: " + ergebnis1(teilergebnis(a, b, c), a, b) + "  " + ergebnis2(teilergebnis(a, b, c), a, b);
        }catch (NumberFormatException e){
            return "Die Lösung überschreitet den Maximalwert des Datentyps double";
        }
    }
}

