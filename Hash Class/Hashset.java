import java.util.*;
public class Hashset {
    static class pair{
        int a;
        int b;
        pair(int a, int b){
            this.a=a;
            this.b=b;
        }
        public int first(){
            return this.a;
        }
        public int second(){
            return this.b;
        }
        @Override
        public boolean equals(Object o){
            pair hc = (pair)o;
            if(hc.first()==first() && hc.second()==second())
                return true;
            return false;
        }
        @Override
        public int hashCode()
        {
        
            int hash = first()*3 + second()*7;
            return hash;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        try{
            while(t--!=0)
            {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int k = sc.nextInt();
                HashSet<pair> h = new HashSet<>();
                for(int i=1;i<=k;i++)
                {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    h.add(new pair(x, y));
                }
                
                int count=0;
                Iterator<pair> it = h.iterator();
                 while(it.hasNext())
                 {
                     pair temp = it.next();
                     System.out.println(temp.first()+" "+temp.second());
                     System.out.println(h.contains(temp));
                 }
                Iterator<pair> itr = h.iterator();
                while(itr.hasNext())
                {
                    pair temp = itr.next();
                    int i = temp.first();
                    int j = temp.second();
                    int i1 = i+1;
                    int i2 = i-1;
                    int j1 = j+1;
                    int j2 = j-1;
                    pair temp1=new pair(i1, j);
                    if(!(h.contains(temp1))){
                        count++;
                    }
                    pair temp2 = new pair(i2, j);
                    if(!h.contains(temp2))
                        count++;
                    pair temp3 = new pair(i, j1);
                    if(!h.contains(temp3))
                        count++;
                    pair temp4 = new pair(i, j2);
                    if(!h.contains(temp4))
                        count++;
                    //System.out.println(count);
                }
                System.out.println(count);
            }
        }
        catch(Exception e){
            return;
        }
    }
}
