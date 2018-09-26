import java.util.*;
class sieveOfEratosthenes
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        sieveOfEratosthenes obj=new sieveOfEratosthenes();
		//Range for the prime number b the user !
        obj.prime_sieveOfEratosthenes(n, m);	
        
    }
    void prime_sieveOfEratosthenes(int n, int m)
    {
		//Cearing an array for the prime number
        boolean[] prime = new boolean[m+1];
		
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
        for(int i=n;i<=m;i++)
        {
            if(i==1)
                continue;
            if(prime[i]==true)
                System.out.print(i+", ");
        }
    }
}