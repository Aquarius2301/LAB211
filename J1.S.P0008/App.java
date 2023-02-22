
public class App {

    /**
     * @param args
     * @throws Exception
     * 
     */
    public static void main(String[] args) {
        try {
            System.out.println("1. Binary, 2. Decimal, 3. Hexadecimal");
            BaseNumber baseNumber = new BaseNumber();
            do {
                String answer = "";
                int inpType = Validation.readInt("Enter input type:",
                        "Error! Input type must be an integer form 1 to 3.");
                baseNumber.setInpType(inpType);

                int outType = Validation.readInt("Enter output type:",
                        "Error! Input type must be an integer form 1 to 3.");
                baseNumber.setOutType(outType);
                String s = "";
                boolean isValid = true;
                // check the validate
                switch (inpType) {
                    case 1:
                        do {
                            isValid = true;
                            s = Validation.readString("Enter the binary number:", "Error! The binary can't be empty.");
                            for (int i = 0; i < s.length(); i++) {
                                if (s.charAt(i) != '0' && s.charAt(i) != '1') {
                                    isValid = false;
                                    break;
                                }
                            }
                            if (isValid)
                                break;
                            else
                                System.out.println("Error! The binary number is wrong format");
                        } while (true);
                        answer = s + "(2) = ";
                        break;
                    case 2:
                        do {
                            isValid = true;
                            s = Validation.readString("Enter the decimal number:",
                                    "Error! The decimal can't be empty.");
                            for (int i = 0; i < s.length(); i++) {
                                if ('0' > s.charAt(i) || s.charAt(i) > '9') {
                                    isValid = false;
                                    break;
                                }
                            }
                            if (isValid)
                                break;
                            else
                                System.out.println("Error! The decimal number is wrong format");
                        } while (true);
                        answer = s + "(10) = ";
                        break;
                    case 3:
                        do {
                            isValid = true;
                            s = Validation.readString("Enter the hexadecimal number:",
                                    "Error! The hexadecimal can't be empty.");
                            for (int i = 0; i < s.length(); i++) {
                                if (('0' <= s.charAt(i) && s.charAt(i) <= '9')
                                        || ('A' <= s.charAt(i) && s.charAt(i) <= 'F')) {
                                    continue;
                                } else {
                                    isValid = false;
                                    break;
                                }
                            }
                            if (isValid)
                                break;
                            else
                                System.out.println("Error! The hexadecimal number is wrong format");
                        } while (true);

                        answer = s + "(16) = ";
                        break;
                }
                baseNumber.setS(s);
                // display the result
                switch (outType) {
                    case 1:
                        answer += baseNumber + "(2)";
                        break;
                    case 2:
                        answer += baseNumber + "(10)";
                        break;
                    case 3:
                        answer += baseNumber + "(16)";
                        break;
                }

                System.out.println("Result: " + answer);
                char exit = Validation.readChar("Do you want to continue (Y/N)?", "Error! Please enter 'Y' or 'N'");
                System.out.println();
                if (exit == 'n' || exit == 'N')
                    break;
            } while (true);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
