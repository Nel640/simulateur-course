import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class SimulateurCourse 
{
	public static void main(String[] args) 
	{
		HashMap<String , Integer> horseTabNameVariable = new HashMap<>();
		ArrayList<Integer> horseTabSpeedVariable = new ArrayList<Integer>();	
		ArrayList<Integer> horseTabDistanceVariable = new ArrayList<Integer>();
		int timer = 0;
		int tour = 0;
		
		Scanner scan = new Scanner(System.in);
		Boolean continueBool = true;
		
		while(continueBool)
		{
			System.out.println("combien de chevaux sont dans la course ? (12 a 20 chevaux) : ");
			int horsesNumber = scan.nextInt();
			
			horsesNumber = verificationNumberHorsesFunction(horsesNumber, scan);//test
			
			System.out.println("quel est le type de couse ? (tierce, quarte, quinte) : ");
			String runType = scan.next();
			
			runType = verificationTypeFunction(runType, scan);//test
			
			//valeur principal
			horseTabNameVariable = horsesTabNameFunction(horsesNumber, scan);//tableau name et values qui servent de key
			horseTabSpeedVariable = horsesTabSpeedFunction(horsesNumber);// tableau initialisation vitesse a zero
			horseTabDistanceVariable = horsesTabDistanceFunction(horsesNumber);//tableau initialisation distance a zero
			int lancerDes = desGenerate(0, 5);
			desGenerate(0,5);
			horseTabSpeedVariable = incrementSpeed(lancerDes, horsesNumber, tour);
			System.out.println(lancerDes);
			System.out.println(horseTabSpeedVariable);
			
			System.out.println("voulez vous rejouez ? : ");
			String continueAnswer = scan.next();
			
			if(continueAnswer.toUpperCase().equals("O"))
			{
				continueBool = true;
			}
			else 
			{
				continueBool = false;
				System.out.println("a bientot ");
			}
		}
		scan.close();
	}
	
	public static String verificationTypeFunction ( String Type , Scanner scan)
	{
		while( !Type.equals("tierce") && !Type.equals("quarte") && !Type.equals("quinte"))
		{
			System.out.println("tierce , quarte ou quinte uniquement : ");
			Type = scan.next();
		}
		return Type;
	}
	
	public static int verificationNumberHorsesFunction ( int numberHorse , Scanner scan)
	{
		while(numberHorse > 20 || numberHorse < 12 )
		{
			System.out.println("nombre de chevaux entre 12 et 20 uniquement : ");
			numberHorse = scan.nextInt();
		}
		return numberHorse;
	}
	
	public static HashMap<String , Integer> horsesTabNameFunction ( int horseVerif , Scanner scan)
	{
		HashMap<String , Integer> horseGenerate = new HashMap<String, Integer>();
		String[] horseName = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t"};
		int horsesNumber = verificationNumberHorsesFunction(horseVerif, scan);
		
		for(int i = 0 ; i < horsesNumber ; i++ )
		{
			horseGenerate.put(horseName[i], i );
		}
		
		return horseGenerate;
	}
	
	public static ArrayList<Integer> horsesTabSpeedFunction (int horsesNumber)
	{
		ArrayList<Integer> horsesSpeed = new ArrayList<Integer>();	
		
		for( int i = 0 ; i < horsesNumber ; i++)
		{
			horsesSpeed.add(0);
		}
		return horsesSpeed;
	}
	
	public static ArrayList<Integer> horsesTabDistanceFunction (int horsesNumber)
	{
		ArrayList<Integer> horsesDistance = new ArrayList<Integer>();	
		
		for( int i = 0 ; i < horsesNumber ; i++)
		{
			horsesDistance.add(0);
		}
		return horsesDistance;
	}
	
	public static int desGenerate ( int nbMin , int nbMax)
	{
			 Random random = new Random();
			 int nb;
			 nb = random.nextInt(nbMax-nbMin)+1;
			 return nb;
	}
	
	public static ArrayList<Integer> incrementSpeed ( int lancerDes , int horsesNumber , int tour)
	{
		ArrayList<Integer> tabSpeed = horsesTabSpeedFunction(horsesNumber);// tableau initialisation vitesse a zero
		
		for( int speed : tabSpeed )
		{
			if(tour == 0 && lancerDes == 1)
			{
				speed += 0;
			}
			else if ( tour == 0 && (lancerDes == 2 ||lancerDes == 3 || lancerDes == 4))
			{
				speed += 1;
			}
		}
		return tabSpeed;
	}
}
