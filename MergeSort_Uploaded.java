public class MergeSort_Uploaded {
    static void merge (int A[], int p,int q,int r) {
        int n1 = q- p + 1;
        int n2 = r - q;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = A[p + i];
        for (int j = 0; j < n2; ++j)
            R[j] = A[q + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = p;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            }
            else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void sort(int A[], int p, int r)
    {
        if (A.length == r){
            r -= 1;
        }
        if (p < r) {
            int x = r-p;
            // Find the middle point
            int m =p+Math.floorDiv(x,2);

            // Sort first and second halves
            sort(A, p, m);
            sort(A, m + 1, r);

            // Merge the sorted halves
            merge(A, p, m, r);
        }
    }


}