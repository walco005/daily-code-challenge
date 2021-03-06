//Challenge #330 [Intermediate] Check Writer
//https://www.reddit.com/r/dailyprogrammer/comments/6yep7x/20170906_challenge_330_intermediate_check_writer/

public class CheckWriter_330 {

	public static void main(String[] args) {
		String number1 = "742388.00";
		String number2 = "1.10";
		String number3 = "999999.99";
		String number4 = "10.01";
		System.out.println(checkWriter(number1));
		System.out.println(checkWriter(number2));
		System.out.println(checkWriter(number3));
		System.out.println(checkWriter(number4));
	}
	public static String checkWriter(String str) {
		int decIndex = str.indexOf('.');
		String decString = "";
		String numString = "";
		String centString = "";
		int cents = 0;
		if(decIndex > 0) {
			decString = str.substring(decIndex + 1, str.length());
			numString = str.substring(0, decIndex);
		} else {
			numString = str;
		}
		if (!numString.isEmpty()) {
			int[] digits = getDigits(Integer.parseInt(numString));
			if(!decString.isEmpty()) {
				cents = Integer.parseInt(decString);
			}
			String thouString = calcHundreds(digits[5]) + calcTens(digits[4], digits[3]);
			if(!thouString.isEmpty()) {
				thouString += "thousand, ";
			}
			String hundString = calcHundreds(digits[2]) + calcTens(digits[1], digits[0]);
			if(cents == 0) {
				centString = "zero ";
			} else {
				centString = calcTens((cents / 10) % 10, cents % 10);
			}
			String dollarString = "";
			if(cents == 1) {
				dollarString = thouString + hundString + "dollars and " + centString + "cent.";
			} else {
				dollarString = thouString + hundString + "dollars and " + centString + "cents.";
			}
			return Character.toUpperCase(dollarString.charAt(0)) + dollarString.substring(1);
		} else {
			return "";
		}
	}
	public static int[] getDigits(int dollars) {
		int[] digits = new int[6];
		int length = String.valueOf(dollars).length();
		for(int i = 0; i < length; i++) {
			digits[i] = (int) Math.floor(dollars) % 10;
			dollars = dollars / 10;
		}
		return digits;
	}
	public static int makeCents(float n) {
		System.out.println(n);
		System.out.println(Math.floor(n));
		System.out.println(n - (float) Math.floor(n));
		float cents = (float) ((n % Math.floor(n)) * 100);
		System.out.println(cents);
		return (int) Math.floor(cents);
	}
	public static String calcHundreds(int hund) {
		String hundString;
		switch (hund) {
		case 1: hundString = "one hundred ";
				break;
		case 2: hundString = "two hundred ";
				break;
		case 3: hundString = "three hundred ";
				break;
		case 4: hundString = "four hundred ";
				break;
		case 5: hundString = "five hundred ";
				break;
		case 6: hundString = "six hundred ";
				break;
		case 7: hundString = "seven hundred ";
				break;
		case 8: hundString = "eight hundred ";
				break;
		case 9: hundString = "nine hundred ";
				break;
		default: hundString = "";
				 break;
		}
		return hundString;
	}
	
	public static String calcTens(int tens, int ones) {
		String tenString;
		String oneString;
		switch (tens) {
		case 1: switch (ones) {
				case 1: tenString = "eleven ";
						break;
				case 2: tenString = "twelve ";
						break;
				case 3: tenString = "thirteen ";
						break;
				case 4: tenString = "fourteen ";
						break;
				case 5: tenString = "fifteen ";
						break;
				case 6: tenString = "sixteen ";
						break;
				case 7: tenString = "seventeen ";
						break;
				case 8: tenString = "eighteen ";
						break;
				case 9: tenString = "nineteen ";
						break;
				default: tenString = "ten ";
						 break;
				}
				return tenString;
		case 2: tenString = "twenty ";
				break;
		case 3: tenString = "thirty ";
				break;
		case 4: tenString = "fourty ";
				break;
		case 5: tenString = "fifty ";
				break;
		case 6: tenString = "sixty ";
				break;
		case 7: tenString = "seventy ";
				break;
		case 8: tenString = "eighty ";
				break;
		case 9: tenString = "ninety ";
				break;
		default: tenString = "";
				 break;
		}
		switch (ones) {
		case 1: oneString = "one ";
				break;
		case 2: oneString = "two ";
				break;
		case 3: oneString = "three ";
				break;
		case 4: oneString = "four ";
				break;
		case 5: oneString = "five ";
				break;
		case 6: oneString = "six ";
				break;
		case 7: oneString = "seven ";
				break;
		case 8: oneString = "eight ";
				break;
		case 9: oneString = "nine ";
				break;
		default: oneString = "";
				 break;
		}
		return tenString + oneString;
	}
	
	
}
