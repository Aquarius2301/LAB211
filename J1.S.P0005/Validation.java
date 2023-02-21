import java.util.Scanner;

/**
 * @author Khang Ta
 */
public class Validation {

    public static Scanner sc = new Scanner(System.in);

    /**
     * input the string
     * 
     * @param mes
     * @return
     */
    public static String readString(String mes) {
        System.out.println(mes);
        String s = sc.nextLine(); // Read data by using Scanner
        sc.close(); // Close scanner
        return s;
    }
}
