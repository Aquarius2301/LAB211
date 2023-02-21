/**
 * @author KhangTa
 */
public class App {
    
    public static void main(String[] args) {
        try {
            int n = Validation.readInt("Enter number of array: "); // number of elements
            int value = Validation.readInt("Enter search value: "); // search value

            MyArray arr = new MyArray(n);

            System.out.println("Sorted array: " + arr);

            int indexOfValue = arr.findValue(value); // Finding value. If no value in array, return -1
            if (indexOfValue != -1) {
                System.out.println("Found " + value + " at: " + indexOfValue);
            } else {
                System.out.println("Not found " + value + " in the array");
            }
            Validation.sc.close(); // close Scanner
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}