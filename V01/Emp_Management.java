import java.util.ArrayList;

/**
 * @author Khang Ta
 */
public class Emp_Management {

    ArrayList<Employee> employee = new ArrayList<>(); // Contains all employees information
    Employee e = new Employee();
    int numOfEmployee = 0;

    /**
     * Add employee
     */
    private void add() throws Exception {
        // number is a number that user want add employees
        // numOfEmployee is a total number employees
        int number = Validation.getInteger("+ Enter number of Employee:",
                "Error! Please enter a number is greater than 0: ", 1, Integer.MAX_VALUE);
        numOfEmployee += number;
        for (int i = 0; i < number; i++) {
            System.out.println("- Employee " + (i + 1) + ":");
            String id = Validation.getID("--Please enter ID number:");
            do {
                if (!findId(id)) { // if not found the id in the list, add the employee's information
                    e.input();
                    employee.add(new Employee(id, e.getName(), e.getSalary(), e.getCOE()));
                    break;
                } else
                    // otherwise, notice user to input again
                    System.out.print("-----Error! ID has already existed. Please input again:");
                id = Validation.getID("");
            } while (true);

        }
    }

    /**
     * Find the ID
     * 
     * @param id
     * @return {@code true} if found the ID in the list
     *         <p>
     *         {@code false} if not found the ID in the list
     */
    private boolean findId(String id) {
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getId().equals(id))
                return true;
        }
        return false;
    }

    /**
     * Show all employees
     */
    private void show() {
        System.out.println("====================List Employee====================");
        System.out.println("|ID    |Name                |Salary      |COE        ");
        for (int i = 0; i < numOfEmployee; i++) {
            employee.get(i).output();
        }
        System.out.println();
    }

    /**
     * Show the menu and choose option
     * 
     * @throws Exception
     */
    public void menu() throws Exception {
        do {
            System.out.printf("-------MENU-------\n" +
                    "1. Input employee.\n" +
                    "2. Show list employee.\n" +
                    "0. Exit\n");
            int n = Validation.getInteger("Please choose:", "Error! Please enter an integer from 0 to 2: ", 0, 2);
            switch (n) {
                case 1:// add employee
                    add();
                    break;
                case 2:
                    show(); // show employee
                    break;
                case 0:
                    System.out.println("SEE YOU AGAIN!");
                    System.exit(0);
                    break;
            }
        } while (true);
    }

}
