import java.util.Scanner;

public class Validation {

    static Scanner sc = new Scanner(System.in);

    /**
     * To input a string
     * 
     * @param mes the title of the input
     * @return a string
     */
    public static String getString(String mes, String err) {
        System.out.print(mes + " ");
        do {
            String s = sc.nextLine();
            if (s.trim().equals("")) {
                System.out.print(err + " ");
            } else
                return s;
        } while (true);
    }

    /**
     * To input a string
     * 
     * @param mes the title of the input
     * @return a string
     */
    public static String getCode(String mes) {
        System.out.print(mes + " ");
        do {
            String s = sc.nextLine();
            if (s.length() > 6) {
                System.out.print("Error! The length of the code cannot be greater than 6. Please enter again: ");
            } else if (s.trim().equals("")) {
                System.out.print("Error! Please enter code again (not empty): ");
            } else
                return s;
        } while (true);
    }

    /**
     * To input an integer
     * 
     * @param mes The title of the input
     * @param err The message if user inputs a number is smaller than 0
     * @return an integer >= 0
     */
    public static int getInteger(String mes, String err) {

        System.out.print(mes + " ");
        do {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n >= 0) {
                    return n;
                } else {
                    System.out.print(err + " ");
                }
            } catch (Exception e) {
                System.out.print(err + " ");
            }
        } while (true);
    }

    /**
     * input an integer from 1 to 5
     * 
     * @param mes The title of the input
     * @param err The message if user inputs a number out of range
     * @return an integer from 1 to 5
     */
    public static int getChoose(String mes, String err) {
        System.out.print(mes + " ");
        do {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (1 <= n && n <= 5) {
                    return n;
                } else {
                    System.out.print(err + " ");
                }
            } catch (Exception e) {
                System.out.print(err + " ");
            }
        } while (true);
    }
}
