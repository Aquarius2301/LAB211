/**
 * @author Khang Ta
 */
public class Employee {
    private String id;
    private String name;
    private double salary;
    private double COE;

    /**
     * Constructor with no parameter
     */
    public Employee() {

    }

    /**
     * Constructor with parameters
     * 
     * @param id     the ID of an employee
     * @param name   the name of an employee
     * @param salary the salary of an employee
     * @param COE    the coefficients salary of an employee
     * @throws Exception
     */
    public Employee(String id, String name, double salary, double COE) throws Exception {
        setId(id);
        setName(name);
        setSalary(salary);
        setCOE(COE);
    }

    /**
     * Compute the Salary
     * 
     * @return the Salary of an employee
     */
    public double calSalary() {
        return salary * COE;
    }

    /**
     * input the information
     */
    public void input() {
        String name = Validation.getString("--Please enter name:");
        double salary = Validation.getSalary("--Please enter salary:",
                "--------Error! Please salary again (Salary > 100 USD): ");
        double COE = Validation.getCOE("--Please enter coefficients salary:",
                "-----Error! Please coefficients salary again (From 1 to 5): ");
        System.out.println("");

        this.name = name;
        this.salary = salary;
        this.COE = COE;
    }

    /**
     * Print out the information of an employee
     */
    public void output() {
        System.out.printf("|%-6s|%-20s|%-12.0f|%-11.0f\n", id, name, salary, COE);
    }

    /**
     * Get the ID of an employee
     * 
     * @return the ID of an employee
     */
    public String getId() {
        return this.id;
    }

    /**
     * Get the Name of an employee
     * 
     * @return the Name of an employee
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the Salary of an employee
     * 
     * @return the Salary of an employee
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * Get the COE of an employee
     * 
     * @return the Coefficients salary of an employee
     */
    public double getCOE() {
        return this.COE;
    }

    /**
     * Check and set the ID
     * 
     * @param id the ID of an employee
     * @throws Exception if the id is not follow format NVxxxx
     */
    public void setId(String id) throws Exception {
        if (checkID(id))
            this.id = id;
        else
            throw new Exception("The ID must be follow format \"NVxxxx\"");
    }

    /**
     * Check the ID if all characters after "NV" are digits .
     *
     * @param s the ID need to check
     * @return {@code true} if all characters are digits
     *         <p>
     *         {@code false} if a character is not a digit
     */
    private boolean checkID(String s) {
        if (s.length() == 6 && s.charAt(0) == 'N' && s.charAt(1) == 'V') {
            for (int i = 2; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Check and set the name
     * 
     * @param name the name of an employee
     * @throws Exception if the name is empty
     */
    public void setName(String name) throws Exception {
        if (name.trim() != "") {
            this.name = name;
        } else
            throw new Exception("The name must not be empty");
    }

    /**
     * Check and set the salary
     * 
     * @param salary the salary of an employee
     * @throws Exception if the salary < 100
     */
    public void setSalary(double salary) throws Exception {
        if (salary > 100) {
            this.salary = salary;
        } else
            throw new Exception("The salary must be greater than 100");
    }

    /**
     * Check and set the coefficients salary
     * 
     * @param COE the coefficient salary of an employee     
     * @throws Exception if the coefficients salary is out of 1 to 5
     */
    public void setCOE(double COE) throws Exception {
        if (1 <= COE && COE <= 5) {
            this.COE = COE;
        } else
            throw new Exception("The coefficients salary must be from 1 to 5");
    }
}
