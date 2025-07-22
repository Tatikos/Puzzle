/*
* Author: Giorgos Fotiou
* Written: 27/10/2023
* Last updated: 30/10/2023
*
* Compilation command: javac -cp \eclipse-workspace\zaza\Lib\stdlib.jar NPuzzle.java
* Execution command: java -cp \eclipse-workspace\zaza\Lib\stdlib.jar NPuzzle N d
*
*This program is a puzzle that you can play and solve it by yourself or you can choose the option of the computer playing it
*and trying to solve it.
* 
*
*/

import java.util.Scanner;

public class NPuzzle{
	public static void main(String[] args) {	//calls main function from library of the puzzle
		@SuppressWarnings("resource")
		Scanner Scanner = new Scanner(System.in);
		
		// Check if correct number of arguments provided
		if(args.length < 2) {
			System.out.println("Usage: java NPuzzle N d");
			System.out.println("N: Puzzle size (creates an N×N grid)");
			System.out.println("d: Display mode (0=exit, 1=text graphics, 2=StdDraw graphics)");
			System.exit(1);
		}
		
		//gets as program parameters variables N(puzzle width) and d(graphics).
		int N = Integer.parseInt(args[0]);
		int d = Integer.parseInt(args[1]);
		int k = 0,r,a=1;
		//checks if d has right value.
		while(d<0 || d>2) {
			System.out.println("Invalid display mode! Please enter:");
			System.out.println("0 = Exit program");
			System.out.println("1 = Text-based graphics");
			System.out.println("2 = StdDraw graphics");
			System.out.print("Enter display mode (0-2): ");
			d = Scanner.nextInt();
		}
		if(d == 0)
			System.exit(0);
		//checks if N has right value.
		while(N<1) {
			System.out.println("Invalid puzzle size! N must be at least 1.");
			System.out.print("Enter puzzle size N (creates N×N grid): ");
			N = Scanner.nextInt();
		}
		int[][] array;
		array = new int[N][N];
		int[] second = new int[N*N];
		for(r=0; r<N*N-1; r++) {
			second[r]=a;
			a++;
		}
		r=0;
		//assings into the array the solved puzzle.
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				array[i][j] = second[r];
				r++;
			}
				
		}
		//calls function menu from NPuzzleLib .
		NPuzzleLib.Menu(k,N,array,d);
		Scanner.close();
	}
}
