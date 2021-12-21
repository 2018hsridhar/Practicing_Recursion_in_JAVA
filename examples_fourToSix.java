/*
Test cases 
(A) [1,1]
(B) [1,100000] => make it stupidly big
(C) [2,8]
(D) [10,9] => 1*10e9 ( fit in integer ) 
*/
import java.util.*;
import java.io.*;

public class examples_fourToSix
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int base = sc.nextInt();
		int exp = sc.nextInt();
		// int powRes4 = power4(a,n);
		// int powRes5 = power5(base,1, exp);	// first term is 1 here ( base^0 = 1 anyways ) 
		int powRes6 = power6(base, exp);
		System.out.printf("Power res for [%d] raised to the power of [%d] = %d\n", base, exp, powRes6);
	}

	// Hey this is cool -> ANY binary number must be prefixed by a "1" ( whether even case or odd case! ) unless said binary number equals zero ( in which case, halt execution )!
	// Term is initially equal to base here
	// 12 -> 6 -> 3 -> 1R1 -> 0R1 ( 4 steps here ) 
	// Recursion involves having your parent caller "grow" a term as well. Not intuitive
	private static int power6(int term, int n)
	{
		int ans = 1;
		if(n == 0)	// We converge when quotient = 0 here ( add both this is it's corresponding remainder too ) 
		{
			return 1;	// nothing to add here : all remainders exhausted, and this remainder would equal zero anyways!
		}	
		else
		{		
			int rem = n % 2;
			if(rem == 1)
			{
				ans *= 1 * term;
			}
			int halfN = (int)(Math.floor(n / 2));	// for safety, of course
			int squaredTerm = term * term;
			ans *= power6(squaredTerm, halfN);	// pass that back up ( final computed answer ) 
		}
		return ans;
	}

	// Power : 2 parameters -> base an exponential to raise up to
	private static int power5(int base, int n)
	{
		int res = 1;
		if(n == 0)
		{
			return 1;
		}
		else if ( n % 2 == 0)
		{
			return power5(base, n/2) * power5(base, n/2);
		}
		else if ( n % 2 == 1)
		{
			return base * power5(base, n/2) * power5(base, n/2);
		}
		return res;
	}

	/*
	Power calculations ~ risk of data overflow is possible
	Let us assume data fits in memory
	*/
	private static int power4(int base, int n)
	{
		// n == 1 : have a stopping case execute earlier ( as we know base^1 = base, and we need not solve other subproblems )
		// Or truly go to n == 1 instead
		if(n == 0)
		{
			return 1;
		}
		else
		{
			return base * power4(base, n-1);
		}
	}
}
