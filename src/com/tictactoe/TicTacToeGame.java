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
        
		if(tic.toss())
			tic.userMove();
		else
			tic.computerMove();
		
		char a = tic.checkStatus();
		
	
		
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
			if(board[location] != ' ')
			{
				System.out.println("Entered location is already filled. Try again");
				continue;
			}
			board[location] = userChoice;
			break;
		}
	}
	
	public boolean toss()
	{
		final int HEAD = 1;
		final int TAIL = 2;
		System.out.println("Toss! \nEnter you choice \n1.HEAD \n2.TAIL");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		int result = 1 + (int) (Math.random()*10%2) ;
		System.out.println(result);
		if( choice == result)
		{
			System.out.println("You won the toss");
			return true;
		}
		else {
			System.out.println("You lost the toss");
			return false;
		}
		
	}
	
	public void userMove() {
		
	}
	
	public void computerMove() {
			
	}
	
	public char checkStatus() {
		char winner = 't';
		char arr[] = board;
		for(int row=1 , col=1; row<10 && col<4 ; row+=3, col++ )
		{
			if(arr[row] == 'X' && arr[row+1] == 'X' && arr[row+2] == 'X') {
				winner = 'X';
			}
			else if(arr[row] == 'O' && arr[row+1] == 'O' && arr[row+2] == 'O') {
				winner = 'O';
			}
			else if(arr[col] == 'X' && arr[col+3] == 'X' && arr[col+6] == 'X') {
				winner = 'X';
			}
			else if(arr[col] == 'O' && arr[col+3] == 'O' && arr[col+6] == 'O') {
				winner = 'O';
			}
		}
		for(int i=1; i<10; i++)
		{
			if(arr[i] == ' ')
				return winner;
		}
		return winner;
	}
	
	
	
}
