import java.util.Scanner;

public class Validation {
    public static Scanner sc = new Scanner(System.in);

    /**
     * get a number
     * 
     * @param mes                   title
     * @param acceptNegativeAndZero
     *                              <p>
     *                              {@code true} the number is positive, negative
     *                              number
     *                              or 0
     *                              <p>
     *                              {@code false} the number is positive number.
     * @return a number which is inputted by user
     */
    public static double getNum(String mes, boolean acceptNegativeAndZero) {
        do {
            System.out.print(mes + " ");
            try {
                double n = Double.parseDouble(sc.nextLine());
                if (!acceptNegativeAndZero && n <= 0) {
                    System.out.println("Please enter a number greater than 0");
                } else
                    return n;
            } catch (Exception e) {
                System.out.println("Please enter a number greater than 0");
            }
        } while (true);
    }

    /**
     * Get the operator which is inputted by user
     * 
     * @return the operator (+, -, *, /, ^, =)
     */
    public static char getChar(String mes) {
        do {
            System.out.print(mes + " ");
            try {
                String s = sc.nextLine();
                if (s.trim().equals("+") || s.trim().equals("-") || s.trim().equals("*") || s.trim().equals("/")
                        || s.trim().equals("^") || s.trim().equals("="))
                    return s.charAt(0);
                else
                    System.out.println("Please input (+, -, *, /, ^). Enter = to exit the function");
            } catch (Exception e) {
                System.out.println("Please input (+, -, *, /, ^). Enter = to exit the function");
            }
        } while (true);
    }

    /**
     * To input an integer from 1 to 3
     * 
     * @param mes The title of the input
     * @param err The message if user inputs a number out of range
     * @return an integer from 1 to 3
     */
    public static int getChoose(String mes, String err) {
        System.out.print(mes + " ");
        do {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (1 <= n && n <= 3) {
                    return n;
                } else {
                    System.out.print(err);
                }
            } catch (Exception e) {
                System.out.print(err);
            }
        } while (true);
    }

}
