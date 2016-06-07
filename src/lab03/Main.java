package lab03;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true){
		System.out.print("Veuillez saisir l'emplacement du ficher : ");
		String myFile = sc.nextLine();
		FileAnalyser fa = new FileAnalyser(myFile);
		try {
			List<Points> myList = fa.loadFile();
			CalculD c = new CalculD();
			if(c.start(myList)){
				System.out.println("Pente  = " + c.calculateSlope());
				System.out.println("Constante  = " + c.calculateCste());
				System.out.print("Choisir x ou y si vous voulez calculer x ou y  (x,y) sinon n pour retourner au menu principal : ");
				String myRep = sc.nextLine();
				if(myRep.equals("x")) {
					System.out.print("Veuillez saisir la valeur Y: ");
					double yVal = sc.nextDouble();
					System.out.println("Valeur de X  = " + c.calculateX(yVal));

				}
				else if(myRep.equals("y")) {
					System.out.print("Veuillez saisir la valeur X: ");
					double xVal = sc.nextDouble();
					System.out.println("Valeur de Y  = " + c.calculateY(xVal));
				}
			
			}
			else
				System.out.println("erreur lors de traitement de données");

		} catch (FileNotFoundException e) {
			System.out.println("Le fichier nexiste pas");
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erreur survenu lors du traitement du fichier");
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Erreur survenu lors de la conversion");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

	}

}
