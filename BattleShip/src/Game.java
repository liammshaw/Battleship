import java.util.ArrayList;
import java.util.Scanner;
public class Game
	{
		static ArrayList<BattleShip> ships = new ArrayList<BattleShip>();
		static String name;
		static int[][] battlefield;
		static int level;
		static Scanner userString = new Scanner(System.in);
		static Scanner userInt = new Scanner(System.in);
		public static void main(String[] args)
			{
				// TODO Auto-generated method stub
				promptUser();
			}
//		public static void generateRandomShips()
//			{
//			
//			}
		public static void promptUser()
			{
				System.out.println("Enter your name");
				name = userString.nextLine();
				System.out.println("Welcome " + name + " to BattleShip");
				System.out.println("Do you think you can beat me?");
				System.out.println("We'll see");
				System.out.println("There are 3 levels. Easy is a 5 by 5 grid with 3 ships.");
				System.out.println("Medium is a 7 by 7 grid with 3 ships. Hard is a 10 by 10 grid with 3 ships");
				System.out.println("Easy (1), Medium (2), Hard (3)");
				level = userInt.nextInt();
				if (level == 1)
					{
						easy();
					}
				else if (level == 2)
					{
						medium();
					}
				else 
					{
						hard();
					}
			}
		public static void easy()
			{
				ships.add(new BattleShip(4, ""));
				ships.add(new BattleShip(3, ""));
				ships.add(new BattleShip(2, ""));
				battlefield = new int [5][5];
				
			}
		public static void medium()
			{
				battlefield = new int [7][7];
			}
		public static void hard()
			{
				battlefield = new int [10][10];
			}
	}
