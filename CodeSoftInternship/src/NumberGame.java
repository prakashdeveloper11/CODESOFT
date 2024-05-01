import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {
		Random rand=new Random();
		Scanner s=new Scanner(System.in);
		int n=100;
		
		int finalScore=0;
		int chances=6;
		System.out.println("enter your name:");
		String name=s.next();
		
		System.out.println("welcome to number game:"+name);
		System.out.println("enter number in between 1 to 100");
		System.out.println("you have "+chances+" chances to play this game");
		boolean playGame=true;
		
		while(playGame)
		{ 
			boolean guess=false;
			int a=rand.nextInt(n);
			
			
			for(int i=0;i<chances;i++) 
			{
				System.out.println("enter the "+(i+1)+" chance");
			int guessno=s.nextInt();
			  if(guessno==a)
			      {
				  System.out.println("you won the game");
				  guess=true;
				  finalScore++;
				  break;
				  }
				  else if(guessno>a)
				  {
					  System.out.println("number is to high");
				  }
				  else  
				  {
					  System.out.println("number is to low");
				  }
			}
			if(guess==false)
			{
				System.out.println("you loss the game the number is:"+a);
			}
			System.out.println("do you want to play again enter y/n");
			String pa=s.next();
			playGame=pa.equalsIgnoreCase("y");
			
		}
		
		System.out.println("thank for playing ");
		System.out.println("your score is:"+finalScore);
	}
    
}
