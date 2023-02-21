/**
 * @author Khang Ta
 */

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            Emp_Management emp = new Emp_Management();
            emp.menu();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
