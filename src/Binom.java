
public class Binom {
	
	public static String firstBinom(double a, double b){
		
		return a*a + "� + " + 2*a*b + "ab + " + b*b + "�"; 
		
	}
	
	public static String secondBinom(double a, double b){
		
		return a*a + "� - " + 2*a*b + "ab + " + b*b + "�" + "\n"; 
		
	}
	
	public static String thirdBinom(double a, double b){
		
		return a*a + "� - " + b*b + "�";
		
	}
	
	public static String squareTerm(double a, double b, double c) {
		
		double d = (b*b)-(4*a*c);

		if (d <= 0) {
			return "Keine L�sung";
		}
		else {
			return "Die zu l�sende quadratische Gleichung lautet:\n" + (int)a +"x� + " + (int)b + "x + " + (int)c + "\n" + "\n" +"L�sung:" + "\n" + "x1= " + (((-b+Math.sqrt(d)) / (2*a))) + "\n" + "x2= " + (((-b-Math.sqrt(d)) / (2*a)));
		}

	}

}
