import java.util.*;
import java.util.Map.Entry;

public class SimulateurCourse 
{
	public static void main(String[] args) 
	{
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("combien de chevaux sont dans la course ? (12 a 20 chevaux) : ");
		int horsesNumber = scan.nextInt();
		
		horsesNumber = verificationNumberHorsesFunction(horsesNumber, scan);//test et return horses number
		int[][] horsesInfos = new int[horsesNumber][2];// tableau 2D speed and distancia
		
		System.out.println("quel est le type de couse ? (tierce, quarte, quinte) : ");
		String runType = scan.next();
		
		runType = verificationTypeFunction(runType, scan);//test and return run type
		
		int desResult = lancerDesDes(0, 5);
		int tours = 0;
		int timer = 0;
		
		for ( int[] distanciaHorse : horsesInfos)
		{
			
				//pour chaque cheval 
				desResult = lancerDesDes(0, 5);//lance le des 
				System.out.println(desResult);
				int resultSpeed = incrementSpeedFunction(desResult, tours, horsesNumber);//incremente vitesse et distance
				int distanciaResult = incrementDistanciaFunction(horsesInfos , distanciaHorse[0]);
				distanciaHorse[0] += resultSpeed;
				distanciaHorse[1] += distanciaResult;
				tours++;
				timer += 10; 
			
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
	
	public static int lancerDesDes ( int nbMin , int nbMax)
	{
			 Random random = new Random();
			 int nb;
			 nb = random.nextInt(nbMax-nbMin)+1;
			 return nb;
	}
	
	public static int incrementSpeedFunction ( int desResult , int tours , int horsesNumber)
	{
		int speedResult = 0 ;
		
		if(desResult == 1 && (tours == 3 || tours == 4) || 
		   desResult == 2 && (tours == 5 || tours == 6))
		{
			speedResult -= 1;
		}
		else if(desResult == 1 && (tours == 5 || tours == 6 ))
		{
			speedResult -= 2;
		}
		else if (desResult == 2 && tours == 0  || 
		         desResult == 3 && (tours == 0 || tours == 1 || tours == 2)||
		         desResult == 4 && (tours == 0 || tours == 1 || tours == 2 || tours == 3) ||
		         desResult == 5 && (tours == 1 || tours == 2 || tours == 3 || tours == 4) ||
		         desResult == 6 && (tours == 3 || tours == 4 || tours == 5))
		{
			speedResult += 1 ; 
		}
		else if (desResult == 5 && tours == 0  ||
				 desResult == 6 && (tours == 0 || tours == 1 || tours == 2))
		{
			speedResult += 2;
		}
			
		return speedResult;
	}
	
	public static int incrementDistanciaFunction ( int[][] horsesInfos , int horse)
	{
		int distanciaResult = 0;
		
		HashMap<Integer, Integer> horsesDistances = new HashMap<Integer, Integer>();
		horsesDistances.put(0 , 0);
		horsesDistances.put(1 , 23);
		horsesDistances.put(2 , 46);
		horsesDistances.put(3 , 69);
		horsesDistances.put(4 , 92);
		horsesDistances.put(5 , 115);
		horsesDistances.put(6 , 138);
		
		for(Entry<Integer, Integer> entry : horsesDistances.entrySet())
		{
			if( horse == entry.getKey())
			{
				distanciaResult = entry.getValue();
				System.out.println("entry "+entry.getValue());
			}
		}
		return distanciaResult;
	}
}
