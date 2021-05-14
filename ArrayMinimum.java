public class ArrayMinimum {
    //function to check the assertion
    
    static public Boolean is_minimum(int min, int A[], int begin, int end) {
        for (int i = begin; i != end; ++i) {
            if (min > A[i]) return false;
        }
        return true;
    }
    //real function
    static public int minimum(int A[]) throws Exception {
        int min = A[0];
        int i = 1;
        while (i != A.length) {
            //The invariant of the `while` loop is that `min` is the smallest element in the range `[0,i)`
            assert (is_minimum(min, A, 0, i));
            if (A[i] < min) {
                int temp = A[i];
                A[i] = min;
                min = temp;
            }
            i++;
        }
        return min;
    }

    public static void main(String[] args) throws Exception {
        int arr[]={12,32,4,6,7,34,3,4};
        System.out.println(minimum(arr));
    }
}
