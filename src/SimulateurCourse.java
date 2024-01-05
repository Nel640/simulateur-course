import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class SimulateurCourse 
{
	public static void main(String[] args) 
	{
		HashMap<String , IdentityHashMap<Integer , Integer>> horseGenerateVariable = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		Boolean continueBool = true;
		
		while(continueBool)
		{
			System.out.println("combien de chevaux sont dans la course ? (12 a 20 chevaux) : ");
			int horsesNumber = scan.nextInt();
			
			horsesNumber = verificationNumberHorsesFunction(horsesNumber, scan);
			
			System.out.println("quel est le type de couse ? (tierce, quarte, quinte) : ");
			String runType = scan.next();
			
			runType = verificationTypeFunction(runType, scan);
			
			System.out.println(horseNameFunction(horsesNumber, scan));
			
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
	
	public static HashMap<String , Integer> horseNameFunction ( int horseVerif , Scanner scan)
	{
		HashMap<String , Integer> horseGenerate = new HashMap<String, Integer>();
		String[] horseName = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t"};
		int horsesNumber = verificationNumberHorsesFunction(horseVerif, scan);
		
		for(int i = 0 ; i < horsesNumber ; i++ )
		{
			horseGenerate.put(horseName[i], i+1 );
		}
		
		return horseGenerate;
		
	}
}
