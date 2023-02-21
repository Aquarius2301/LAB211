import java.util.Scanner;

/**
 * @author Khang Ta
 */
public class Validation {

    public static Scanner sc = new Scanner(System.in);

    /**
     * Input an integer
     * 
     * @param mes
     * @return an integer which is inputted by user
     * @throws Exception if wrong format or number of element <= 0
     */
    public static int readInt(String mes) throws Exception {
        String s;
        int n;
        System.out.println(mes);
        s = sc.nextLine(); // Read data by Scanner
        if (isNumber(s)) { // if string contains all numbers, convert string to number
            n = Integer.parseInt(s);
            if (n <= 0) { // Notice if the user inputs 0 or a negative number
                throw new Exception("Accept Positive Integer Only!");
            } else {
                return n;
            }
        } else
            throw new Exception("Accept Positive Integer Only!");
    }

    /**
     * Check if all letter in s are digits
     * 
     * @param s
     * @return
     */
    private static boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }
}
