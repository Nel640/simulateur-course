import java.util.Scanner;

public class SimulateurCourse 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		Boolean continueBool = true;
		
		while(continueBool)
		{
			System.out.println("combien de chevaux sont dans la course ? (12 a 20 chevaux) : ");
			int horsesNumber = scan.nextInt();
			
			horsesNumber = verificationNumberHorses(horsesNumber, scan);
			
			System.out.println("quel est le type de couse ? (tierce, quarte, quinte) : ");
			String runType = scan.next();
			
			runType = verificationType(runType, scan);
			
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
	
	public static String verificationType ( String Type , Scanner scan)
	{
		while( !Type.equals("tierce") && !Type.equals("quarte") && !Type.equals("quinte"))
		{
			System.out.println("tierce , quarte ou quinte uniquement : ");
			Type = scan.next();
		}
		return Type;
	}
	
	public static int verificationNumberHorses ( int numberHorse , Scanner scan)
	{
		while(numberHorse > 20 || numberHorse < 12 )
		{
			System.out.println("nombre de chevaux entre 12 et 20 uniquement : ");
			numberHorse = scan.nextInt();
		}
		return numberHorse;
	}
}
