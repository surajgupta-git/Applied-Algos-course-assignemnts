public class Scheduling {
    public static int schedule(int[][] A) {
        int[] a = new int[A.length];
        int[] b = new int[A.length];
        for (int i = 0; i < A.length; i++)
        {
            for (int k = i + 1; k < A.length - 1; k++) {
                if (A[i][0] > A[k][0]) {
                    int temp0 = A[k][0];
                    A[k][0] = A[i][0];
                    A[i][0] = temp0;
                    int temp1 = A[k][1];
                    A[k][1] = A[i][1];
                    A[i][1] = temp1;
                }
            }
        }

        for (int i = 0; i < A.length; i++)
        {
            a[i] = A[i][0];
            b[i] = A[i][1];
        }
        int i, j;
        int count=1;
        int n = A.length;

        System.out.print("Following activities are selected : n");

        // The first activity always gets selected
        i = 0;
        System.out.print(i + " ");

        // Consider rest of the activities
        for (j = 1; j < n; j++) {
            // If this activity has start time greater than or equal to the finish time of previously selected activity, then select it
            if (a[j] >= b[i])
            {
                System.out.print(j + " ");
                i = j;
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args){
        int[][] A = {{64800,21600}, {75600,14400}, {10800,50400}, {46800, 68400}};
        int num=0;
        num=schedule(A);
        System.out.print(num);
    }
}