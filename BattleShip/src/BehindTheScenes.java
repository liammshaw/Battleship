import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;
public class BehindTheScenes
	{
		static ArrayList<BattleShip> ships = new ArrayList<BattleShip>();
		static String name;
		static int[][] enemysBattlefield;
		static int[][] battlefield;
		static int level;
		static Scanner userString = new Scanner(System.in);
		static Scanner userInt = new Scanner(System.in);
		static int row;
		static int col;
		static int firstRow;
		static int secondRow;
		static boolean continueGuessing;
		static int rowSum;
		static int userRow;
		static int userCol;
		static int computerRow;
		static int computerCol;
		static int enemysSum;
		static int userSum;
		
		public static void generateRandomShips()
			{
				// generate longest ship 
				row = (int) (Math.random() * battlefield.length);
				firstRow = row;
				ships.get(3).setRow(row);
				int start = battlefield[row].length - ships.get(3).getSize();
				col = (int) (Math.random() * start);
				for(int i = 0; i < ships.get(0).getSize(); i++)
					{
						enemysBattlefield[row][col] = 1;
						col++;
					}
				
				// generate medium ship
				boolean run = true;
				do 
					{
						row = (int) (Math.random() * battlefield.length);
						if (row != firstRow)
							{
								secondRow = row; 
								start = battlefield[row].length - ships.get(4).getSize();
								ships.get(4).setRow(row);
								col = (int) (Math.random() * start);
								for(int i = 0; i < ships.get(1).getSize(); i++)
									{
										enemysBattlefield[row][col] = 1;
										col++;
									}
								run = false;
							}
						else 
							{
								run = true; 
							}
					} while (run == true);
				
				run = true;
				do 
					{
						row = (int) (Math.random() * battlefield.length);
						if (row != firstRow && row != secondRow)
							{
								start = battlefield[row].length - ships.get(5).getSize();
								ships.get(5).setRow(row);
								col = (int) (Math.random() * start);
								for(int i = 0; i < ships.get(2).getSize(); i++)
									{
										enemysBattlefield[row][col] = 1;
										col++;
									}
								run = false;
							}
						else 
							{
								run = true; 
							}
					} while (run == true);
				
			}
		public static void promptUser()
			{
				System.out.println("Enter your name");
				name = userString.nextLine();
				System.out.println("Welcome " + name + " to BattleShip");
				System.out.println("There are 3 levels. Easy is a 5 by 5 grid with 3 ships.");
				System.out.println("Medium is a 7 by 7 grid with 3 ships. Hard is a 10 by 10 grid with 3 ships");
				System.out.println("Easy (1), Medium (2), Hard (3)");
				level = userInt.nextInt();
				if (level == 1)
					{
						easy();
						nameShips();
						generateRandomShips();
						placeShips();
						do 
							{
								userGuess();
								evaluateGuess();
								computerGuesses();
								evaluateComputerGuess();
								checkForOnes();
							}while(continueGuessing == true);	
						finishGame();
					}
				else if (level == 2)
					{
						medium();
						nameShips();
						generateRandomShips();
						placeShips();
						do 
							{
								userGuess();
								evaluateGuess();
								computerGuesses();
								evaluateComputerGuess();
								checkForOnes();
							}while(continueGuessing == true);	
						finishGame();
					}
				else 
					{
						hard();
						nameShips();
						generateRandomShips();
						placeShips();
						do 
							{
								userGuess();
								evaluateGuess();
								computerGuesses();
								evaluateComputerGuess();
								checkForOnes();
							}while(continueGuessing == true);	
						finishGame();
					}
			}
		public static void easy()
			{
				ships.add(new BattleShip(4, "1",0));
				ships.add(new BattleShip(3, "2",0));
				ships.add(new BattleShip(2, "3",0));
				ships.add(new BattleShip(4, "computer's aircraft carrier", 0));
				ships.add(new BattleShip(3, "computer's battleship", 0));
				ships.add(new BattleShip(2, "computer's destroyer", 0));
				battlefield = new int [5][5];
				enemysBattlefield = new int [5][5];
			}
		public static void medium()
			{
				battlefield = new int [7][7];
				enemysBattlefield = new int [7][7];
				ships.add(new BattleShip(4, "1",0));
				ships.add(new BattleShip(3, "2",0));
				ships.add(new BattleShip(2, "3",0));
				ships.add(new BattleShip(4, "computer's aircraft carrier", 0));
				ships.add(new BattleShip(3, "computer's battleship", 0));
				ships.add(new BattleShip(2, "computer's destroyer", 0));
			}
		public static void hard()
			{
				battlefield = new int [10][10];
				enemysBattlefield = new int [10][10];
				ships.add(new BattleShip(4, "1",0));
				ships.add(new BattleShip(3, "2",0));
				ships.add(new BattleShip(2, "3",0));
				ships.add(new BattleShip(4, "computer's aircraft carrier", 0));
				ships.add(new BattleShip(3, "computer's battleship", 0));
				ships.add(new BattleShip(2, "computer's destroyer", 0));
			}
		public static void nameShips()
			{
				System.out.println("It's time name your ships");
				System.out.println("What would you like to name your aircraft carrier?(size 4)");
				String name = userString.nextLine();
				ships.get(0).setName(name);
				System.out.println("What would you like to name your battleship?(size 3)");
				name = userString.nextLine();
				ships.get(1).setName(name);
				System.out.println("What would you like to name your destroyer?(size 2)");
				name = userString.nextLine();
				ships.get(2).setName(name);
			}
		public static void placeShips()
			{
				System.out.println("This is the battlefield");
				for (int r = 0; r < battlefield.length; r++)
					{
						for (int c = 0; c < battlefield.length; c++)
							{
								System.out.print(battlefield[r][c] + " ");
							}
						System.out.println("");
					}
				System.out.println("Please put your ships together");
				for (int i = 0; i < 1; i++)
					{
						System.out.println("Which row would you like to place "+ships.get(0).getName()+ "?");
						row = userInt.nextInt() -1; 
						ships.get(0).setRow(row);
						for( int x = 0; x < ships.get(0).getSize(); x++) 
							{
								System.out.println("Which column would you like to place " + ships.get(0).getName() + "?");
								col = userInt.nextInt()-1;
								battlefield[row][col] = 1;
							}
					}
				printBattlefield();
				System.out.println("");
				for (int i = 0; i< 1; i++)
					{
						System.out.println("Which row would you like to place "+ships.get(1).getName()+ "?");
						ships.get(1).setRow(row);
						row = userInt.nextInt() -1; 
						for( int x = 0; x < ships.get(1).getSize(); x++) 
							{
								System.out.println("Which column would you like to place " + ships.get(1).getName() + "?");
								col = userInt.nextInt()-1;
								battlefield[row][col] = 1;
							}
					}
				printBattlefield();
				System.out.println("");
				for (int i = 0; i< 1; i++)
					{
						System.out.println("Which row would you like to place "+ships.get(2).getName()+ "?");
						row = userInt.nextInt() -1; 
						ships.get(2).setRow(row);
						for( int x = 0; x < ships.get(2).getSize(); x++) 
							{
								System.out.println("Which column would you like to place " + ships.get(2).getName() + "?");
								col = userInt.nextInt()-1;
								battlefield[row][col] = 1;
							}
					}
				for (int r = 0; r < battlefield.length; r++)
					{
						for (int c = 0; c < battlefield.length; c++)
							{
								System.out.print(battlefield[r][c] + " ");
							}
						System.out.println("");
					}
				System.out.println("Is this how you wanted to lay out your ships? (1 represents a ship)");
			}
		public static void computerGuesses()
			{
				computerRow = (int) (Math.random() * battlefield.length);
				computerCol = (int) (Math.random() * battlefield[row].length);
			}
		public static void userGuess()
			{
				System.out.println("What row would you like to guess?");
				userRow = userInt.nextInt()-1;
				System.out.println("What column would you like to guess?");
				userCol = userInt.nextInt()-1;
			}
		public static void printBattlefield()
			{
				for (int r = 0; r < battlefield.length; r++)
					{
						for (int c = 0; c < battlefield.length; c++)
							{
								System.out.print(battlefield[r][c] + " ");
							}
						System.out.println("");
					}
			}
		public static void printEnemysBattlefield()
			{
				for (int r = 0; r < enemysBattlefield.length; r++)
					{
						for (int c = 0; c < enemysBattlefield.length; c++)
							{
								System.out.print(enemysBattlefield[r][c] + " ");
							}
						System.out.println("");
					}
			}
		public static void evaluateGuess()
			{
				if(enemysBattlefield[userRow][userCol] == 1)
					{
						rowSum = 0;
						System.out.println("That's a hit!");
						enemysBattlefield[userRow][userCol]= 0;
						for (int i = 0; i < enemysBattlefield[userRow].length; i++)
							{
								if(enemysBattlefield[userRow][i] == 1)
									{
										rowSum += 1;
									}
							}
						if (rowSum == 0)
							{
								if (ships.get(3).getRow() == userRow)
									{
										System.out.println("You sunk " + ships.get(3).getName() + "!");
									}
								else if(ships.get(4).getRow() == userRow)
									{
										System.out.println("You sunk " + ships.get(4).getName() + "!");
									}
								else 
									{
										System.out.println("You sunk " + ships.get(5).getName()+"!");
									}
							}
					}
				else 
					{
						System.out.println("That's a miss!");
					}
			}
		public static void evaluateComputerGuess()
			{
				System.out.println("The computer guessed " + (computerRow+1) + ", " + (computerCol+1));
				if(battlefield[computerRow][computerCol] == 1)
					{
						rowSum = 0;
						System.out.println("The computer hit!");
						battlefield[computerRow][computerCol]= 0;
						for (int i = 0; i < battlefield[computerRow].length; i++)
							{
								if(battlefield[computerRow][i] == 1)
									{
										rowSum += 1;
									}
							}
						if (rowSum == 0)
							{
								if (ships.get(0).getRow() == computerRow)
									{
										System.out.println("The computer sunk " + ships.get(0).getName() + "!");
									}
								else if(ships.get(1).getRow() == computerRow)
									{
										System.out.println("the computer sunk " + ships.get(1).getName() + "!");
									}
								else 
									{
										System.out.println("the computer sunk " + ships.get(2).getName()+"!");
									}
							}
					}
				else 
					{
						System.out.println("The computer missed!");
					}
			}
		public static void checkForOnes()
			{
				enemysSum = 0;
				for (int r = 0; r < enemysBattlefield.length; r++)
					{
						for (int c = 0; c < enemysBattlefield[r].length; c++)
							{
								if(enemysBattlefield[r][c] == 1)
									{
										enemysSum += 1;
									}
							}
					}
				userSum = 0;
				for (int r = 0; r < battlefield.length; r++)
					{
						for (int c = 0; c < battlefield[r].length; c++)
							{
								if(battlefield[r][c] == 1)
									{
										userSum += 1;
									}
							}
					}
				if(enemysSum == 0 || userSum == 0)
					{
						continueGuessing = false;
					}
				else 
					{
						continueGuessing = true; 
					}
			}
		public static void finishGame()
			{
				if (continueGuessing == false && enemysSum == 0)
					{
						System.out.println("Game over you won!!");
					}
				else
					{
						System.out.println("Sorry you lost!");
					}
			}
	}
