public class HeapSort{
    static void heapify(int A[], int n, int i){
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && A[l] > A[largest])
            largest = l;
        // If right child is larger than largest so far
        if (r < n && A[r] > A[largest])
            largest = r;
        // If largest is not root
        if (largest != i) {
            int swap = A[i];
            A[i] = A[largest];
            A[largest] = swap;
            // Recursively heapify the affected sub-tree
            heapify(A, n, largest); //largest is an index
        }
    }

    static void heapSort(int A[]){
        int n = A.length;
        // Build heap (reArrange Array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(A, n, i);
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            // call max heapify on the reduced heap
            heapify(A, i, 0);
        }
    }
}