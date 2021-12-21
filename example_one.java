import java.util.*;
import java.io.*;


// Always ask if your context under reference is static or not static
// PRECONDITION : n is guaranteed to be a positive integer value
// Problem : Write a method to print "Hello" n times
public class example_one
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your value for n.\n");
		int n = sc.nextInt();
		System.out.printf("You entered a value of n = [%d]\n", n);
		printHello(n);	// invoked as a line-of-code : void type
	}

	private static void printHello(int n)
	{
		// Base case/stopping case with explicit solution
		if(n == 1)
		{
			System.out.printf("Hello\n");
		}
		else
		{
			System.out.printf("Hello\n");
			printHello(n-1);
		}
	}

}



