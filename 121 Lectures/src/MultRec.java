public class MultRec{
	
	public static void main (String[] args)
	{
		System.out.println("Multiplication = " + Multiply(4,2));
		
	}


	public static int Multiply (int  a, int b)
	{
		if (a == 0) 
			return 0;
		else
			return  b + ( Multiply (a-1, b));
	}	
	
}