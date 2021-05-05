public class BinarySearch {
    static int search(int A[], int key) {
        int begin = 0;
        int end = A.length-1;
        while(begin<=end)
        {
            int mid =begin+ (end - begin) / 2;
            if (key == A[mid])
                return mid;
            if (key < A[mid])
                end = mid - 1;
            else
                begin = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        //the input array must be sorted always
        int B[]= {2,3,4};
        System.out.println(search(B,4));
    }
}
