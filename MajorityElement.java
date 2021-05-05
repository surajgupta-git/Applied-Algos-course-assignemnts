public class MajorityElement {
    public static int majority(int[] A) {//candidate is likely to be a majority element
        int size = A.length;
        int maj_index = 0, count = 1;
        int i;
        int candidate;
        for (i = 1; i < size; i++)
        {
            if (A[maj_index] == A[i])
                count++;
            else
                count--;
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }
        candidate = A[maj_index];
        count = 0;
        for (i = 0; i < size; i++)
        {
            if (A[i] == candidate)
                count++;
        }
        if (count > size / 2)
            return A[i];
        else
            return -1;
    }
}