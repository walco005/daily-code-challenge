import java.math.BigDecimal;
import java.math.RoundingMode;

public class SurroundCircles_330 {

	public static void main(String[] args) {
		double[] arr1 = {1, 1, 2};
		double[] arr2 = {2, 2, 0.5};
		double[] arr3 = {-1, -3, 2};
		double[] arr4 = {5, 2, 1};
		double[][] fullArray = {arr1, arr2, arr3, arr4};
		System.out.println(getCoords(fullArray));
	}
	
	private static String getCoords(double[][] vals) {
		double maxX = vals[0][0] + vals[0][2];
		double minX = vals[0][0] - vals[0][2];
		double maxY = vals[0][1] + vals[0][2];
		double minY = vals[0][1] - vals[0][2];
		for (int i = 1; i < vals.length; i++) {
			double highX = vals[i][0] + vals[i][2];
			double lowX = vals[i][0] - vals[i][2];
			double highY = vals[i][1] + vals[i][2];
			double lowY = vals[i][1] - vals[i][2];
			if(highX > maxX) { maxX = highX; }
			if(lowX < minX) { minX = lowX; }
			if(highY > maxY) { maxY = highY; }
			if(lowY < minY) { minY = lowY; }
		}
		String ret = "(" + round(maxX, 3) + ", " + round(maxY, 3) + "), ("
				   	     + round(maxX, 3) + ", " + round(minY, 3) + "), (" 
				         + round(minX, 3) + ", " + round(maxY, 3) + "), (" 
				         + round(minX, 3) + ", " + round(minY, 3) + ")";
		return ret;
	}
	
	public static double round(double value, int places) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}
