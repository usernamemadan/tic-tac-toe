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
        
		boolean userWonToss = tic.toss();
		char winner = 'p';
		while(winner == 'p') {
			if(userWonToss)
			{
				tic.userMove();
			}
			else {
				tic.computerMove();
			}
			tic.displayBoard();
			winner = tic.checkStatus(); 
			
			if(winner == tic.userChoice) {
				System.out.println("You won the game!..");
			}
			else if(winner ==  tic.computerChoice) {
				System.out.println("Computer won the game!..");
			}
			else if(winner == 't') {
				System.out.println("Match drawn..");
			}
			
			userWonToss = !userWonToss;	
		}
		
	
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
		System.out.println();
		
	}
	
	public void userMove() {
		System.out.println("Your Move: \nEnter digit between 1-9 to selct the location");
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
	
	public void computerMove() {
		System.out.println("\nComputer's move:");
		char[] arr = board;
		char temp = computerChoice;
		int loc = 0;
		int n = 0;
		while(n < 2) {
			for(int row=1 , col=1; row<10 && col<4 ; row+=3, col++ ) {
				if(arr[row] + arr[row+1] + arr[row+2] == temp + temp + ' ') {
					if(arr[row] == ' ')
						loc = row;
					else if(arr[row+1] == ' ')
						loc = row+1;
					else 
						loc = row+2;
					board[loc] = computerChoice;
					return;
				}
				if(arr[col] + arr[col+3] + arr[col+6] == temp + temp + ' ') {
					if(arr[col] == ' ')
						loc = col;
					else if(arr[col+3] == ' ')
						loc = col+3;
					else 
						loc = col+6;
					board[loc] = computerChoice;
					return;
				}
			}
			
			if(arr[1] + arr[5] + arr[9] ==  temp + temp + ' ') {
				
				if(arr[1] == ' ')
					loc = 1;
				else if(arr[5] == ' ')
					loc = 5;
				else
					loc = 9;
				board[loc] = computerChoice;
				return;
				
			}
			
			if(arr[3] + arr[5] + arr[7] ==  temp + temp + ' ') {
				
				if(arr[3] == ' ')
					loc = 3;
				else if(arr[5] == ' ')
					loc = 5;
				else
					loc = 7;
				board[loc] = computerChoice;
				return;
			}
			
			temp = userChoice;
			n++;
		}
		
		if(arr[1] == ' ')
			board[1] = computerChoice;
		else if(arr[3] == ' ')
			board[3] = computerChoice;
		else if(arr[7] == ' ')
			board[7] = computerChoice;
		else if(arr[9] == ' ')
			board[9] = computerChoice;
		else if(arr[5] == ' ')
			board[5] = computerChoice;
		else if(arr[2] ==  ' ')
			board[2] = computerChoice;
		else if(arr[4] ==  ' ')
			board[4] = computerChoice;
		else if(arr[6] ==  ' ')
			board[6] = computerChoice;
		else if(arr[8] ==  ' ')
			board[8] = computerChoice;
		
		
	}
	
	public char checkStatus() {
		char winner = 't';
		char arr[] = board;
		for(int row=1 , col=1; row<10 && col<4 ; row+=3, col++ )
		{
			if(arr[row] == 'X' && arr[row+1] == 'X' && arr[row+2] == 'X') {
				winner = 'X';
				break;
			}
			else if(arr[row] == 'O' && arr[row+1] == 'O' && arr[row+2] == 'O') {
				winner = 'O';
				break;
			}
			else if(arr[col] == 'X' && arr[col+3] == 'X' && arr[col+6] == 'X') {
				winner = 'X';
				break;
			}
			else if(arr[col] == 'O' && arr[col+3] == 'O' && arr[col+6] == 'O') {
				winner = 'O';
				break;
			}
		}
		
		if(winner == 't')
		{
			for(int i=1; i<10; i++)
			{
				if(arr[i] == ' ') {
					winner = 'p';
					break;
				}
			}
		}
		
		return winner;
	}
	
	
	
}
