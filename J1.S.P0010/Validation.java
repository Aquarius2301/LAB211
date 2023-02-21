import java.util.Scanner;

public class Validation {
    static Scanner sc = new Scanner(System.in);

    /**
     * input a length of array
     * 
     * @param mes title of input
     * @param err print out if user input a number smaller than or equal to 0
     * @return the length of array
     */
    public static int getLength(String mes, String err) {
        do {
            System.out.print(mes + " ");
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n <= 0)
                    System.out.println(err);
                else
                    return n;
            } catch (Exception e) {
                System.out.println(err);
            }
        } while (true);
    }

    /**
     * input an integer
     * 
     * @param mes title of input
     * @param err print out if user input not a number
     * @return an integer number
     */
    public static int getNum(String mes, String err) {
        do {
            System.out.print(mes + " ");
            try {
                int n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(err);
            }
        } while (true);
    }

    /**
     * input an integer from 1 to 4
     * 
     * @param mes title of input
     * @param err print out if user input a number out of range (from 1 to 4)
     * @return
     */
    public static int getChoose(String mes, String err) {
        do {
            System.out.print(mes + " ");
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < 1 || n > 4)
                    System.out.println(err);
                else
                    return n;
            } catch (Exception e) {
                System.out.println(err);
            }
        } while (true);
    }

}
