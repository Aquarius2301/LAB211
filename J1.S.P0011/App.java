public class App {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ContactManagement cont = new ContactManagement();
        try {
            do {
                System.out.println("======= Contact Management =======");
                System.out.println("1. Add a contact");
                System.out.println("2. Display all contacts");
                System.out.println("3. Delete a contact");
                System.out.println("4. Exit");
                int choose = Validation.getInteger("Please choose:", "Error! Please enter an integer from 1 to 4:", 1,
                        4);
                switch (choose) {
                    case 1:
                        // Add a contact
                        System.out.println("######## Add a Contact ########\n");
                        cont.addContact();
                        break;
                    case 2:
                        // Display all contacts
                        System.out.println(
                                "################################### Display all Contact ##################################\n");
                        cont.displayContact();
                        break;
                    case 3:
                        // Delete a contact
                        System.out.println("######## Delete a Contact ########\n");
                        cont.deleteContact();
                        break;
                    case 4:
                        System.exit(0);
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
