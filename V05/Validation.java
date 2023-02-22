import java.util.Scanner;

public class Validation {

    static Scanner sc = new Scanner(System.in);

    /**
     * To input an integer from a to b
     * 
     * @param mes The title of the input
     * @param err The message if user inputs a number out of range
     * @return an integer from a to b
     */
    public static int getInteger(String mes, String err, int a, int b) {
        System.out.print(mes + " ");
        do {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (a <= n && n <= b) {
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
     * To input a number from a to b
     * 
     * @param mes The title of the input
     * @param err The message if user inputs a number out of range
     * @return a number from a to b
     */
    public static double getDouble(String mes, String err, double a, double b) {
        System.out.print(mes + " ");
        do {
            try {
                double n = Double.parseDouble(sc.nextLine());
                if (a <= n && n <= b) {
                    return n;
                } else {
                    System.out.print(err + " ");
                }
            } catch (Exception e) {
                System.out.print(err + " ");
            }
        } while (true);
    }

    public static String getTwoNum(String mes, String err) {
        System.out.print(mes);
        do {
            String s = sc.nextLine().trim();
            if (!s.equals(""))
                return s;
            else
                System.out.print(err);
        } while (true);
    }
}
