import java.util.Arrays;
import java.util.Random;

/**
 * @author Khang Ta
 */
public class MyArray {
    private int[] a;


    /**
     * Create constructor
     * @throws Exception
     */
    public MyArray(int n) throws Exception {
        checkN(n);
        generator(n);// Start creating an array
    }

    /**
     * if n is less than or equals to 0 , throw Exception
     * 
     * @param n
     * @throws Exception
     */
    private void checkN(int n) throws Exception {
        if (n <= 0) {
            throw new Exception("Accept Positive Number Only!");
        }
    }

    /**
     * Create an array, all elements have random integer in number range
     */
    private void generator(int n) {
        Random rand = new Random();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt();
        }
    }

    /**
     * Sort the array by using insertion sort
     */
    public void insertionSort() {
        int j;
        for (int i = 1; i < a.length; i++) { // Take a[i]
            int t = a[i]; // put t = a[i];
            for (j = i; j > 0; j--) { // Put j=i
                if (t < a[j - 1]) { // if t<a[j-1] -> a[j]=a[j-1], keep doing until no change or j=0
                    a[j] = a[j - 1];
                } else {
                    break; // If wrong, break;
                }
            }
            a[j] = t;

        }
    }

    /**
     * To convert array to string
     */
    @Override
    public String toString() {
        return Arrays.toString(a);
    }

}
