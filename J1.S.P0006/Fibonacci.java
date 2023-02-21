public class Fibonacci {

    private int n;

    /**
     * Constructor with parameter
     * 
     * @throws Exception 
     */
    public Fibonacci(int n) throws Exception {
        checkN(n);
        this.n = n;
    }

    /**
     * check n
     * 
     * @param n
     * @throws Exception if n<0
     */
    private void checkN(int n) throws Exception {
        if (n < 0)
            throw new Exception("Accept positive number only");
    }

    /**
     * Show the Fibonacci sequence
     * 
     * @return the Fibonacci sequence (String)
     */
    @Override
    public String toString() {
        String res = "0"; // print out the first Fibonacci
        if (n > 1) { // print out the remaining Fibonacci
            for (int i = 2; i <= n; i++) {
                res += ", " + fiboRecursive(i);
            }
        }
        return res;
    }

    /**
     * Use recursion to find a Fibonacci
     * F(n){
     * 0 if n = 1
     * 1 if n = 2
     * F(n-1)+ F(n-2) if n>=2
     * }
     * 
     * @param n
     * @return
     */
    private int fiboRecursive(int n) {
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;
        return fiboRecursive(n - 1) + fiboRecursive(n - 2);
    }

}
