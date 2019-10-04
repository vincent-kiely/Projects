import java.util.*;
public class Xs_and_Os
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		Boolean winner = false;
		Boolean confirmedFree = false;
		String[] player = new String[] {"X","O"};
		String pattern = "[0-2]{1}", rowInput, columnInput;
		String won = " player won";
		int turn = 0, x, row, column;
		String[][] xO = new String [][] {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
		
		while(winner == false)
		{
			x = turn % 2;
			System.out.println("-------------");
			System.out.println("| " + xO[0][0] + " | " + xO[0][1] + " | " + xO[0][2] + " |");
			System.out.println("-------------");
			System.out.println("| " + xO[1][0] + " | " + xO[1][1] + " | " + xO[1][2] + " |");
			System.out.println("-------------");
			System.out.println("| " + xO[2][0] + " | " + xO[2][1] + " | " + xO[2][2] + " |");
			System.out.println("-------------");
			System.out.println("Enter a row (0, 1, or 2) for player " + player[x] + ":");
			rowInput = in.nextLine();
			if(!(rowInput.matches(pattern)))
			{
				System.out.println("The values entered are an incompatible value");
				System.exit(0);
			}
			row = Integer.parseInt(rowInput);
			System.out.println("Enter a column (0, 1, or 2) for player " + player[x] + ":");
			columnInput = in.nextLine();
			if(!(columnInput.matches(pattern)))
			{
				System.out.println("The values entered are an incompatible value");
				System.exit(0);
			}
			column = Integer.parseInt(columnInput);
			while(confirmedFree == false)
			{
				if(!(xO[row][column] == " "))
				{
					System.out.println("This spot is already used. Please enter a different spot.");
					System.out.println("Enter a row (0, 1, or 2) for player " + player[x] + ":");
					rowInput = in.nextLine();
					if(!(rowInput.matches(pattern)))
					{
						System.out.println("The values entered are an incompatible value");
						System.exit(0);
					}
					row = Integer.parseInt(rowInput);
					System.out.println("Enter a column (0, 1, or 2) for player " + player[x] + ":");
					columnInput = in.nextLine();
					if(!(columnInput.matches(pattern)))
					{
						System.out.println("The values entered are an incompatible value");
						System.exit(0);
					}
					column = Integer.parseInt(columnInput);
				}
				else
					confirmedFree = true;
			}
			System.out.println();
			confirmedFree = false;
			xO[row][column] = player[x];
			if(xO[0][0] == player[x] && xO[0][1] == player[x] && xO[0][2] == player[x])
			{
				System.out.println("-------------");
				System.out.println("| " + xO[0][0] + " | " + xO[0][1] + " | " + xO[0][2] + " |");
				System.out.println("-------------");
				System.out.println("| " + xO[1][0] + " | " + xO[1][1] + " | " + xO[1][2] + " |");
				System.out.println("-------------");
				System.out.println("| " + xO[2][0] + " | " + xO[2][1] + " | " + xO[2][2] + " |");
				System.out.println("-------------");
				System.out.println(player[x] + won);
				winner = true;
			}
			if(xO[1][0] == player[x] && xO[1][1] == player[x] && xO[1][2] == player[x])
			{
				System.out.println("-------------");
				System.out.println("| " + xO[0][0] + " | " + xO[0][1] + " | " + xO[0][2] + " |");
				System.out.println("-------------");
				System.out.println("| " + xO[1][0] + " | " + xO[1][1] + " | " + xO[1][2] + " |");
				System.out.println("-------------");
				System.out.println("| " + xO[2][0] + " | " + xO[2][1] + " | " + xO[2][2] + " |");
				System.out.println("-------------");
				System.out.println(player[x] + won);
				winner = true;
			}
			else if(xO[2][0] == player[x] && xO[2][1] == player[x] && xO[2][2] == player[x])
			{
				System.out.println("-------------");
				System.out.println("| " + xO[0][0] + " | " + xO[0][1] + " | " + xO[0][2] + " |");
				System.out.println("-------------");
				System.out.println("| " + xO[1][0] + " | " + xO[1][1] + " | " + xO[1][2] + " |");
				System.out.println("-------------");
				System.out.println("| " + xO[2][0] + " | " + xO[2][1] + " | " + xO[2][2] + " |");
				System.out.println("-------------");
				System.out.println(player[x] + won);
				winner = true;
			}
			else if(xO[0][0] == player[x] && xO[1][0] == player[x] && xO[2][0] == player[x])
			{
				System.out.println("-------------");
				System.out.println("| " + xO[0][0] + " | " + xO[0][1] + " | " + xO[0][2] + " |");
				System.out.println("-------------");
				System.out.println("| " + xO[1][0] + " | " + xO[1][1] + " | " + xO[1][2] + " |");
				System.out.println("-------------");
				System.out.println("| " + xO[2][0] + " | " + xO[2][1] + " | " + xO[2][2] + " |");
				System.out.println("-------------");
				System.out.println(player[x] + won);
				winner = true;
			}
			else if(xO[0][1] == player[x] && xO[1][1] == player[x] && xO[2][1] == player[x])
			{
				System.out.println("-------------");
				System.out.println("| " + xO[0][0] + " | " + xO[0][1] + " | " + xO[0][2] + " |");
				System.out.println("-------------");
				System.out.println("| " + xO[1][0] + " | " + xO[1][1] + " | " + xO[1][2] + " |");
				System.out.println("-------------");
				System.out.println("| " + xO[2][0] + " | " + xO[2][1] + " | " + xO[2][2] + " |");
				System.out.println("-------------");
				System.out.println(player[x] + won);
				winner = true;
			}
			else if(xO[0][2] == player[x] && xO[1][2] == player[x] && xO[2][2] == player[x])
			{
				System.out.println("-------------");
				System.out.println("| " + xO[0][0] + " | " + xO[0][1] + " | " + xO[0][2] + " |");
				System.out.println("-------------");
				System.out.println("| " + xO[1][0] + " | " + xO[1][1] + " | " + xO[1][2] + " |");
				System.out.println("-------------");
				System.out.println("| " + xO[2][0] + " | " + xO[2][1] + " | " + xO[2][2] + " |");
				System.out.println("-------------");
				System.out.println(player[x] + won);
				winner = true;
			}
			else if(xO[0][0] == player[x] && xO[1][1] == player[x] && xO[1][2] == player[x])
			{
				System.out.println("-------------");
				System.out.println("| " + xO[0][0] + " | " + xO[0][1] + " | " + xO[0][2] + " |");
				System.out.println("-------------");
				System.out.println("| " + xO[1][0] + " | " + xO[1][1] + " | " + xO[1][2] + " |");
				System.out.println("-------------");
				System.out.println("| " + xO[2][0] + " | " + xO[2][1] + " | " + xO[2][2] + " |");
				System.out.println("-------------");
				System.out.println(player[x] + won);
				winner = true;
			}
			else if(xO[0][2] == player[x] && xO[1][1] == player[x] && xO[2][0] == player[x])
			{
				System.out.println("-------------");
				System.out.println("| " + xO[0][0] + " | " + xO[0][1] + " | " + xO[0][2] + " |");
				System.out.println("-------------");
				System.out.println("| " + xO[1][0] + " | " + xO[1][1] + " | " + xO[1][2] + " |");
				System.out.println("-------------");
				System.out.println("| " + xO[2][0] + " | " + xO[2][1] + " | " + xO[2][2] + " |");
				System.out.println("-------------");
				System.out.println(player[x] + won);
				winner = true;
			}
			turn++;
		}
	}
}