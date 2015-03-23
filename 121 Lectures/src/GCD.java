/*
	demo on recursion
	
	printing a sentence backwards

*/

import java.io.*;
import java.util.Scanner;

public class GCD
{
	public static Scanner keyboard = new Scanner(System.in);
	
	static int findGCD(int x, int y)
	{
		if(x % y == 0){
			return y;
		}
		else{
			return findGCD(y, x % y);
		}
	
	}
	
	static public void main(String[] args) throws IOException
	{
		System.out.print("Enter two positive integers: ");

		int num1 = keyboard.nextInt();
		int num2 = keyboard.nextInt();
		
		System.out.println("The GCD of " +  num1 +  " and " + num2 + " = " + findGCD(num1,num2));
	}
}