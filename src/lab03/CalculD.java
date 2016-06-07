package lab03;
import java.util.List;


public final class CalculD {
	private double variance = 0;
	private double ecartType = 0;
	private double average = 0;
	private double correlation = 0;
	private double slope = 0;
	private double cste = 0;
	private double sumX = 0;
	private double sumY = 0;
	private double sumProduct = 0;
	private double sumXSquare = 0;
	private double sumYSquare = 0;
	private double cnt = 0;
	
	
	public CalculD(){
	
	}
	/**
	 * This function was used to calculate variance,average,sd.
	 * @param myList
	 * @return
	 */
	public  boolean oldStart(List<Double> myList){
		double v = 0;
		double sum = 0;
		double cnt = 0;
		try{
		for(Double element : myList){
			sum +=element;
			cnt +=1;
		}
		average = sum/cnt;
		for(Double element : myList){
			v += Math.pow(element - average, 2);
		}
		variance = v/(cnt-1);
		ecartType = (double) Math.sqrt(variance);
		}catch(Exception e){return false;}
		return true;
	}
	
	
	public  boolean start(List<Points> myList){
		
		try{
		for(Points element : myList){
			sumX += element.getX();
			sumY += element.getY();
			sumProduct += element.getX() * element.getY();
			sumXSquare += Math.pow(element.getX(), 2);
			sumYSquare += Math.pow(element.getY(), 2);
			cnt +=1;
		}



		
		}catch(Exception e){return false;}
		return true;
	}
	
	public  double calculateCorrelation(){
		correlation = (cnt * sumProduct - sumX * sumY) / Math.sqrt((cnt*sumXSquare - sumXSquare) * (cnt*sumYSquare - sumYSquare));
		return correlation;
	}
	
	public double calculateSlope() {
	     slope = (sumProduct - cnt*(sumX/cnt)*(sumY/cnt)) / (sumXSquare - cnt*(Math.pow(sumX/cnt,2)));
	     return slope;
	}
	
	public double calculateCste() {
		System.out.println("Sum Y " + sumY);
		System.out.println("Cnt " + cnt);
		System.out.println("Slope " + slope);
		System.out.println("Sum X " + sumX);


		cste = (sumY/cnt) - slope*(sumX/cnt);
		return cste;
	}
	
	public double calculateY(double x) {
		return slope*x + cste;
	}
	public double calculateX(double y) {
		return (y-cste)/slope;
	}
	

}
