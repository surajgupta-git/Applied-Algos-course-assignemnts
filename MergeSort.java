import static org.junit.Assert.*;

public class MergeSort
{
    static void sort(int A[],int p,int r) {
        if(p<r) {
            int q = p + (r-p) / 2;
            sort(A, p, q);
            sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    static void merge(int A[], int p, int q, int r)
    {
        int[] b=new int[r-p+1]; //temporary array
        int k=0, i=p,j=q+1;
        while(i<=q && j<=r && k<=r-p){
            if(A[i]<A[j]){
                b[k]=A[i];
                i++;
                k++;
                continue;
            }
            else if(A[i]>A[j]){
                b[k]=A[j];
                j++;
                k++;
                continue;
            }
            else if(A[i]==A[j]){
                b[k]=A[i];
                b[k+1]=A[j];
                i++;
                j++;
                k=k+2;
                continue;
            }
        }
        while(i<=q){ //to copy all the remaining elements
            b[k]=A[i];
            i++;
            k++;
        }
        while(j<=r){  //to copy all the remaining elements
            b[k]=A[j];
            j++;
            k++;
        }
        // move all the elements from b back to A - original array
        for(k=0,i=p;i<=r;i++,k++){
            A[i]=b[k];
        }
    }

    public static void main (String[] args){
        int [] A= new int[]{4, 7, 6, 23, 8, 2, 6, 2, 9, 4};
        sort(A,0,A.length-1);
        int n = A.length;
        for (int i = 0; i < n; ++i)
            System.out.print(A[i] + " ");
    }


}