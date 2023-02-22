import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {

    static Scanner sc = new Scanner(System.in);

    /**
     * To input an integer from a to b (a is smaller than b)
     * 
     * @param mes The title of the input
     * @param err The message if user inputs a number out of range
     * @param a
     * @param b
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
     * To input a string
     * 
     * @param mes the title of the input
     * @return a string (not an empty string)
     */
    public static String getString(String mes, String err) {
        System.out.print(mes + " ");
        do {
            String s = sc.nextLine().trim();
            if (s.trim().equals("")) {
                System.out.print(err + " ");
            } else
                return s;
        } while (true);
    }

    /**
     * To input a character
     * 
     * @param mes the title of the input
     * @return a character
     */
    public static char getChar(String mes, String err) {
        System.out.print(mes + " ");
        do {
            String s = sc.nextLine();
            if (s.trim().equals("")) {
                System.out.print(err + " ");
            } else if (s.equals("Y") || s.equals("N") || s.equals("y") || s.equals("n"))
                return s.toUpperCase().charAt(0);
            else {
                System.out.print(err + " ");
            }
        } while (true);
    }

    /**
     * To input a phone number
     * 
     * @param mes the title of the input
     * @return the phone number
     */
    public static String getPhone(String mes) {
        System.out.print(mes);
        do {
            String phone = Validation.getString("",
                    "Error! Please enter the phone number again (Not Empty):").trim();
            if (isValidatedPhone(phone)) {
                return phone;
            }
        } while (true);
    }

    /**
     * To input an Email
     * 
     * @param mes the title of the input
     * @return the Email
     */
    public static String getMail(String mes) {
        System.out.print(mes);
        do {
            String email = Validation.getString("",
                    "Error! Please enter the email again (Not Empty):").trim();
            if (isValidatedEmail(email)) {
                return email.toLowerCase();
            } else {
                System.out.println("Error! Email must be follow the format <username>@<domain>");
                System.out.println("- Username must contain letters, numbers or ._%+-");
                System.out.println("- Domain must contain letters, number or .-");
                System.out.println("- TLD must be more than two letters ");
                System.out.println("- Example: ab%c@gmail.com.vn");
                System.out.print("Please enter again:");
            }
        } while (true);

    }

    /**
     * Check phone number
     * <p>
     * Phone number is valid if it has at least 10 digits and it is Vietnamese phone
     * number (start with 09, 08, 07, 05 or 03 and more 8 digits)
     * 
     * @param phone Candidate's phone number
     * @return {@code true} if phone number is valid
     *         <p>
     *         {@code false} if phone number is not valid
     */
    private static boolean isValidatedPhone(String phone) {
        String pattern = "^(09|08|07|05|03)\\d{8}$";
        Pattern p = Pattern.compile(pattern);
        if (p.matcher(phone).matches()) {
            return true;
        }
        System.out.print("Error! Phone number must be a Vietnamese phone number (Ex: 0912345678). Please input again:");
        return false;
    }

    /**
     * Check email
     * <p>
     * Email is valid if it follows format <username>@<domain>
     * <p>
     * Username accepts ._%+- and domain accepts . an d -
     * <p>
     * TLD's must be two or more letters
     * <p>
     * Ex. abc@gmail.com
     * 
     * @param email Candidate's email
     * @return {@code true} if email is valid
     *         <p>
     *         {@code false} if email is not valid
     */
    private static boolean isValidatedEmail(String email) {
        String regexPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.compile(regexPattern).matcher(email).matches();
    }

    /**
     * input the graduation rank
     * 
     * @param mes title of the input
     * @return a string (excellent, good, fair or poor)
     */
    public static String getRankString(String mes) {
        System.out.print(mes);
        do {
            String rank = Validation.getString("",
                    "Error! Please enter the rank (Not Empty):").toLowerCase().trim();
            if (rank.equals("excellent") || rank.equals("good") || rank.equals("fair")
                    || rank.equals("poor")) {
                return rank.toLowerCase();
            } else
                System.out.print("Error! Please enter the rank (Excellent, Good, Fair or Poor):");
        } while (true);
    }
}