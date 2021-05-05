import java.util.*;
import java.util.Random;
public class QuickSelect_0 {
    public static int select(int[] A, int k)
    {
        return getKthSmallestQuickSelectWorstCaseLinearTime(A,0,A.length-1, k);
    }

    public static int getKthSmallestQuickSelectWorstCaseLinearTime(int arr[], int low, int high, int k)
    {
        if (k > 0 && k <= high - low + 1) {
            // number of elements in array
            int n = high - low + 1;
            int i, median[] = new int[(n + 4) / 5];
            for (i = 0; i < median.length - 1; i++) {
                median[i] = getMedian(Arrays.copyOfRange(arr, 5 * i + low, 5 * i + low + 4), 5);
            }
            if (n % 5 == 0) {
                median[i] = getMedian(Arrays.copyOfRange(arr, 5 * i + low, 5 * i + low + 4), 5);
                i++;
            } else {
                median[i] = getMedian(Arrays.copyOfRange(arr, 5 * i + low, 5 * i + low + (n % 5)), n % 5);
                i++;
            }

            int medOfMed = i == 1 ? median[i - 1]
                    : getKthSmallestQuickSelectWorstCaseLinearTime(median, 0, i - 1, i / 2);

            int pos = partitionPractise(arr, low, high, medOfMed);

            if (pos - low == k - 1) {
                return arr[pos];
            }

            if (pos - low > k - 1) {
                return getKthSmallestQuickSelectWorstCaseLinearTime(arr, low, pos - 1, k);
            }
            return getKthSmallestQuickSelectWorstCaseLinearTime(arr, pos + 1, high, k - (pos + 1) + low);
        }
        return -1;
    }

    public static int getMedian(int arr[], int n) {
        Arrays.sort(arr);
        return arr[n / 2];
    }

    public static void swap(int[] arr, int i, int index) {
        if (arr[i] == arr[index]) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }

    public static int partitionPractise(int[] arr, int low, int high, int pivot) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pivot) {
                swap(arr, i, high);
                break;
            }
        }
        int i = low - 1;
        int j = low;
        while (j < high)
        {
            if (arr[j] < pivot) {
                i++;
                swap(arr, j, i);
            }
            j++;
        }
        swap(arr, i+1, high);
        return i;
    }

    public static void main(String[] args)
    {
        int arr[] = {5,4,3,-2,1,0};
        int n = arr.length, k = 5;
        System.out.println("K' th smallest element is " + select(arr,k+1));
    }
}
