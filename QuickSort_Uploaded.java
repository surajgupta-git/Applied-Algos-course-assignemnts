import java.util.*;

public class QuickSort_Uploaded {
    static void random(int arr[],int p,int r)
    {
        Random rand= new Random();
        int pivot = rand.nextInt(r-p)+p;
        int temp1=arr[pivot];
        arr[pivot]=arr[r];
        arr[r]=temp1;
    }

    static int partition(int A[], int p, int r) {
        int pivot;
        if (A.length==1)
            pivot= A[0];
        else{
            random(A,p,r);
            pivot=A[r];
        }
        int i= p-1;
        for(int j=p;j<r;j++){
            if(A[j]<pivot){
                i++;
                int temp1=A[i];
                A[i]=A[j];
                A[j]=temp1;
            }
        }
        int temp1=A[i+1];
        A[i+1]=A[r];
        A[r]=temp1;
        return i+1;
    }

    static void sort(int A[], int p, int r) {
        if(p<r){
            if(r==A.length)
                r=r-1;
            int pi=partition(A,p,r);
            sort(A,p,pi-1);
            sort(A,pi+1,r);
        }
    }
    public static void main(String[] args){
        int[] arr= {3,5,4,1,1};
        sort(arr,0,arr.length);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}