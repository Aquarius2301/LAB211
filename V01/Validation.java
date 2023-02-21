import java.util.Scanner;

/**
 * @author Khang Ta
 */
public class Validation {

    static Scanner sc = new Scanner(System.in);

    /**
     * To input an integer from 0 to 2
     * 
     * @param mes The title of the input
     * @param err The message if user inputs a number out of range
     * @return an integer from 0 to 2
     */
    public static int getInteger(String mes, String err, int a, int b) {
        System.out.print(mes + " ");
        do {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (a <= n && n <= b) {
                    return n;
                } else {
                    System.out.print(err);
                }
            } catch (Exception e) {
                System.out.print(err);
            }
        } while (true);
    }

    /**
     * To input the salary
     * 
     * @param mes The title of the input
     * @param err The message if user inputs a number out of range
     * @return the salary (salary > 100)
     */
    public static double getSalary(String mes, String err) {
        System.out.print(mes + " ");
        do {
            try {
                double n = Double.parseDouble(sc.nextLine());
                if (100 < n) {
                    return n;
                } else {
                    System.out.print(err);
                }
            } catch (Exception e) {
                System.out.print(err);
            }
        } while (true);
    }

    /**
     * To input COE (from 1 to 5)
     * 
     * @param mes The title of the input
     * @param err The message if user inputs a number out of range
     * 
     * @return COE (from 1 to 5)
     */
    public static double getCOE(String mes, String err) {

        System.out.print(mes + " ");
        do {
            try {
                double n = Double.parseDouble(sc.nextLine());
                if (1 <= n && n <= 5) {
                    return n;
                } else {
                    System.out.print(err);
                }
            } catch (Exception e) {
                System.out.print(err);
            }
        } while (true);
    }

    /**
     * To input a string
     * 
     * @param mes the title of the input
     * @return a string (not an empty string)
     */
    public static String getString(String mes) {
        System.out.print(mes + " ");
        do {

            String s = sc.nextLine();
            if (s.trim().equals("")) { // check if the string is empty
                System.out.print("--------Error! Please name again (Not Empty): ");
            } else
                return s;
        } while (true);
    }

    /**
     * To input a string with format NVxxxx
     * 
     * @param mes the title of the input
     * @return an ID (String)
     */
    public static String getID(String mes) {
        System.out.print(mes + " ");
        do {
            String s = sc.nextLine();
            // check format of the String (NVxxxx)
            if (checkID(s))
                return s;
            else
                System.out.print("--------Error! Please ID number again (NVxxxx): ");
        } while (true);

    }

    /**
     * Check the ID.
     * The ID has 6 characters, starts with "NV" and last 4 characters are numbers
     *
     * @param s the ID need to check
     * @return {@code true} if the ID follows the format
     *         <p>
     *         {@code false} if the ID does not follow the format
     */
    private static boolean checkID(String s) {
        if (s.length() == 6 && s.charAt(0) == 'N' && s.charAt(1) == 'V') {
            for (int i = 2; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
