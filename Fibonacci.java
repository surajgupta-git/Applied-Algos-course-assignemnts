public class Fibonacci {
    static int fib_array(int n) {
        int F[] = new int[n + 2];
        F[0] = 0;
        F[1] = 1;
        int i = 2;
        while (i <= n) {
            F[i] = F[i-1] + F[i-2];
            i = i + 1;
        }
        return F[n];
    }
    public static void main(String[] args){
        int lastdigit=fib_array(10);
            System.out.println(lastdigit);
    }
}
