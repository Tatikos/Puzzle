/*
* Author: Giorgos Fotiou
* Written: 27/10/2023
* Last updated: 30/10/2023
*
* Compilation command: javac -cp \eclipse-workspace\zaza\Lib\stdlib.jar NPuzzleLib.java
* Execution command: 
*
*This program is a puzzle that you can play and solve it by yourself or you can choose the option of the computer playing it
*and trying to solve it.
* 
*
*/
import java.util.Arrays;
import java.util.Scanner;
import java.text.DecimalFormat;
public class NPuzzleLib {
		//shuffles puzzle choosing randomly the valid moves.
		public static void ShufflePuzzle(int k,int x,int y,int N,int[][] puzzle) {
			int temp =0,counter=0;
			float timi;
			boolean[] moves;
			moves = new boolean[4];
			//Assings index of zero at x and y.
			for(int z=0; z<N; z++) {
				for(int u=0; u<N; u++) {
					if(puzzle[z][u]==0) {
						x=z;
						y=u;
						break;
					}
				}
			}
			//shuffling k times provided by user.
			for(int i=0; i<k; i++) {
				//initializing moves array.
				for(int r=0; r<4; r++) {
					moves[r] = false;
				}
				counter = 0;
				timi = (float) Math.random();
				temp = puzzle[x][y];
				//checks which moves are valid
				if(y-1>=0 && y-1<N) {
					moves[0] = true;
					counter++;
				}
				if(x-1>=0 && x-1<N) {
					moves[1] = true;
					counter++;
				}
				if(y+1>0 && y+1<N) {
					moves[2] = true;
					counter++;
				}
				if(x+1>0 && x+1<N) {
					moves[3] = true;
					counter++;
				}
				//counter implicates how many moves are valid and the variable timi splits according to counter and chooses
				//randomly a valid move.
				if(counter == 4) {
					if(timi>=0 && timi<=0.25) {
						puzzle[x][y] = puzzle[x][y-1];
						puzzle[x][y-1] = temp;
						y--;
					}
					else if(timi>0.25 && timi<=0.5) {
						puzzle[x][y] = puzzle[x-1][y];
						puzzle[x-1][y] = temp;
						x--;
					}
					else if(timi>0.5 && timi<=0.75) {
						puzzle[x][y] = puzzle[x][y+1];
						puzzle[x][y+1] = temp;
						y++;
					}
					else {
						puzzle[x][y] = puzzle[x+1][y];
						puzzle[x+1][y] = temp;
						x++;
					}
				}
				else if(counter == 3) {
					if(moves[0] == false) {
						if(timi>=0 && timi<=0.33) {
							puzzle[x][y] = puzzle[x-1][y];
							puzzle[x-1][y] = temp;
							x--;
						}
						else if(timi>0.33 && timi<=0.66) {
							puzzle[x][y] = puzzle[x][y+1];
							puzzle[x][y+1] = temp;
							y++;
						}
						else {
							puzzle[x][y] = puzzle[x+1][y];
							puzzle[x+1][y] = temp;
							x++;
						}
					}
					else if(moves[1] == false) {
						if(timi>=0 && timi<=0.33) {
							puzzle[x][y] = puzzle[x][y-1];
							puzzle[x][y-1] = temp;
							y--;
						}
						else if(timi>0.33 && timi<=0.66) {
							puzzle[x][y] = puzzle[x][y+1];
							puzzle[x][y+1] = temp;
							y++;
						}
						else {
							puzzle[x][y] = puzzle[x+1][y];
							puzzle[x+1][y] = temp;
							x++;
						}
					}
					else if(moves[2] == false) {
						if(timi>=0 && timi<=0.33) {
							puzzle[x][y] = puzzle[x][y-1];
							puzzle[x][y-1] = temp;
							y--;
						}
						else if(timi>0.33 && timi<=0.66) {
							puzzle[x][y] = puzzle[x-1][y];
							puzzle[x-1][y] = temp;
							x--;
						}
						else {
							puzzle[x][y] = puzzle[x+1][y];
							puzzle[x+1][y] = temp;
							x++;
						}
					}
					else if(moves[3] == false) {
						if(timi>=0 && timi<=0.33) {
							puzzle[x][y] = puzzle[x][y-1];
							puzzle[x][y-1] = temp;
							y--;
						}
						else if(timi>0.33 && timi<=0.66) {
							puzzle[x][y] = puzzle[x-1][y];
							puzzle[x-1][y] = temp;
							x--;
						}
						else {
							puzzle[x][y] = puzzle[x][y+1];
							puzzle[x][y+1] = temp;
							y++;
						}
					}
					
					
					
				}
				else if(counter == 2) {
					if(moves[3] == true && moves[2] == true) {
						if(timi>=0 && timi<=0.5) {
							puzzle[x][y] = puzzle[x][y+1];
							puzzle[x][y+1] = temp;
							y++;
						}
						else {
							puzzle[x][y] = puzzle[x+1][y];
							puzzle[x+1][y] = temp;
						 x++;
						}
					}
					else if(moves[1] == true && moves[2] == true) {
						if(timi>=0 && timi<=0.5) {
							puzzle[x][y] = puzzle[x-1][y];
							puzzle[x-1][y] = temp;
							x--;
						}
						else {
							puzzle[x][y] = puzzle[x][y+1];
							puzzle[x][y+1] = temp;
							y++;
						}
				}
					else if(moves[0] == true && moves[3] == true) {
						if(timi>=0 && timi<=0.5) {
							puzzle[x][y] = puzzle[x][y-1];
							puzzle[x][y-1] = temp;
							y--;
						}
						else {
							puzzle[x][y] = puzzle[x+1][y];
							puzzle[x+1][y] = temp;
						 x++;
						}
				}
					else if(moves[0] == true && moves[1] == true) {
						if(timi>=0 && timi<=0.5) {
							puzzle[x][y] = puzzle[x][y-1];
							puzzle[x][y-1] = temp;
							y--;
						}
						else {
							puzzle[x][y] = puzzle[x-1][y];
							puzzle[x-1][y] = temp;
						 x--;
						}
				}
					
				}
				
		}
		}
		//returns and saves i from Automatic_play function to the variable index 
		private static int index = 0;
		//Automatic_play function is the shuffle function with minor changes so the computer can check if the puzzle is solved.
		public static boolean Automatic_play(int q,int x,int y,int N,int[][] puzzle,int[][] start) {
			int temp =0,counter=0;
			float timi;
			boolean[] moves;
			moves = new boolean[4];
			
			for(int z=0; z<N; z++) {
				for(int u=0; u<N; u++) {
					if(puzzle[z][u]==0) {
						x=z;
						y=u;
						break;
					}
				}
			}
			
			for(int i=0; i<q; i++) {
				for(int r=0; r<4; r++) {
					moves[r] = false;
				}
				counter = 0;
				timi = (float) Math.random();
				temp = puzzle[x][y];
				if(y-1>=0 && y-1<N) {
					moves[0] = true;
					counter++;
				}
				if(x-1>=0 && x-1<N) {
					moves[1] = true;
					counter++;
				}
				if(y+1>0 && y+1<N) {
					moves[2] = true;
					counter++;
				}
				if(x+1>0 && x+1<N) {
					moves[3] = true;
					counter++;
				}
				if(counter == 4) {
					if(timi>=0 && timi<=0.25) {
						puzzle[x][y] = puzzle[x][y-1];
						puzzle[x][y-1] = temp;
						y--;
					}
					else if(timi>0.25 && timi<=0.5) {
						puzzle[x][y] = puzzle[x-1][y];
						puzzle[x-1][y] = temp;
						x--;
					}
					else if(timi>0.5 && timi<=0.75) {
						puzzle[x][y] = puzzle[x][y+1];
						puzzle[x][y+1] = temp;
						y++;
					}
					else {
						puzzle[x][y] = puzzle[x+1][y];
						puzzle[x+1][y] = temp;
						x++;
					}
				}
				else if(counter == 3) {
					if(moves[0] == false) {
						if(timi>=0 && timi<=0.33) {
							puzzle[x][y] = puzzle[x-1][y];
							puzzle[x-1][y] = temp;
							x--;
						}
						else if(timi>0.33 && timi<=0.66) {
							puzzle[x][y] = puzzle[x][y+1];
							puzzle[x][y+1] = temp;
							y++;
						}
						else {
							puzzle[x][y] = puzzle[x+1][y];
							puzzle[x+1][y] = temp;
							x++;
						}
					}
					else if(moves[1] == false) {
						if(timi>=0 && timi<=0.33) {
							puzzle[x][y] = puzzle[x][y-1];
							puzzle[x][y-1] = temp;
							y--;
						}
						else if(timi>0.33 && timi<=0.66) {
							puzzle[x][y] = puzzle[x][y+1];
							puzzle[x][y+1] = temp;
						 y++;
						}
						else {
							puzzle[x][y] = puzzle[x+1][y];
							puzzle[x+1][y] = temp;
							x++;
						}
					}
					else if(moves[2] == false) {
						if(timi>=0 && timi<=0.33) {
							puzzle[x][y] = puzzle[x][y-1];
							puzzle[x][y-1] = temp;
							y--;
						}
						else if(timi>0.33 && timi<=0.66) {
							puzzle[x][y] = puzzle[x-1][y];
							puzzle[x-1][y] = temp;
							x--;
						}
						else {
							puzzle[x][y] = puzzle[x+1][y];
							puzzle[x+1][y] = temp;
							x++;
						}
					}
					else if(moves[3] == false) {
						if(timi>=0 && timi<=0.33) {
							puzzle[x][y] = puzzle[x][y-1];
							puzzle[x][y-1] = temp;
							y--;
						}
						else if(timi>0.33 && timi<=0.66) {
							puzzle[x][y] = puzzle[x-1][y];
							puzzle[x-1][y] = temp;
							x--;
						}
						else {
							puzzle[x][y] = puzzle[x][y+1];
							puzzle[x][y+1] = temp;
							y++;
						}
					}
					
					
					
				}
				else if(counter == 2) {
					if(moves[3] == true && moves[2] == true) {
						if(timi>=0 && timi<=0.5) {
							puzzle[x][y] = puzzle[x][y+1];
							puzzle[x][y+1] = temp;
							y++;
						}
						else {
							puzzle[x][y] = puzzle[x+1][y];
							puzzle[x+1][y] = temp;
						 x++;
						}
					}
					else if(moves[1] == true && moves[2] == true) {
						if(timi>=0 && timi<=0.5) {
							puzzle[x][y] = puzzle[x-1][y];
							puzzle[x-1][y] = temp;
							x--;
						}
						else {
							puzzle[x][y] = puzzle[x][y+1];
							puzzle[x][y+1] = temp;
						 y++;
						}
				}
					else if(moves[0] == true && moves[3] == true) {
						if(timi>=0 && timi<=0.5) {
							puzzle[x][y] = puzzle[x][y-1];
							puzzle[x][y-1] = temp;
							y--;
						}
						else {
							puzzle[x][y] = puzzle[x+1][y];
							puzzle[x+1][y] = temp;
						 x++;
						}
				}
					else if(moves[0] == true && moves[1] == true) {
						if(timi>=0 && timi<=0.5) {
							puzzle[x][y] = puzzle[x][y-1];
							puzzle[x][y-1] = temp;
							y--;
						}
						else {
							puzzle[x][y] = puzzle[x-1][y];
							puzzle[x-1][y] = temp;
						 x--;
						}
				}
					
				}
				//checks if the puzzle is solved and return the moves it made to solve it and true statement
				//so we can know how many times it won.
				if(issolution(puzzle,start) == true) {
					index = i;
					return true;
				}
		}
			return false;
		}
		//Displays puzzle with stddraw graphics.
		public static void Displaypuzzlegraph(int[][] array,int N) {
            StdDraw.setCanvasSize(800, 800);
            StdDraw.setXscale(0, N);
            StdDraw.setYscale(0, N);
            StdDraw.clear(StdDraw.MAGENTA);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int num = array[i][j];
                    //converts int to string so it can get printed.
                    String text = Integer.toString(num);

          
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledRectangle(j + 0.5, N - i - 0.5, 0.4, 0.4);

        
                    StdDraw.setPenColor(StdDraw.WHITE);
                    //printing on the center of the rectangle the num.
                    StdDraw.text(j + 0.5, N - i - 0.5, text);
                }
            }
			
		}
		//displays puzzle with text based graphics.
		public static void Displaypuzzle(int[][] puzzle,int N) {
			int i,j;
			for(i=0; i<N; i++) {
				System.out.print("+");
				for(j=0; j<puzzle[i].length;j++) {
				System.out.print("-----+");
				}
				System.out.println();
			
			for(j=0; j<N; j++) {
				System.out.print("|");
				if(puzzle[i][j]==0) {
					System.out.print("  0"+" "+" ");
				}
				else {
					System.out.printf("%3d  ", puzzle[i][j]);
				}
			}
			System.out.println("|");
			}
			System.out.print("+");
			for(j=0; j<N; j++) {
				System.out.print("-----+");
			}
			System.out.println();
		
		}
		//checks if two 2d arrays are equal.
		public static boolean issolution(int[][] shuffled, int[][] start) {
			if(!Arrays.deepEquals(start, shuffled))
				return false;
			else
				return true;
		}
		//gets input from user.
		public static char getUserCommand() {
			Scanner Scanner = new Scanner(System.in);
			char userinput = Scanner.next().charAt(0);
			return userinput;
		}
		//this function allows user to play the game and solve the puzzle on his own.
		public static void Play(int x,int y,int N,int[][] shuffled, int[][] start,int d) {
			char input;
			boolean[] moves;
			moves = new boolean[4];
			int i=1,temp =0;
			boolean check = true;
			Scanner Scanner = new Scanner(System.in);
			
			// Display controls information once at the start
			if(d==1) {
				System.out.println("Game Controls:");
				System.out.println("u = Move empty space up");
				System.out.println("d = Move empty space down");
				System.out.println("l = Move empty space left");
				System.out.println("r = Move empty space right");
				System.out.println("e = Exit game");
				System.out.println("********************************");
			}
			
			//saves index of 0.
			for(int h=0; h<N; h++) {
				for(int v=0; v<N; v++) {
					if(shuffled[h][v]== 0) {
						x=h;
						y=v;
					}
				}
			}
			while(issolution(shuffled,start) == false) {
				String prwto = "st",deutero = "nd", trito = "rd", allo = "th";
				if(i == 1) {
					System.out.print("Enter your "+i+prwto+" move (u/d/l/r/e): ");
				}
				else if(i == 2) {
					System.out.print("Enter your "+i+deutero+" move (u/d/l/r/e): ");
				}
				else if(i == 3) {
					System.out.print("Enter your "+i+trito+" move (u/d/l/r/e): ");
				}
				else
					System.out.print("Enter your "+i+allo+" move (u/d/l/r/e): ");
				input = getUserCommand();
				//checks input.
				while(!(input == 'd'|| input == 'r' || input == 'l' || input == 'u' || input == 'e')) {
					System.out.println("Invalid input! Please use: u (up), d (down), l (left), r (right), or e (exit)");
					System.out.print("Enter your move: ");
					input = getUserCommand();
				}
				System.out.println("********************************");
				temp = shuffled[x][y];
				//checks moves
				for(int r=0; r<4; r++) {
					moves[r] = false;
				}
				if(y-1>=0 && y-1<N) {
					moves[0] = true;
				}
				if(x-1>=0 && x-1<N) {
					moves[1] = true;
				}
				if(y+1>0 && y+1<N) {
					moves[2] = true;
				}
				if(x+1>0 && x+1<N) {
					moves[3] = true;
				}
				 do{
					 check = true;
				//depending on the user's input if it is a valid one it will make one left,up,right or down.
				//d-->down, l-->left, u-->up, r--> right.
				//if move is not valid prints a message.
				if(input == 'd') {
					if(moves[3] == true) {
					shuffled[x][y] = shuffled[x+1][y];
					shuffled[x+1][y] = temp;
					x++;
					}
					else if((moves[3] == false)) {
						System.out.println("You are not allowed to go down");
						check = false;
					}
			}
				else if(input == 'u') {
					if(moves[1] == true) {
					shuffled[x][y] = shuffled[x-1][y];
					shuffled[x-1][y] = temp;
					x--;
					}
					else if(moves[1] == false) {
						System.out.println("You are not allowed to go up");
						check = false;
					}
				}
				else if(input == 'l') {
					if(moves[0] == true) {
					shuffled[x][y] = shuffled[x][y-1];
					shuffled[x][y-1] = temp;
					y--;
					}
					else if(moves[0] == false) {
						System.out.println("You are not allowed to go left");
						check = false;
					}
				}
				else if(input == 'r') {
					if(moves[2] == true) {
					shuffled[x][y] = shuffled[x][y+1];
					shuffled[x][y+1] = temp;
					y++;
					}
					else if(moves[2] == false) {
						System.out.println("You are not allowed to go right");	
						check = false;
					}
					}
				else if(input == 'e') {
					System.exit(0);
				}
				//if move is not valid user has to give a valid move input
				if(!check) {
					input = Scanner.next().charAt(0);
				}
				}while(check == false);
				 //depending on what user chose it will print the puzzle on text based graphics or stddraw graphics.
				if(d==1)
				Displaypuzzle(shuffled,N);
				else
					Displaypuzzlegraph(shuffled,N);
				i++;	
			}
			Scanner.close();
			if(d==1)
			System.out.println("Congragulations!,Puzzle solved!!");
			else {
				StdDraw.clear();		
				StdDraw.setCanvasSize(700,700);
				StdDraw.setXscale(0, 1);
				StdDraw.setYscale(0, 1);
				StdDraw.picture(0.5, 0.5, "meow.jpg", 0.8, 0.6);
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.text(0.5, 0.7, "Congragulations!,Puzzle solved!!");
				StdDraw.show();
			}
			
		}
		//initializes initial array
		static int[][] initialize(int[][] array){
			int[][] zazaou = new int[array.length][array.length];
			for(int i=0; i<array.length; i++) {
				for(int j=0; j<array.length; j++) {
					zazaou[i][j] = array[i][j];
				}
			}
			return zazaou;
		}

		
		static void Menu(int k,int N,int[][] array,int d) {
		Scanner Scanner = new Scanner(System.in);
		int grade = 0,grademin=0,grademax=0,x=0,y=0,p=0,q=0,pl=0,kiniseis = 0,wow =0;
		DecimalFormat dekadika = new DecimalFormat("0.00");
		boolean checking = false;
		float za = 0,zaza = 0;
		int[][]start = new int[N][N];
		int[][] jenourko = new int[N][N];
		//saves solved puzzle into a different array.
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				start[i][j] = array[i][j];
			}
		}
		//prints menu in text based graphics or stddraw graphics.
		if(d==1) {
		System.out.println("+-------------------------------+");
		System.out.print("| 1. Intaractive play		|\n| 2. Automatic play		|\n| 3. Exit 			|\n");
		System.out.println("+-------------------------------+");
		System.out.print("Choose option: ");
		k = Scanner.nextInt();
		System.out.println("********************************");
		while(k<=0 || k>3) {
			System.out.println("wrong input\ngive a valid input");
			k = Scanner.nextInt();
		}
		}
		else {
			StdDraw.setCanvasSize(700,700);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledSquare(0.5, 0.5, 0.5);
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.text(0.5, 0.6, "1. Interactive play");
			StdDraw.text(0.5, 0.55, "2. Automatic play");
			StdDraw.text(0.5, 0.5, "3. Exit");
			StdDraw.show();
			k = Scanner.nextInt();
			
			while(k<=0 || k>3) {
				StdDraw.text(0.5, 0.3, "wrong input\\ngive a valid input");
				StdDraw.show();
				k = Scanner.nextInt();
			}
			
		}
		//if interactive play is chosen then the user can play the puzzle depending on what graphics he chose.
		if(k==1) {
			//prints text based.
			if(d==1) {
			System.out.println("Interactive Play Mode Selected");
			System.out.println("Difficulty level determines how many random moves will shuffle the puzzle.");
			System.out.println("Higher numbers = more difficult puzzles");
			System.out.print("Enter difficulty level (0 or higher): ");
			grade = Scanner.nextInt();
			while(grade<0) {
				System.out.println("Invalid input! Difficulty must be 0 or higher.");
				System.out.print("Enter difficulty level: ");
				grade = Scanner.nextInt();
			
			}
			//calls shufflepuzzle function shuffles it, then calls Displaypuzzle so it can print it and then calls play fucntion
			//so the user can start trying to solve the puzzle.
			ShufflePuzzle(grade,x,y,N,array);
			Displaypuzzle(array,N);
			Play(x,y,N,array,start,d);
			}
			//does the same thing as above but in stddraw graphics.
			else {
				StdDraw.clear();
				StdDraw.setCanvasSize(700,700);
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledSquare(0.5, 0.5, 0.5);
				StdDraw.setPenColor(StdDraw.GREEN);
				StdDraw.text(0.5, 0.65, "Interactive Play Mode");
				StdDraw.text(0.5, 0.6, "Enter difficulty level (0 or higher):");
				StdDraw.show();
				grade = Scanner.nextInt();
				while(grade<0) {
					StdDraw.clear();
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledSquare(0.5, 0.5, 0.5);
					StdDraw.setPenColor(StdDraw.GREEN);
					StdDraw.text(0.5, 0.6, "Invalid! Enter difficulty level (0+):");
					StdDraw.show();
					grade = Scanner.nextInt();
				
				}
				ShufflePuzzle(grade,x,y,N,array);
				Displaypuzzlegraph(array,N);
				Play(x,y,N,array,start,d);
			}
		}
		//engages in the if statement if automatic play is chosen. 
		else if(k==2) {
			//prints text based graphics
			if(d==1) {
			System.out.println("Automatic Play Mode Selected");
			System.out.println("The computer will attempt to solve puzzles automatically.");
			System.out.println();
			System.out.println("Parameter explanations:");
			System.out.println("kmin: Minimum difficulty level (number of shuffle moves)");
			System.out.println("kmax: Maximum difficulty level (number of shuffle moves)");
			System.out.println("p: Number of attempts per difficulty level");
			System.out.println("q: Maximum moves per attempt");
			System.out.println();
			System.out.print("Enter minimum difficulty (kmin): ");
			grademin = Scanner.nextInt();
			System.out.print("Enter maximum difficulty (kmax): ");
			grademax = Scanner.nextInt();
			System.out.print("Enter number of attempts per level (p): ");
			p = Scanner.nextInt();
			System.out.print("Enter maximum moves per attempt (q): ");
			q = Scanner.nextInt();
			while(grademin<0 || grademax<0 || grademin>grademax) {
				System.out.println("Invalid input! Requirements:");
				System.out.println("- kmin and kmax must be >= 0");
				System.out.println("- kmax must be >= kmin");
				System.out.print("Enter minimum difficulty (kmin): ");
				grademin = Scanner.nextInt();
				System.out.print("Enter maximum difficulty (kmax): ");
				grademax = Scanner.nextInt();
		}
			}
			//prints stddraw graphics.
			else {
				StdDraw.clear();
				StdDraw.setCanvasSize(700,700);
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.filledSquare(0.5, 0.5, 0.5);
				StdDraw.setPenColor(StdDraw.GREEN);
				StdDraw.text(0.5, 0.7, "Automatic Play Mode");
				StdDraw.text(0.5, 0.65, "Enter minimum difficulty (kmin):");
				StdDraw.show();
				grademin = Scanner.nextInt();
				StdDraw.text(0.5, 0.6, "Enter maximum difficulty (kmax):");
				StdDraw.show();
				grademax = Scanner.nextInt();
				StdDraw.text(0.5, 0.55, "Enter attempts per level (p):");
				StdDraw.show();
				p = Scanner.nextInt();
				StdDraw.text(0.5, 0.5, "Enter max moves per attempt (q):");
				StdDraw.show();
				q = Scanner.nextInt();
				while(grademin<0 || grademax<0 || grademin>grademax) {
					StdDraw.clear();
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.filledSquare(0.5, 0.5, 0.5);
					StdDraw.setPenColor(StdDraw.GREEN);
					StdDraw.text(0.5, 0.6, "Invalid input! Check requirements");
					StdDraw.text(0.5, 0.55, "Enter minimum difficulty (kmin):");
					StdDraw.show();
					grademin = Scanner.nextInt();
					StdDraw.text(0.5, 0.5, "Enter maximum difficulty (kmax):");
					StdDraw.show();
					grademax = Scanner.nextInt();
			}
				
			
			StdDraw.clear();
			StdDraw.setCanvasSize(700,700);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledSquare(0.5, 0.5, 0.5);
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.text(0.5, 0.8, "Running automatic solver...");
			StdDraw.show();
			}
			double xwidth = 0.7;	
			//plays the game for different levels of difficulty.
			for(int i=grademin; i<=grademax; i++) {
				xwidth-=0.04;
				pl=0;
				wow = 0;
				kiniseis = 0;
				//for each new level it initializes the array to the solved one.
				for(int g=0; g<N; g++) {
					for(int l=0; l<N; l++) {
						array[g][l] = start [g][l];
					}
				}
				//shuffles solved puzzle by calling shufflepuzzle.
				ShufflePuzzle(i,x,y,N,array);
				//saves the shuffled puzzle into jenourko array.
				jenourko = initialize(array);
				//tries to solve the same shuffled puzzle for p times.
				for(int f=0; f<p; f++) {
				array = initialize(jenourko);
				//if array is not solved tries to solve it by calling automatic_play function.
				if(issolution(array,start) == false) {
					checking = Automatic_play(q,x,y,N,array,start);
				}
				else {
					//if puzzled is solved from the beginning pl gets the value of p and gets out of the loop.
					pl = p;
					break;
				}
				//if the puzzled is solved the wow variable gets how many moves it did to solve it and the pl variable gets how many times it was solved.
				if(checking == true) {
					wow = NPuzzleLib.index;
					pl++;
					kiniseis += wow;
					
				}
				}
				//za gets the average moves of the winning games and the variable zaza gets the percentage of successful games.
				za = (float)kiniseis/pl;
				zaza = (float)pl/p;
				//prints average moves and winning percentage on text based graphics
				if(d==1) {
				System.out.println("For difficulty k="+i+": Average moves = "+dekadika.format(za)+", Success rate = "+dekadika.format(zaza*100)+"%");
				}
				//prints average moves and winning percentage on stddraw graphics.
				else
					StdDraw.text(0.5, xwidth, "k="+i+": Avg moves = "+dekadika.format(za)+", Success = "+dekadika.format(zaza*100)+"%");
			}
		}
		else if(k==3) {
			System.exit(0);
		}
		Scanner.close();

	}

}
