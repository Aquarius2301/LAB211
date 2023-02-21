import java.util.Arrays;
import java.util.Random;

/**
 * @author Khang Ta
 */
public class MyArray {
    private int[] a;

    /**
     * Create constructor with parameter
     * 
     * @throws Exception
     */
    public MyArray(int n) throws Exception {
        checkN(n);
        generator(n); // Create an array
    }

    /**
     * if n is less than 0 , throw Exception
     * 
     * @param n
     * @throws Exception if n < 0
     */
    private void checkN(int n) throws Exception {
        if (n <= 0) {
            throw new Exception("Accept Positive Number Only!");
        }
    }

    /**
     * Create an array, all elements have randomize value
     */
    private void generator(int n) {
        Random rand = new Random();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(20);
        }
    }

    /**
     * Find the value by using Binary search
     * 
     * @param value
     * @return
     */
    public int findValue(int value) {
        int low = 0;
        int high = a.length - 1;
        do {
            int m = (low + high) / 2; // m is the middle in the array
            if (value == a[m]) { // if a[m] = value, stop
                return m;
            } else if (value > a[m]) { // if a[m]< value , continue find the value from m+1 to high
                low = m + 1;
            } else
                high = m - 1; // if a[m]> value , continue find the value from low to m-1
        } while (low <= high);
        return -1; // Not found
    }

    /**
     * To convert the sorted array to string
     */
    @Override
    public String toString() {
        Arrays.sort(a);
        return Arrays.toString(a);
    }

}
