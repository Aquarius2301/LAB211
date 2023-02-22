public class Internship extends Candidate {
    private String majors;
    private String semester;
    private String universityName;

    /**
     * constructor
     */
    public Internship() {
        super();
    }

    /**
     * constructor
     * 
     * @param candidateId    Candidate's ID
     * @param firstName      Candidate's first name
     * @param lastName       Candidate's last name
     * @param birthDate      Candidate's birth date (year)
     * @param address        Candidate's address
     * @param phone          Candidate's phone
     * @param email          Candidate's email
     * @param candidateType  Candidate Type (0: Experience, 1: Fresher, 2:
     *                       Internship)
     * @param majors         Candidate's major
     * @param semester       Semester
     * @param universityName Candidate's University
     * @throws Exception
     */
    public Internship(int candidateId, String firstName, String lastName, int birthDate, String address, String phone,
            String email, int candidateType, String majors, String semester, String universityName) throws Exception {
        super(candidateId, firstName, lastName, birthDate, address, phone,
                email, candidateType);
        setMajors(majors);
        setSemester(semester);
        setUniversityName(universityName);
    }

    /**
     * get candidate's major
     * 
     * @return Candidate's major
     */
    public String getMajors() {
        return this.majors;
    }

    /**
     * check and set candidate's major
     * 
     * @param majors Candidate's major
     * @throws Exception if majors is an empty string
     */
    public void setMajors(String majors) throws Exception {
        if (majors.trim().equals("")) {
            throw new Exception("Majors can't be empty");
        } else {
            this.majors = majors;
        }
    }

    /**
     * get the semester
     * 
     * @return semester
     */
    public String getSemester() {
        return this.semester;
    }

    /**
     * check and set the semester
     * 
     * @param semester
     * @throws Exception if semester is an empty string
     */
    public void setSemester(String semester) throws Exception {
        if (semester.trim().equals("")) {
            throw new Exception("Semester can't be empty");
        } else {
            this.semester = semester;
        }
    }

    /**
     * get candidate's university
     * 
     * @return Candidate's university
     */
    public String getUniversityName() {
        return this.universityName;
    }

    /**
     * set and check Candidate's university
     * 
     * @param universityName Candidate's university
     * @throws Exception if universityName is an empty string
     */
    public void setUniversityName(String universityName) throws Exception {
        if (universityName.trim().equals("")) {
            throw new Exception("University Name can't be empty");
        } else {
            this.universityName = universityName;
        }
    }

}
