
/**
 * @author KhangTa
 */
public class App {
    
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            int n;
            n = Validation.readInt("Enter number of array: "); // Make sure user enter a valid number.
            MyArray a = new MyArray(n);

            System.out.println("Unsorted array: " + a); // Print out the array before sorted
            a.selectionSort(); // Sort the array by using bubble sort
            System.out.println("Sorted array: " + a); // Print out the array after sorted
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
