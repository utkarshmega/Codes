import java.util.*;
import java.io.*;

public class inversionInArray
{
    int count=0;
    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m-l+1;
        int n2 = r-m;
        
        int L1[] = new int[n1];
        int R1[] = new int[n2];
        
        /*Store the ements in the temp array*/
        for(int i=0;i<n1;i++)
            L1[i]=arr[l+i];
        for(int i=0;i<n2;i++)
            R1[i]=arr[m+1+i];
            
        int i=0, j=0, k=l;
        while(i<n1 && j<n2)
        {
            if(L1[i]<=R1[j])
            {
                arr[k++]=L1[i];
                i++;
            }
            else
            {
                arr[k++]=R1[j];
                j++;
                /*The toal number of elements is calculated by U.B.-L.B.+1, but here since i is incremented by 1 already before therefore 1 is subtracted*/
                count+=n1-i;
            }
        }
        while(i<n1)
        {
            arr[k++]=L1[i];
            i++;
        }
        while(j<n2)
        {
            arr[k++]=R1[j];
            j++;
        }
        
        
    }
    void sort(int arr[], int l, int r)
    {
        if(l<r)
        {
            int m = (l+r)/2;
            /*To divide the array into halves through recursion*/
            sort(arr, l, m);
            sort(arr, m+1, r);
            
            /*To conquer the divided arrays*/
            merge(arr, l, m, r);
        }
    }
    void printArray(int arr[])
    {
        System.out.println("Sorted Order");
        for(int nos: arr)
            System.out.print(nos+" ");
            
        System.out.println("\nMinimum swaps required:- "+count);
    }

    public static void main (String[] args) {
            
        Scanner sc = new Scanner(System.in);
        int arr[] = {5, 89, 45, 74, 21, 58};
        System.out.println("Original array");
        for(int val:arr)
            System.out.print(val+" ");
        System.out.println();   
        mergeSort ms = new mergeSort();
        ms.sort(arr, 0, arr.length-1);
        
        ms.printArray(arr);
    }
}