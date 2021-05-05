import static org.junit.Assert.*;
//select a key and then compare all the elements left to it and then swap them according to get the left array sorted and then take the key as the next element of previous key
//time-complexity--->O(n^2)
//Loop-invariant: the elements from i=0 to i=j-1 always remains
// sorted before the loop starts and till all the iterations are completed.

// The non-swapping version of Insertion Sort

//static void sort(int A[]) {
//        if (A.length == 0)
//        return;
//        for (int j = 1; j != A.length; ++j) {
//        int key = A[j];
//        int i = j - 1;
//        while (i >= 0 && A[i] > key)
//        {
//        A[i + 1] = A[i];
//        i = i - 1;
//        }
//        A[i + 1] = key;
//        }
//        }

//// The swapping version of Insertion Sort
//static void sort(int A[])
//        {
//        if (A.length == 0)
//        return;
//        for (int j = 1; j != A.length; ++j) {
//        int i = j - 1;
//        while (i >= 0 && A[i] > A[i+1]) {
//        swap(A, i, i + 1);
//        i = i - 1;
//        }
//        }
//        }
public class InsertionSort
{
    static void sort(int[] A) {
        for (int Key = 1; Key < A.length; Key++) {
            assertTrue(sorted(A, 0, Key ));
            int i;
            //for(i=j-1;i >= 0 && A[i] > Key;i--)
            for(i=Key-1;i >= 0 && A[i] > A[i+1];i--)
            {
                assertTrue(sorted(A,0,i+1) && sorted(A,i+1,Key+1));
                //inside the second for loop do all the internal steps using i only as this belongs to the left sorted array
                //swap logic
                int temp = A[i + 1];
                A[i + 1] = A[i];
                A[i] = temp;
            }
            //i should mandatory go till 0 and the do a last swap
        }
    }

    static Boolean sorted(int A[], int begin, int end) {
        for (int i = begin; i != end; ++i)
        {
            if (i + 1 != end) {
                if (A[i] > A[i+1]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int A[]={5,4,3,2,1};
        sort(A);
        System.out.println(sorted(A,0,A.length-1));
        for (int j = 0; j < A.length; j++)
        {
            System.out.print(A[j]);
        }
        }
    }

