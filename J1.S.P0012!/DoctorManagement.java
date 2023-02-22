import java.util.HashMap;

public class DoctorManagement {
    private HashMap<String, Doctor> doctor = new HashMap<>();

    /**
     * add a doctor
     */
    public void addDoctor() {
        String code;
        do {
            code = Validation.getCode("Enter Code:").trim().toUpperCase();
            if (!doctor.containsKey(code))
                break;
            else
                System.out.println("The code has already existed!");
        } while (true);
        String name = Validation.getString("Enter Name:", "Error! Please enter the name again (not empty):").trim();
        String spec = Validation
                .getString("Enter Specialization:", "Error! Please enter the specialization (not empty):")
                .trim();
        int avail = Validation.getInteger("Enter Availability:",
                "Error! Please enter the availability (an integer >= 0):");

        doctor.put(code, new Doctor(name, spec, avail));
        System.out.println("Add successfully\n");
    }

    /**
     * show all doctor and update a doctor
     */
    public void updateDoctor() {
        if (doctor.isEmpty())// if no doctor in DB, can't execute this function
            System.out.println("No doctor in the database!");
        else {
            showAllDoctor();
            String code;
            do {
                code = Validation.getString("Enter Code:", "Error! Please enter the code again (not empty):")
                        .trim().toUpperCase();
                if (doctor.containsKey(code))
                    break;
                else
                    System.out.println("The code must be in Database");
            } while (true);
            String name = Validation.getString("Enter Name:", "Error! Please enter the name again (not empty):").trim();
            String spec = Validation
                    .getString("Enter Specialization:", "Error! Please enter the specialization (not empty):")
                    .trim();
            int avail = Validation.getInteger("Enter Availability:",
                    "Error! Please enter the availability (an integer >= 0):");
            doctor.replace(code, new Doctor(name, spec, avail));
            System.out.println("Update successfully");
        }
        System.out.println();
    }

    /**
     * show all doctor and delete a doctor
     */
    public void deleteDoctor() {
        if (doctor.isEmpty())// if no doctor in DB, can't execute this function
            System.out.println("No doctor in the database!");
        else {
            showAllDoctor();
            String code;
            do {
                code = Validation.getString("Enter Code:", "Error! Please enter the code again (not empty):")
                        .trim().toUpperCase();
                if (doctor.containsKey(code))
                    break;
                else
                    System.out.println("The code is not in the database");
            } while (true);
            doctor.remove(code);
            System.out.println("Delete successfully");
        }
        System.out.println();
    }

    /**
     * show all doctor and search doctor by name
     */
    public void searchDoctor() {
        if (doctor.isEmpty()) // if no doctor in DB, can't execute this function
            System.out.println("No doctor in the database!");
        else {
            showAllDoctor();
            boolean isExist = false;
            String s = Validation.getString("Enter name:", "Error! Please enter name again (Not Empty): ").trim()
                    .toLowerCase();
            System.out.println("######### Result #########");
            for (String i : doctor.keySet()) {
                if (doctor.get(i).getName().toLowerCase().contains(s)) {
                    if (!isExist) {
                        System.out.println("+--------+----------------------------+----------------+--------------+");
                        System.out.println("|  Code  | Name                       | Specialization | Availability |");
                        System.out.println("+--------+----------------------------+----------------+--------------+");
                        isExist = true;
                    }
                    System.out.println(doctor.get(i).showDoctor(i));
                }
            }
            if (isExist) {
                System.out.println("+--------+----------------------------+----------------+--------------+");
            } else
                System.out.println("The name is not in database");
        }
        System.out.println();
    }

    /**
     * show all doctors
     */
    public void showAllDoctor() {
        System.out.println("+--------+----------------------------+----------------+--------------+");
        System.out.println("|  Code  | Name                       | Specialization | Availability |");
        System.out.println("+--------+----------------------------+----------------+--------------+");
        for (String i : doctor.keySet()) {
            System.out.println(doctor.get(i).showDoctor(i));
        }
        System.out.println("+--------+----------------------------+----------------+--------------+");

    }
}
