package lab03;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class FileAnalyser {

	private String myFile;
	public FileAnalyser(String myFile){
		this.myFile = myFile;
	}
	
	/**
	 * This function was used for TP1
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<Double> oldLoadFile() throws FileNotFoundException, IOException{
		String line = null;
		List<Double> numberList = new ArrayList<Double>();
	
		BufferedReader bfr = new BufferedReader(new FileReader(myFile));
		while((line = bfr.readLine()) != null) {
			numberList.add(Double.parseDouble(line));
		}
		bfr.close();
		return numberList;
	}
	
	
	/**
	 * this function is user for TP2
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 */
	public List<Points> loadFile() throws FileNotFoundException, IOException, NumberFormatException, ParseException{
		String line = null;
		List<Points> numberList = new ArrayList<Points>();
	
		BufferedReader bfr = new BufferedReader(new FileReader(myFile));
		String splitBy = ";";
		NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
		while((line = bfr.readLine()) != null) {
			String[] splitLine = line.split(splitBy);
			numberList.add(new Points(format.parse(splitLine[0]).doubleValue(),format.parse(splitLine[1]).doubleValue()));
		}
		bfr.close();
		return numberList;
	}
	
	
}
