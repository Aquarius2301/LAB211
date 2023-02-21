
public class App {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        try {
            do {
                int choose;
                Calculator cal = new Calculator();
                System.out.println("======= Calculator Program =======");
                System.out.println("1. Normal Calculator");
                System.out.println("2. BMI Calculator");
                System.out.println("3. Exit");
                choose = Validation.getChoose("Please choice one option:",
                        "Please input an integer number from 1 to 3: ");
                switch (choose) {
                    case 1:
                        cal.normalCalc();
                        break;
                    case 2:
                        cal.bmiCalc();
                        break;
                    case 3:
                        System.exit(0);
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
