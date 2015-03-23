/*
	demo on recursion
	
	factonial n!

*/

import java.io.*;

public class Fibonacci
{
	
	public static int fibo(int n)
	{
		if(n <= 2){			//base case
			return 1;
		}
		else{
			return fibo(n-1) + fibo(n-2);
		}
	
	}
	
	public static  void main(String[] args)
	{
		System.out.println("Fibonacci is = " + fibo(6));
	}
}