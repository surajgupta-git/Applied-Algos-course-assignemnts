import java.util.ArrayList;

public class InversionCount {
    static class Item
    { // Class for storing the index and Value pairs
        int val;
        int index;
        public Item(int val, int index)
        { //constructor
            this.val = val;
            this.index = index;
        }
    }
    public static int[] count(int[] A)
    {
            Item[] items = new Item[A.length];
            for (int i = 0; i < A.length; i++)
                items[i] = new Item(A[i], i);
            int[] count = new int[A.length];
            mergeSort(items, 0, A.length - 1, count);
            return count;
    }
        // Function for Merge Sort
        public static void mergeSort (Item[]items, int low, int high, int[] count)
        {
            if (low >= high)
                return;
            int mid = low + (high - low) / 2;
            mergeSort(items, low, mid, count);
            mergeSort(items, mid + 1, high, count);
            merge(items, low, mid, mid + 1, high, count);
        }

        // Utility function that merge the array and count smaller element on right side
        public static void merge (Item[]items,int low, int lowEnd, int high, int highEnd, int[] count) {
            int m = highEnd - low + 1;
            Item[] sorted = new Item[m];
            int rightCounter = 0;
            int i = low, j = high, sortedindex = 0;
            // Loop to store the count of smaller Elements on right side when both Array have some elements
            while (i <= lowEnd && j <= highEnd) {
                if (items[i].val > items[j].val) { //right elements should be less
                    rightCounter++;
                    sorted[sortedindex] = items[j];
                    sortedindex++;
                    j++;

                } else {
                    count[items[i].index] += rightCounter;
                    sorted[sortedindex] = items[i];
                    sortedindex++;
                    i++;
                }
            }
            // Loop to store the count of smaller elements in right side for all the remaining left array elements
            while (i <= lowEnd) {
                count[items[i].index] += rightCounter;
                sorted[sortedindex] = items[i];
                sortedindex++;
                i++;
            }
            while (j <= highEnd) {
                sorted[sortedindex] = items[j];
                sortedindex++;
                j++;
            }
            System.arraycopy(sorted, 0, items, low, m); //move the sorted array elements into items array
        }

        public static void main (String[] args)
        {
            int arr[] = {10, 9, 5, 2, 7, 6, 11, 0, 2};
            int[] result=count(arr);
            for(int i=0;i<result.length;i++){
                System.out.println(result[i]);
            }
        }
    }
