/*
	demo on recursion
	
	factonial n!

*/

import java.io.*;

public class Factorial
{
	
	/*
	public static int fact(int n){
		if(n == 0){			//base case
			return 1;
		}
		else{
			return n * fact(n-1);
		}
	}
	*/
	
	
	
	public static int fact(int n){
		int result = 1;
		for(int p = 1; p <= n; p++){
			result = result * p;
		}
		return result;
	}

	
	
	public static  void main(String[] args)
	{
		System.out.println("Factorial is = " + fact(3));
	}
}