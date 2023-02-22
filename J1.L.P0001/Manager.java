import java.util.ArrayList;
import java.util.Calendar;

public class Manager {
    private ArrayList<Candidate> candidate = new ArrayList<>();
    private int numOfExperience = 0, numOfFresher = 0, numOfInternship = 0;

    /**
     * Constructor
     */
    public Manager() {
    }

    /**
     * Create new candidate
     * <p>
     * ID, Email, Phone must be unique
     * 
     * @param type Candidate type (0: Experience, 1: Fresher, 2: Internship)
     * @throws Exception
     */
    public void createCandidate(int type) throws Exception {
        // (*) means "must be unique"
        char choose;
        do {
            System.out.println();
            // Input ID (*)
            int id;
            do {
                id = Validation.getInteger("Enter ID:", "Error! ID must be an integer from 1 to 99999:", 1, 99999);
                if (!findID(id)) {
                    break;
                } else {
                    System.out.println("Error! This ID has already existed! ");
                }
            } while (true);

            // Input first, last name
            String fname = Validation.getString("Enter First name:",
                    "Error! Please enter the first name again (Not Empty):");
            String lname = Validation.getString("Enter Last name:",
                    "Error! Please enter the last name again (Not Empty):");

            // Input birth date
            int birthDate = Validation.getInteger("Enter Birth date:",
                    "Error! Please enter the birth date (integer) again (from 1900 to "
                            + Calendar.getInstance().get(Calendar.YEAR) + "):",
                    1900, Calendar.getInstance().get(Calendar.YEAR));

            // Input address
            String address = Validation.getString("Enter Address:",
                    "Error! Please enter the address again (Not Empty):");

            // Input phone (*)
            String phone;
            do {
                phone = Validation.getPhone("Enter Phone number:");
                if (!findPhone(phone)) {
                    break;
                } else {
                    System.out.println("Error! This phone number has already existed!");
                }
            } while (true);

            // Input email (*)
            String email;
            do {
                email = Validation.getMail("Enter Email:");
                if (!findMail(email)) {
                    break;
                } else {
                    System.out.println("Error! This Email has already existed!");
                }
            } while (true);

            Candidate candidate = new Candidate(id, fname, lname, birthDate, address, phone, email, type);

            if (type == 0) {
                createExperience(candidate); // create Experience Candidate
            } else if (type == 1) {
                createFresher(candidate);// create Fresher Candidate
            } else
                createInternship(candidate);// create Internship Candidate
            choose = Validation.getChar("\nDo you want to add another candidate now (Y/N)?",
                    "Error! Input 'Y' or 'N':");
        } while (choose == 'Y');

    }

    /**
     * Find phone number in candidate array
     * 
     * @param phone Candidate's phone number
     * @return {@code true} if phone number is existed
     *         <p>
     *         {@code false} if phone number is not existed
     */
    private boolean findPhone(String phone) {
        for (int i = 0; i < candidate.size(); i++) {
            if (candidate.get(i).getPhone().equals(phone))
                return true;
        }
        return false;
    }

    /**
     * Find email in candidate array
     * 
     * @param email Candidate's email
     * @return {@code true} if email is existed
     *         <p>
     *         {@code false} if email is not existed
     */
    private boolean findMail(String email) {
        for (int i = 0; i < candidate.size(); i++) {
            if (candidate.get(i).getEmail().equals(email))
                return true;
        }
        return false;
    }

    /**
     * Find ID in candidate array
     * 
     * @param id Candidate's ID
     * @return
     * @return {@code true} if ID is existed
     *         <p>
     *         {@code false} if ID is not existed
     */
    private boolean findID(int id) {
        for (int i = 0; i < candidate.size(); i++) {
            if (id == candidate.get(i).getCandidateId())
                return true;
        }
        return false;
    }

    /**
     * Create Experience candidate
     * 
     * @param candidate Candidate
     * @throws Exception
     */
    private void createExperience(Candidate candidate) throws Exception {
        // input Experience year, professional skill
        int expYear = Validation.getInteger("Enter Experience Year:",
                "Error! Please enter experience year (integer) from 0 to "
                        + (Calendar.getInstance().get(Calendar.YEAR) - candidate.getBirthDate()) + ":",
                0, Calendar.getInstance().get(Calendar.YEAR) - candidate.getBirthDate());
        String proSkill = Validation.getString("Enter Professional Skills:",
                "Error! Please enter professional skill again (Not Empty):");

        // add information to array
        Experience exp = new Experience(candidate.getCandidateId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), 0,
                expYear, proSkill);

        this.candidate.add(exp);
        numOfExperience++;

        System.out.println("\nCreate successfully");
        System.out.println("Information of this candidate\n");
        showThisCandidate(candidate);
        System.out.println("Experience year       : " + exp.getExpInYear());
        System.out.println("Professional skill    : " + exp.getProSkill());
        System.out.println("Candidate Type        : " + showType(exp.getCandidateType()));

    }

    /**
     * Create Fresher candidate
     * 
     * @param candidate Candidate
     * @throws Exception
     */
    private void createFresher(Candidate candidate) throws Exception {
        // input graduation date, graduation rank, education
        int graduationDate = Validation.getInteger("Enter Graduation Date:",
                "Error! Please enter the graduate date (integer) from " + candidate.getBirthDate() + " to "
                        + Calendar.getInstance().get(Calendar.YEAR) + ":",
                candidate.getBirthDate(), Calendar.getInstance().get(Calendar.YEAR));
        String graduationRank = Validation.getRankString("Enter Graduation Rank:");
        String education = Validation.getString("Enter University Graduation:",
                "Error! Please enter the University again (Not Empty):");
        Fresher fr = new Fresher(candidate.getCandidateId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), 1,
                graduationDate, graduationRank, education);

        // add information to array
        this.candidate.add(fr);
        numOfFresher++;

        System.out.println("\nCreate successfully");
        System.out.println("Information of this candidate\n");
        showThisCandidate(fr);
        System.out.println("Graduation Date       : " + fr.getGraduationDate());
        System.out.println("Graduation Rank       : " + fr.getGraduationRank());
        System.out.println("University Graduation : " + fr.getEducation());
        System.out.println("Candidate Type        : " + showType(fr.getCandidateType()));
    }

    /**
     * Create Internship candidate
     * 
     * @param candidate Candidate
     * @throws Exception
     */
    private void createInternship(Candidate candidate) throws Exception {
        // Input majors, semester, university name
        String majors = Validation.getString("Enter Majors:",
                "Error! Please enter the major again (Not Empty):");
        String semester = Validation.getString("Enter Semester:",
                "Error! Please enter the semester again (Not Empty):");
        String universityName = Validation.getString("Enter University Name:",
                "Error! Please enter the university name again (Not Empty):");

        // add information to array
        Internship in = new Internship(candidate.getCandidateId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), 2,
                majors, semester, universityName);
        this.candidate.add(in);
        numOfInternship++;

        System.out.println("\nCreate successfully");
        System.out.println("Information of this candidate\n");
        showThisCandidate(candidate);
        System.out.println("Majors                : " + in.getMajors());
        System.out.println("Semester              : " + in.getSemester());
        System.out.println("University name       : " + in.getUniversityName());
        System.out.println("Candidate Type        : " + showType(in.getCandidateType()));

    }

    /**
     * Show the information after input
     * 
     * @param candidate the candidate
     */
    private void showThisCandidate(Candidate candidate) {
        System.out.println("ID                    : " + candidate.getCandidateId());
        System.out.println("First name            : " + candidate.getFirstName());
        System.out.println("Last name             : " + candidate.getLastName());
        System.out.println("Birth date            : " + candidate.getBirthDate());
        System.out.println("Address               : " + candidate.getAddress());
        System.out.println("Phone number          : " + candidate.getPhone());
        System.out.println("Email                 : " + candidate.getEmail());
    }

    /**
     * Display all candidates
     * <p>
     * Kind of candidate and fullname
     */
    public void showAllCandidate() {
        System.out.println("\nList of Candidate:");
        // Show Experience Candidate
        if (numOfExperience > 0) {
            System.out.println("======= Experience Candidate =======");
            for (int i = 0; i < candidate.size(); i++) {
                Candidate q = candidate.get(i);
                if (q.getCandidateType() == 0) {
                    System.out.println(q.getFirstName() + " " + q.getLastName());
                }
            }
        }

        // Show Fresher Candidate
        if (numOfFresher > 0) {
            System.out.println("======== Fresher Candidate =========");
            for (int i = 0; i < candidate.size(); i++) {
                Candidate q = candidate.get(i);
                if (q.getCandidateType() == 1) {
                    System.out.println(q.getFirstName() + " " + q.getLastName());
                }
            }
        }

        // Show Internship Candidate
        if (numOfInternship > 0) {
            System.out.println("======= Internship Candidate =======");
            for (int i = 0; i < candidate.size(); i++) {
                Candidate q = candidate.get(i);
                if (q.getCandidateType() == 2) {
                    System.out.println(q.getFirstName() + " " + q.getLastName());
                }
            }
        }

    }

    /**
     * Search candidate by name and type
     */
    public void searchCandidate() {
        if (candidate.isEmpty()) { // Notice if no candidate in database
            System.out.println("\nNo candidate in database!");
        } else {
            boolean isFound = false;

            showAllCandidate(); // display all candidates
            // input name and type
            String name = Validation.getString("\nInput Candidate name (First name or Last name):",
                    "Error! Name can't be empty. Please try again:");
            System.out.println("0: Experience, 1: Fresher, 2: Internship");
            int type = Validation.getInteger("Input type of candidate:", "Error! Please choose an integer from 0 to 2:",
                    0, 2);

            // Find name and print out the information of the candidate
            for (int i = 0; i < candidate.size(); i++) {
                Candidate q = candidate.get(i);
                if (q.getCandidateType() == type && (q.getFirstName().toLowerCase().contains(name.toLowerCase())
                        || q.getLastName().toLowerCase().contains(name.toLowerCase()))) {
                    if (!isFound) {
                        System.out.println("\nThe Candidate found: ");
                        showHeadTable();
                        isFound = true;
                    }
                    System.out.printf("| %-5d | %-25s | %-10d | %-20s | %-10s | %-26s | %-10s |\n", q.getCandidateId(),
                            q.getFirstName() + " " + q.getLastName(), q.getBirthDate(), q.getAddress(), q.getPhone(),
                            q.getEmail(), showType(q.getCandidateType()));
                }
            }

            if (isFound)
                System.out.println(
                        "+-------+---------------------------+------------+----------------------+------------+----------------------------+------------+");
            else
                System.out.println("Not found this name in this type");

        }
        System.out.println();
    }

    /**
     * Show Candidate type
     * 
     * @param type Candidate type
     * @return Candidate type depend on type (0: Experience, 1: Fresher, 2:
     *         Internship)
     */
    private String showType(int type) {
        switch (type) {
            case 0:
                return "Experience";

            case 1:
                return "Fresher";

            case 2:
                return "Internship";  
        }
        return "";
    }

    /**
     * Display head table
     */
    private void showHeadTable() {
        System.out.println(
                "+-------+---------------------------+------------+----------------------+------------+----------------------------+------------+");
        System.out.println(
                "|  ID   |         Fullname          | Birth Date |        Address       |    Phone   |            Email           |    Type    |");
        System.out.println(
                "+-------+---------------------------+------------+----------------------+------------+----------------------------+------------+");
    }

}