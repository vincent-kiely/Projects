import java.util.*;
public class Rock_Paper_Scissors
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		String pattern = "[0-2]{1,1}", input;
		String comp0 = "The computer is scissor. ";
		String comp1 = "The computer is rock. ";
		String comp2 = "The computer is paper. ";
		String user0 = "You are scissor. ";
		String user0b = "You are scissor too. ";
		String user1 = "You are rock. ";
		String user1b = "You are rock too. ";
		String user2 = "You are paper. ";
		String user2b = "You are paper too. ";
		String won = "You won";
		String loss = "You lost";
		String draw = "It is a draw";
		int userChoice, compChoice;
		compChoice = (int) (Math.random() * 3);
		System.out.println("scissor (0), rock (1), paper (2):\t");
		input = in.nextLine();
		if(!(input.matches(pattern)))
			System.out.println("The value entered is an incompatible value");
		else
		{
			String result = "";
			userChoice = Integer.parseInt(input);
			if(compChoice == 0)
			{
				result += comp0;
				if(userChoice == 0)
					result += user0b + draw;
				else if(userChoice == 1)
					result += user1 + won;
				else
					result += user2 + loss;
				System.out.println(result);
			}
			else if(compChoice == 1)
			{
				result += comp1;
				if(userChoice == 0)
					result += user0 + loss;
				else if(userChoice == 1)
					result += user1b + draw;
				else
					result += user2 + won;
				System.out.println(result);
			}
			else
			{
				result += comp2;
				if(userChoice == 0)
					result += user0 + won;
				else if(userChoice == 1)
					result += user1 + loss;
				else
					result += user2b + draw;
				System.out.println(result);
			}
		}
	}
}