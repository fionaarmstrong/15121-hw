/********************************************
  	15-121 demo on RECURSION using String Class
  	
  	Palindrome
 
 ********************************************/

public class Palindrome{

	
	public static void main (String[] args)
	{
		System.out.println("String is a palindrome = " + isPalindrome("p0p0p"));

	}


	public static boolean isPalindrome(String s)
	{
		if ((s.length() == 0) || (s.length() == 1))
			return true;
		else{
			if(s.charAt(0) != s.charAt(s.length()-1))
				return false;
			else
				return(isPalindrome(s.substring(1, s.length()-1)));
		}
	}
	
	
}