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
        generate(n); // Create an array
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
    private void generate(int n) {
        Random rand = new Random();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(20);
        }
    }

    /**
     * Find the value by using Linear search
     * 
     * @param value
     * @return
     */
    public int indexOf(int value) {
        for (int index = 0; index < a.length; index++) { //search from first index to last index
            if (a[index] == value)  // if a[index]=value, found value and return index 
                return index;
        }
        return -1; // Not found
    }

    /**
     * To convert the array to string
     */
    @Override
    public String toString() {
        return Arrays.toString(a);
    }

}
