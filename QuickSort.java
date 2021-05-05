import java.util.*;
import java.util.Random;
public class QuickSort {
    public static void random(int arr[],int low,int high)
    {
        Random rand= new Random();
        int pivot = rand.nextInt(high-low)+low;
        int temp1=arr[pivot]; //swap
        arr[pivot]=arr[low];
        arr[low]=temp1;
    }
    //another type of partition
//    static int partition(int A[], int p, int r) {
//        int pivot;
//        if (A.length == 1)
//            pivot = A[0];
//        pivot= A[r];
//        int i= p-1;
//        for(int j=p; j<r; j++)
//        {
//            if (A[j] < pivot)
//            {
//                i=i+1;
//                Swap(A[i],A[j]);
//            }
//        }
//        Swap(A[i+1],A[r]);
//        return i+1;
//    }

    public static int partition(int A[], int p, int r)
    {
        int pivot;
        if (A.length==1)
            pivot= A[0];
        else {
            random(A,p,r);
            pivot=A[p];
        }
        int i = p;
        int j = r;
        while (i<j) {
            do {
                j--;
            } while (A[j] > pivot); //decrement j till A[j]<pivot implies decrement while A[j]>pivot
            do {
                i++;
            } while (A[i] < pivot && i<j); //increment i till A[i]>pivot implies increment while A[i]<pivot
            if (i<j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        } //exchange pivot with j when i > j
        int temp = A[j];
        A[j] = A[p];
        A[p] = temp;
        return j;
    }

    public static void sort(int A[], int p, int r) {
        if(p < r) //r passed is length
        {
            int j = partition(A,p,r);
            sort(A,p,j);
            sort(A,j + 1, r);
        }
    }
    public static void main(String[] args){
        int[] arr= {3,5,1,4,1,15,6,3,1,7,3};
        sort(arr,0,arr.length);
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
}


