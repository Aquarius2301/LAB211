public class App {
    /**
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        LuckyNumber luckyNumber = new LuckyNumber();
        System.out.println("======== LUCKY NUMBER ========");
        do {
            luckyNumber.play();
            String choose = Validation.getString("Do you want to continue (y/n)?",
                    "Error! Please enter y or n");
            if (choose.equalsIgnoreCase("n")) {
                break;
            }
        } while (true);
        System.out.println("\n----------- Result  -----------");
        luckyNumber.report();
    }
}
