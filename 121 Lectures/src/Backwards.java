/*
	demo on recursion
	
	printing a sentence backwards

*/

import java.io.*;
import java.util.Scanner;

public class Backwards
{
	public static Scanner keyboard = new Scanner(System.in);
	
	static void writeBackwards(String a_line, int index)
	{
		if(index >= 0)							//base case
		{
			System.out.print(a_line.charAt(index));	//prints last char
			writeBackwards(a_line, index-1);		//recursive call + size reduction
		}
	
	}
	
	static public void main(String[] args) throws IOException
	{
		String inputLine;

		//prompt user
		System.out.print("Enter a sentence: ");

		
		//read data from keyboard
		inputLine = keyboard.nextLine();
		
		//write sentence backwards
		int valid_index = inputLine.length()-1;   //careful with this!
		writeBackwards(inputLine, valid_index);		
	}
}