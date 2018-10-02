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
						nameShips();
					}
				else if (level == 2)
					{
						medium();
						nameShips();
					}
				else 
					{
						hard();
						nameShips();
					}
			}
		public static void easy()
			{
				ships.add(new BattleShip(4, "1"));
				ships.add(new BattleShip(3, "2"));
				ships.add(new BattleShip(2, "3"));
				battlefield = new int [5][5];
			}
		public static void medium()
			{
				battlefield = new int [7][7];
				ships.add(new BattleShip(4, "1"));
				ships.add(new BattleShip(3, "2"));
				ships.add(new BattleShip(2, "3"));
			}
		public static void hard()
			{
				battlefield = new int [10][10];
				ships.add(new BattleShip(4, "1"));
				ships.add(new BattleShip(3, "2"));
				ships.add(new BattleShip(2, "3"));
			}
		public static void nameShips()
			{
				System.out.println("It's time name your ships");
				System.out.println("What would you like to name your longest ship?(size 4)");
				String name = userString.nextLine();
				ships.get(0).setName(name);
				System.out.println("What would you like to name your medium sized ship?(size 3)");
				name = userString.nextLine();
				ships.get(1).setName(name);
				System.out.println("What would you like to name your shortest ship?(size 2)");
				name = userString.nextLine();
				ships.get(2).setName(name);
			}
		public static void placeShips()
			{
				
			}
	}
