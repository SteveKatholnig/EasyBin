
public class Binom {
	
	public static String firstBinom(double a, double b){
		
		return a*a + "² + " + 2*a*b + "ab + " + b*b + "²"; 
		
	}
	
	public static String secondBinom(double a, double b){
		
		return a*a + "² - " + 2*a*b + "ab + " + b*b + "²" + "\n"; 
		
	}
	
	public static String thirdBinom(double a, double b){
		
		return a*a + "² - " + b*b + "²";
		
	}
	
	public static String squareTerm(double a, double b, double c) {
		
		double d = (b*b)-(4*a*c);

		if (d <= 0) {
			return "Keine Lösung";
		}
		else {
			return "Die zu lösende quadratische Gleichung lautet:\n" + (int)a +"x² + " + (int)b + "x + " + (int)c + "\n" + "\n" +"Lösung:" + "\n" + "x1= " + (((-b+Math.sqrt(d)) / (2*a))) + "\n" + "x2= " + (((-b-Math.sqrt(d)) / (2*a)));
		}

	}

}
