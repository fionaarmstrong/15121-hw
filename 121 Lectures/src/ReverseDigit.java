/*
	demo on recursion
	
	printing a sentence backwards

*/

import java.io.*;
import java.util.Scanner;

public class ReverseDigit
{
	public static Scanner keyboard = new Scanner(System.in);
	
	static void writeBackwards(int digit)
	{
		if(digit >10)							//base case
		{
			System.out.print(digit % 10);	//prints last char
			writeBackwards(digit / 10);		//recursive call + size reduction
		}
		else
		{
			System.out.print(digit);
		}
	
	}
	
	static public void main(String[] args) throws IOException
	{
		int digit;

		//prompt user
		System.out.print("Enter a positive number: ");

		
		//read data from keyboard
		digit = keyboard.nextInt();
		
		//write digit backwards
		writeBackwards(digit);		
	}
}