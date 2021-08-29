package com.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

	private char[] board = new char[10];
	
	public static void main(String[] args) {
	
		System.out.println("welcome to the game");
		TicTacToeGame tic = new TicTacToeGame();
		tic.createBoard();
		tic.input();
		tic.displayBoard();
	
	}
	
	public void createBoard() {
		for(int i=1; i<board.length; i++)
			board[i] = ' ';
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the choice X or O");
		char userChoice = sc.next().charAt(0);
		char computerChoice ;
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
	
	
	
}
