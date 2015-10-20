package codechallenge;

import java.time.chrono.MinguoChronology;

public class Calculator {

	private char operator;
	private String opgave;

	private static final String bewerkingen = "-+/*";
	private static final String operands = "0123456789";

	public Calculator(String opgave) {
		this.opgave = opgave;
	}

	public static double Calculate(String opgave) {
		// Evalueer opgave
		// voer bewerkingen uit
		// vervang bewerking door resultaat in opgave
		// tot lengte = 1
		// toon resultaat
		int maal = Integer.MAX_VALUE, delen = Integer.MAX_VALUE, plus = Integer.MAX_VALUE, min = Integer.MAX_VALUE;
		while (opgave.contains("*") || opgave.contains("/")) {
			//op max value zetten, we zoeken de laagste moet iedere keer reset worden
			maal = Integer.MAX_VALUE;
			delen = Integer.MAX_VALUE;
			if (opgave.contains("*")) { // zoek vermenigvuldiging
				maal = opgave.indexOf("*");
			}
			if (opgave.contains("/")) { // zoek deling
				delen = opgave.indexOf("/");
			}
			// zoek laagste van de twee eerste bewerking. linkse eerst
			int bewerking = Laagste(maal, delen);

			opgave = opgaveBewerken(bewerking, opgave);
		}
		System.out.println(opgave);
		while (opgave.contains("+") || opgave.contains("-")) {
			//op max value zetten, we zoeken de laagste moet iedere keer reset worden
			plus = Integer.MAX_VALUE;
			min = Integer.MAX_VALUE;
			if (opgave.contains("+")) { // zoek +
				plus = opgave.indexOf("+");
			}
			if (opgave.contains("-")) { // zoek -
				min = opgave.indexOf("-");
			}
			// zoek laagste van de twee eerste bewerking. linkse eerst
			int bewerking = Laagste(plus, min);
			opgave = opgaveBewerken(bewerking, opgave);
		}

		return Integer.parseInt(opgave);

	}
	
	private static String opgaveBewerken(int bew, String regel) {

		
		char linksChar = regel.charAt(bew - 1);
		char rechtsChar = regel.charAt(bew + 1);
		char bewChar = regel.charAt(bew);

		int links = Integer.parseInt(regel.charAt(bew - 1) + "");
		int rechts = Integer.parseInt(regel.charAt(bew + 1) + "");
		char bewerking = regel.charAt(bew);
		int reslt = rekenUit(bewerking, links, rechts);
		// vervang resultaat in opgave
		String bewString = Character.toString(linksChar)
				+ Character.toString(bewChar) + Character.toString(rechtsChar);
		// System.out.println(bewString);
		return regel.replace(bewString, String.valueOf(reslt));

	}

	private static int Laagste(int a, int b) {
		return (a < b) ? a : b;
	}

	private static int rekenUit(char bew, int a, int b) {
		int res = Integer.MIN_VALUE;
		switch (bew) {
		case '*':
			res = Maal(a, b);
			break;
		case '/':
			res = Delen(a, b);
			break;
		case '+':
			res = Plus(a, b);
			break;
		case '-':
			res = Min(a, b);
			break;
		default:
			break;
		}
		return res;
	}

	private static int Maal(int a, int b) {
		return a * b;
	}

	private static int Delen(int a, int b) {
		return a / b;
	}

	private static int Plus(int a, int b) {
		return a + b;
	}

	private static int Min(int a, int b) {
		return a - b;
	}

}
