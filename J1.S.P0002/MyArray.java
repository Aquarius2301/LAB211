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
        generator(n); // Start creating an array
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
            a[i] = rand.nextInt(n);
        }
    }

    /**
     * Sort the array by using selection sort
     */
    public void selectionSort() {
        for (int i = 0; i < a.length; i++) {
            int min = a[i]; // The minimum value element in this array
            int elements = i; // The minimum value element at index
            // Find the minimum value
            for (int j = i; j < a.length; j++) {
                if (a[j] < min) { // If min < a[j] then min = a[j]
                    min = a[j];
                    elements = j;
                }
            }
            // Swap the minimum value element with a[i]
            int t = a[elements];
            a[elements] = a[i];
            a[i] = t;
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
