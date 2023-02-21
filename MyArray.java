import java.util.Arrays;
import java.util.Random;

/**
 * @author Khang Ta
 */
public class MyArray {
    private int[] a;

    /**
     * Create constructor
     * 
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
     * 
     * @throws Exception
     */
    private void generator(int n) throws Exception {
        Random rand = new Random();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt();
        }
    }

    /**
     * Sort the array by using bubble sort
     */
    public void bubbleSort() {
        boolean isSwap; // true if two elements swap their value
        int times = 0; // the number of times to do the loop
        do {
            isSwap = false;
            for (int i = 0; i < a.length - 1 - times; i++) {
                int j = i + 1;
                // Compare each pair of adjacent elements
                if (a[i] > a[j]) { // if the first elements is greater than the second, swap it
                    isSwap = true; // Two elements are swapped, so isSwap = true;
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
            times++;
        } while (isSwap); // Loop until there is no element change their value
    }

    /**
     * To convert array to string
     */
    @Override
    public String toString() {
        return Arrays.toString(a);
    }

}
