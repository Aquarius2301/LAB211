public class App {
    /**
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Manager manager = new Manager();
        do {
            try {
                System.out.println("CANDIDATE MANAGEMENT SYSTEM");
                System.out.println("1. Experience");
                System.out.println("2. Fresher");
                System.out.println("3. Internship");
                System.out.println("4. Searching");
                System.out.println("5. Exit");

                int choose = Validation.getInteger("Please choose:", "Error! Please choose an integer from 1 to 5:", 1,
                        5);
                switch (choose) {
                    case 1:
                        manager.createCandidate(0);
                        break;
                    case 2:
                        manager.createCandidate(1);
                        break;
                    case 3:
                        manager.createCandidate(2);
                        break;
                    case 4:
                        manager.searchCandidate();
                        break;
                    case 5:
                        System.out.println("See you again!");
                        System.exit(0);
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);
        // Phone, email, id must be unique
    }
}
