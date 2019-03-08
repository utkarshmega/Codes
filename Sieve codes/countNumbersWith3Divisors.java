/* A number has 3 divisors if its square root is a prime number. First
find the the number of square roots in the range and then check how 
many numbers are prime within that range and that will be the answer.*/

import java.util.*;
import java.lang.*;
import java.io.*;
class countNumbersWith3Divisors
 {
    static void sieve(int l, int r)
    {
        boolean prime[]=new boolean[100001];
        for(int i=2;i*i<=100000;i++)
        {
            for(int j=i*i;j<=100000;j+=i)
                if(prime[i]==false)
                    prime[j]=true;
        }
        int a = (int)Math.ceil(Math.sqrt(l));
        int b = (int)Math.floor(Math.sqrt(r));
        int res=0;
        for(int i=a;i<=b;i++)
        {
            if(i==1)
                continue;
            if(!prime[i])
                res++;
        }
        System.out.println(res);
        
    }
	public static void main (String[] args)
	 {
	     Scanner sc = new Scanner(System.in);
	     int t = sc.nextInt();
	     while(t--!=0)
	     {
	         int l = sc.nextInt();
	         int r = sc.nextInt();
	         sieve(l, r);
	     }
	 }
}