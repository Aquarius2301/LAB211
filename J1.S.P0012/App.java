public class App {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        DoctorManagement doc = new DoctorManagement();
        try {
            do {
                System.out.println("======== Doctor Management ========");
                System.out.println("1. Add Doctor");
                System.out.println("2. Update Doctor");
                System.out.println("3. Delete Doctor");
                System.out.println("4. Search Doctor");
                System.out.println("5. Exit");
                int choose = Validation.getChoose("Choose option:", "Error! Please enter an integer from 1 to 5:");

                switch (choose) {
                    case 1:
                        // add a doctor
                        System.out.println("\n-------- Add Doctor --------");
                        doc.addDoctor();
                        break;
                    case 2:
                        // update a doctor
                        System.out.println("\n------- Update Doctor ------\n");
                        doc.updateDoctor();
                        break;
                    case 3:
                        // delete a doctor
                        System.out.println("\n------- Delete Doctor ------\n");
                        doc.deleteDoctor();
                        break;
                    case 4:
                        // search a doctor
                        System.out.println("\n------- Search Doctor ------\n");
                        doc.searchDoctor();
                        break;
                    case 5:
                        // exit
                        System.exit(0);
                }

            } while (true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
