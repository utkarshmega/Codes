import java.util.*;
class sexyPrime
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int test=1;test<=t;test++)
		{
        int n=sc.nextInt();
        int m=sc.nextInt();
        sexyPrime obj=new sexyPrime();
		//Range for the prime number b the user !
        obj.prime_sexyPrime(n, m);	
        }
    }
    void prime_sexyPrime(int n, int m)
    {
		//Cearing an array for the prime number
        boolean[] prime = new boolean[m+7];
		
		//Initializing every value by true;
        for(int i=0;i<prime.length;i++)
            prime[i]=true;
        
        for(int i=2;i<=m;i++)
        {
			//To chec if the number is prime or not
            if(prime[i]==true){
                
                for(int j=2*i;j<=m;j+=i)
                    prime[j]=false;                    
                
        }
                        
    }
		int flag=0;
        for(int i=n;i<=m;i++)
        {
			if(prime[i]==true)
			{
				flag=1;
				if(prime[i+6]==true)
					System.out.print(i+" "+(i+6)+" ");
			}
			if(i+6>=m)
				break;
            
		}
		if(flag==0)
			System.out.print("-1");
		System.out.println();
    }
}