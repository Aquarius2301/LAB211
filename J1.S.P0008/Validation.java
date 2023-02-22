import java.util.Scanner;

public class Validation {
    static Scanner sc = new Scanner(System.in);

    /**
     * input the string
     * 
     * @param mes
     * @return
     */
    public static String readString(String mes, String err) {
        do {
            System.out.print(mes + " ");
            String s = sc.nextLine().trim(); // Read data by using Scanner
            if (s.equals(""))
                System.out.println(err);
            else
                return s.toUpperCase();
        } while (true);
    }

    /**
     * Input an integer
     * 
     * @param mes
     * @return an integer which is inputted by user
     */
    public static int readInt(String mes, String err) {
        do {
            System.out.print(mes + " ");
            try {// Read data by Scanner
                int n = Integer.parseInt(sc.nextLine());
                if (n < 1 || n > 3) { // Notice if the user inputs 0 or a negative number
                    System.out.println(err);
                } else {
                    return n;
                }
            } catch (Exception e) {
                System.out.println(err);
            }
        } while (true);
    }

    /**
     * Read a char
     * 
     * @param mes title of the input
     * @param err Notice if user input wrong format
     * @return y, Y, n or N (char)
     */
    public static char readChar(String mes, String err) {
        do {
            System.out.print(mes + " ");
            String s = sc.nextLine().trim(); // Read data by using Scanner
            if (s.equalsIgnoreCase("y") || s.trim().equalsIgnoreCase("n"))
                return s.charAt(0);
            else
                System.out.println(err);
        } while (true);
    }

}
