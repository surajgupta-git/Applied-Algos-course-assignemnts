public class BinarySearch2D {
    static int[] search(int[][] M, int q) {
            //num of Rows = M.length;
            //num of Cols = M[0].length;
            int begin = 0;
            int end = M.length * M[0].length-1;
            int res[] = new int[2];
            if(M.length==0)
            {
                //to avoid the exception index 0 out of bounds for length 0
                res[0] = -1;
                res[1] = -1;
                return res;
            }
            while (begin <= end && begin>=0 && end>=0)
            {
                int mid = begin + (end - begin) / 2;
                if (q == M[mid / M[0].length][mid % M[0].length]) {
                    res[0] = mid / M[0].length;
                    res[1] = mid % M[0].length;
                    return res;
                }
                if (q < M[mid / M[0].length][mid % M[0].length])
                    end = mid - 1;
                else
                    begin = mid + 1;
            }
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        public static void main(String[] args) {
            int[][] matrix = {
                    {1,2,3},{5,6,7}};
            int[] b = search(matrix, 7);
            System.out.println("(" + b[0] + "," + b[1] + ")");
        }
}