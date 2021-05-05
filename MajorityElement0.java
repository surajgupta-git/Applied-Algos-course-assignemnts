import java.io.*;
import java.util.*;

public class MajorityElement0 {
    public static int majority(int[] A) {
        Arrays.sort(A);
        int n=A.length;
        int count = 1 , temp = A[0], ele = 0, f = 0;
        for(int i = 1; i < n; i++)
        {       // Increases the count if the same element occurs otherwise starts counting new element
            if (temp == A[i])
                count++;
            else
            {
                count = 1;
                temp = A[i];
            }
            // Sets maximum count and stores maximum occurred element so far if maximum count becomes greater than n/2 it breaks out setting the flag 8444120752
                ele=A[i];
                if (count > (n / 2))
                {
                    f = 1;
                    break;
                }
        }
        // Returns maximum occurred element if there is no such element, returns -1
        return (f == 1 ? ele: -1);
    }

}