public class Calculator {
    /**
     * Constructor
     */
    public Calculator() {
    }

    /**
     * Normal Calculator
     */
    public void normalCalc() {
        double a, b;
        char operator;
        System.out.println("------ Normal Calculator -----");
        a = Validation.getNum("Enter number:", true); // Enter the first number
        do {
            operator = Validation.getChar("Enter Operator:"); // Enter the second number
            if (operator != '=') {
                b = Validation.getNum("Enter number:", true); // Enter the first number
                if (operator == '+') {
                    a += b;
                } else if (operator == '-') {
                    a -= b;
                } else if (operator == '*') {
                    a *= b;
                } else if (operator == '/') {
                    if (b == 0) {
                        System.out.println("The divisor can't be 0!");
                    } else
                        a /= b;
                } else if (operator == '^') {
                    a = Math.pow(a, b);
                }
            } else
                break;
            System.out.println("Memory: " + a);
        } while (true);
        System.out.println("Result: " + a);
    }

    /**
     * BMI Calculator
     */
    public void bmiCalc() {
        double weight, height, bmi;
        System.out.println("------ BMI Calculator -----");
        weight = Validation.getNum("Enter Weight(kg):", false); // enter weight and height
        height = Validation.getNum("Enter Height(cm):", false);
        height /= 100; // convert cm to m
        bmi = weight / (height * height); // compute BMI
        System.out.printf("BMI Number: %.1f\n", bmi);
        System.out.print("BMI Status: "); // BMI status
        if (bmi < 19)
            System.out.println("Under-standard");
        else if (bmi <= 25)
            System.out.println("Standard");
        else if (bmi <= 30)
            System.out.println("Overweight");
        else if (bmi <= 40)
            System.out.println("Fat");
        else
            System.out.println("Very fat");
    }

}