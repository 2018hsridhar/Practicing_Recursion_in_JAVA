import java.util.*;
import java.io.*;

public class example_two
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printNums(n);
	}

	/*
	Precondition : Given a positive integer n
	Notice how order of operations matters here
	Also notice potential for tail-call optimization
	*/
	private static void printNums(int n)
	{
		if(n == 1)
		{
			System.out.printf("1\n");
		}
		else
		{
			printNums(n-1);
			System.out.printf("%d\n", n);
		}
	}
}
