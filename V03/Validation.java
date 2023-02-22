import java.util.Scanner;

public class Validation {

    static Scanner sc = new Scanner(System.in);

    /**
     * To input an integer from a to b
     * 
     * @param mes The title of the input
     * @param err The message if user inputs a number out of range
     * @param a   The first number
     * @param b   The second number
     * @return an integer from a to b
     */
    public static int getInteger(String mes, String err, int a, int b) {
        do {
            System.out.print(mes + " ");
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (a <= n && n <= b) {
                    return n;
                } else {
                    System.out.println(err);
                }
            } catch (Exception e) {
                System.out.println(err);
            }
        } while (true);
    }

    /**
     * Input a string
     * 
     * @param mes The title of the input
     * @param err The message if user inputs an empty string
     * @return string (not a empty string)
     */
    public static String getString(String mes, String err) {
        do {
            System.out.print(mes + " ");
            String s = sc.nextLine().trim();
            if (s.equalsIgnoreCase("y") || s.equalsIgnoreCase("n")) {
                return s;
            } else
                System.out.println(err);
        } while (true);
    }
}
