public class App {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        try {
            MyArray a = new MyArray();
            int choose;
            do {
                System.out.println("========= Bubble Sort program =========");
                System.out.println("1. Input Element");
                System.out.println("2. Sort Ascending");
                System.out.println("3. Sort Descending");
                System.out.println("4. Exit");
                // Choose Option
                choose = Validation.getChoose("Please choose one option:", "Please input an integer from 1 to 4");
                switch (choose) {
                    case 1:
                        System.out.println("\nInput Length Of Array");
                        // Input the length of array

                        int length = Validation.getLength("Enter Number:",
                                "Please input number and number is greater than zero");

                        a.setN(length);

                        // Read value of each elements
                        for (int i = 0; i < length; i++) {
                            int n = Validation.getNum("Enter Number " + (i + 1) + ":",
                                    "Please input an integer");
                            a.add(n);
                        }
                        break;

                    case 2:// Sort ascending
                        System.out.println("----- Ascending -----");
                        System.out.println(a.showAscendingArray() + "\n");
                        break;

                    case 3:// Sort descending
                        System.out.println("----- Descending -----");
                        System.out.println(a.showDescendingArray() + "\n");
                        break;

                    case 4:// Exit
                        System.exit(0);
                        break;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
