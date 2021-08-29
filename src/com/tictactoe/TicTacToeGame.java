package com.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

	private char[] board = new char[10];
	static TicTacToeGame tic = new TicTacToeGame();
	private char userChoice;
	private char computerChoice;
	
	public static void main(String[] args) {
	
		System.out.println("welcome to the game");
		
		tic.createBoard();
		tic.input();
		tic.displayBoard();
        tic.selectLocation();
		tic.displayBoard();
		tic.selectLocation();
		tic.displayBoard();
	}
	
	public void createBoard() {
		for(int i=1; i<board.length; i++)
			board[i] = ' ';
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the choice X or O");
		userChoice = sc.next().charAt(0);
		if( userChoice == 'X')
		{
			computerChoice = 'O';
		}
		else if( userChoice == 'O') {
			computerChoice = 'X';
		}
		else {
			userChoice = 'X';
			computerChoice = 'O';
			System.out.println("default choice is X");
		}
		System.out.println("Your choice is " + userChoice);
		System.out.println("Computer choice is " + computerChoice);
		
	   
	}
	
	public void displayBoard(){
		
		System.out.println(board[1] +" | " +board[2]+ " | "+ board[3]);
		System.out.println("---------");
		System.out.println(board[4] +" | " +board[5]+ " | "+ board[6]);
		System.out.println("---------");
		System.out.println(board[7] +" | " +board[8]+ " | "+ board[9]);
		
	}
	
	public void selectLocation() {
		System.out.println("Enter digit in between 1-9 to selct the location");
		Scanner sc = new Scanner(System.in);
		while(true) {
			int location = sc.nextInt();
			if( location < 0 || location > 9)
			{
				System.out.println("Not a valid location. Try again");
				continue;
			}
			if(tic.board[location] != ' ')
			{
				System.out.println("Entered location is already filled");
				continue;
			}
			tic.board[location] = tic.userChoice;
			break;
		}
	}
	
	
	
}
