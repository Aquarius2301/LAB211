public class BaseNumber {
    private String s;
    private int inpType, outType;
    private long decimal = 0;

    /**
     * Constructor
     */
    public BaseNumber() {
    }

    /**
     * check and set the input type
     * <p>
     * 1: Binary, 2: Decimal, 3: Hexadecimal
     * 
     * @param inpType the input type
     * @throws Exception if input type is not between 1 to 3
     */
    public void setInpType(int inpType) throws Exception {
        if (1 <= inpType && inpType <= 3)
            this.inpType = inpType;
        else
            throw new Exception("Input type must be from 1 to 3.");
    }

    /**
     * check and set the output type
     * <p>
     * 1: Binary, 2: Decimal, 3: Hexadecimal
     * 
     * @param outType the output type
     * @throws Exception if output type is not between 1 to 3
     */
    public void setOutType(int outType) throws Exception {
        if (1 <= outType && outType <= 3)
            this.outType = outType;
        else
            throw new Exception("Output type must be from 1 to 3.");
    }

    /**
     * check and set the string value
     * 
     * @param s       the value to set (binary, decimal or hexadecimal)
     * @param inpType the input type check
     * @throws Exception if s is wrong format (format depends on the inpType)
     */
    public void setS(String s) throws Exception {
        if (s.trim() != "") {
            switch (inpType) {
                case 1:
                    setBinary(s); // base 2
                case 2:
                    setDecimal(s); // base 10
                case 3:
                    setHexadecimal(s); // base 16
            }
            this.s = s;
        }
    }

    /**
     * check string if it is follow the base 2 format
     * 
     * @param s the string need to check
     * @throws Exception if s is not follow the base 2 format
     */
    private void setBinary(String s) throws Exception {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0' && s.charAt(i) != '1') {
                throw new Exception("This string is wrong format");
            }
        }
    }

    /**
     * check string if it is follow the base 10 format
     * 
     * @param s the string need to check
     * @throws Exception if s is not follow the base 10 format
     */
    private void setDecimal(String s) throws Exception {
        for (int i = 0; i < s.length(); i++) {
            if ('0' > s.charAt(i) || s.charAt(i) > '9') {
                throw new Exception("This string is wrong format");
            }
        }
    }

    /**
     * check string if it is follow the base 16 format
     * 
     * @param s the string need to check
     * @throws Exception if s is not follow the base 16 format
     */
    private void setHexadecimal(String s) throws Exception {
        for (int i = 0; i < s.length(); i++) {
            if (('0' <= s.charAt(i) && s.charAt(i) <= '9') || ('A' <= s.charAt(i) && s.charAt(i) <= 'F')) {
                continue;
            } else
                throw new Exception("This string is wrong format");
        }
    }

    /**
     * Convert decimal to base 2, 10 or 16
     * 
     * @return binary, decimal or hexadecimal number
     */
    private String convertToAnswer() {
        decimal = convertToDecimal();
        int base = 0; // convert outType to base
        switch (outType) {
            case 1:
                base = 2;
                break;
            case 2:
                base = 10;
                break;
            case 3:
                base = 16;
                break;
        }
        // Start converting
        String res = "";
        while (decimal != 0) {
            long t = decimal % base;
            decimal /= base;
            if (t <= 9)
                res = String.valueOf(t) + res;
            else {
                if (t == 10)
                    res = 'A' + res;
                else if (t == 11)
                    res = 'B' + res;
                else if (t == 12)
                    res = 'C' + res;
                else if (t == 13)
                    res = 'D' + res;
                else if (t == 14)
                    res = 'E' + res;
                else if (t == 15)
                    res = 'F' + res;
            }
        }
        return res;
    }

    /**
     * Convert base 2, 10 or 16 to decimal depends on inpType
     * 
     * @return decimal number
     */
    private long convertToDecimal() {
        if (inpType == 1)
            return convertBinToDec(s);

        if (inpType == 2)
            return Long.parseLong(s);

        return convertHexToDec(s);

    }

    /**
     * Convert Binary to Decimal
     * 
     * @param s the string need convert to decimal
     * @return a decimal number
     */
    private long convertBinToDec(String s) {
        long decimal = 0L;
        int t = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                decimal += pow(2, t);
            }
            t++;
        }
        return decimal;
    }

    /**
     * Convert Hexadecimal to Decimal
     * 
     * @param s the string need convert to decimal
     * @return a decimal number
     */
    private long convertHexToDec(String s) {
        long decimal = 0L;
        int t = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                decimal += pow(16, t) * (s.charAt(i) - 48);
            } else
                decimal += pow(16, t) * (s.charAt(i) - 55);
            t++;
        }
        return decimal;
    }

    /**
     * Compute n^x
     * 
     * @param n the base
     * @param x the exponent
     * @return n to the power of x (long)
     */
    private long pow(int n, int x) {
        long res = 1L;
        for (int i = 1; i <= x; i++) {
            res *= n;
        }
        return res;
    }

    @Override
    /**
     * return the answer
     * 
     * @return the answer
     */
    public String toString() {
        return convertToAnswer();
    }

}
