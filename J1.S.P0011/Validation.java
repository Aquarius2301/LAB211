import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {

    public static Scanner sc = new Scanner(System.in);

    /**
     * To input an integer from a to b
     * 
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
     * Input a string
     * 
     * @param mes The title of the input
     * @param err The message if user inputs an empty string
     * @return a string (not an empty string)
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
     * Input a Vietnamese phone number
     * <p>
     * Phone number format
     * <p>
     * 0912345678
     * <p>
     * 091-234-5678
     * <p>
     * 091-234-5678 x1234
     * <p>
     * 091-234-5678 ext1234
     * <p>
     * (091)-234-5678
     * <p>
     * 091.234.5678
     * <p>
     * 091 234 5678
     * <p>
     * 
     * @param mes The title of the input
     * @return phone number follow the format
     */
    public static String getPhone(String mes) {
        Pattern p = Pattern.compile("^(09|08|07|05|03)\\d{8}");
        Pattern p2 = Pattern.compile("^(09|08|07|05|03)\\d{1}-\\d{3}-\\d{4}");
        Pattern p3 = Pattern.compile("^(09|08|07|05|03)\\d{1}\\-\\d{3}\\-\\d{4} (x|ext)//d{4}");
        Pattern p4 = Pattern.compile("^(\\((09|08|07|05|03))\\d{1}\\)-\\d{3}-\\d{4}");
        Pattern p5 = Pattern.compile("^(09|08|07|05|03)\\d{1}\\.\\d{3}\\.\\d{4}");
        Pattern p6 = Pattern.compile("^(09|08|07|05|03)\\d{1} \\d{3} \\d{4}");
        String phone;
        do {
            System.out.print(mes + " ");
            phone = sc.nextLine().trim();
            if (p.matcher(phone).matches() || p2.matcher(phone).matches() || p3.matcher(phone).matches()
                    || p4.matcher(phone).matches() || p5.matcher(phone).matches() || p6.matcher(phone).matches())
                break;
            else {
                System.out.println("Please input Vietnamese phone number follow");
                System.out.println("# 0912345678");
                System.out.println("# 091-234-5678");
                System.out.println("# 091-234-5678 x1234");
                System.out.println("# 091-234-5678 ext1234");
                System.out.println("# (091)-234-5678");
                System.out.println("# 091.234.5678");
                System.out.println("# 091 234 5678");
            }
        } while (true);

        return phone;
    }
}
