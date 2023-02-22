import java.util.Calendar;

public class Fresher extends Candidate {
    private int graduationDate;
    private String graduationRank;
    private String education;

    /**
     * constructor
     */
    public Fresher() {
        super();
    }

    /**
     * Constructor
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
     * @param graduationDate Graduation date
     * @param graduationRank Graduation rank
     * @param education      School
     * @throws Exception
     */
    public Fresher(int candidateId, String firstName, String lastName, int birthDate, String address, String phone,
            String email, int candidateType, int graduationDate, String graduationRank, String education)
            throws Exception {

        super(candidateId, firstName, lastName, birthDate, address, phone,
                email, candidateType);
        setGraduationDate(graduationDate);
        setGraduationRank(graduationRank);
        setEducation(education);
    }

    /**
     * get the graduation date
     * 
     * @return the graduation date
     */
    public int getGraduationDate() {
        return this.graduationDate;
    }

    /**
     * check and set the graduation date
     * 
     * @param graduationDate the graduation date
     * @throws Exception if graduationDate is not in from 1900 to today
     */
    public void setGraduationDate(int graduationDate) throws Exception {
        if (1900 <= graduationDate && graduationDate <= Calendar.getInstance().get(Calendar.YEAR))
            this.graduationDate = graduationDate;
        else
            throw new Exception("Graduation Date must be from 1900 to " + Calendar.getInstance().get(Calendar.YEAR));
    }

    /**
     * get the graduation rank
     * 
     * @return the graduation rank
     */
    public String getGraduationRank() {
        return this.graduationRank;
    }

    /**
     * check and set the graduation rank
     * 
     * @param graduationRank the graduation rank
     * @throws Exception if graduationRank is not "Excellent", "Good", "Fair",
     *                   "Poor"
     */
    public void setGraduationRank(String graduationRank) throws Exception {

        graduationRank = graduationRank.toLowerCase().trim();
        if (graduationRank.equals("excellent") || graduationRank.equals("good") || graduationRank.equals("fair")
                || graduationRank.equals("poor")) {
            this.graduationRank = graduationRank;
        } else
            throw new Exception("Graduation Rank must be choose one (Excellent, Good, Fair, Poor) ");
    }

    /**
     * Get candidate's school
     * 
     * @return Candidate's school
     */
    public String getEducation() {
        return this.education;
    }

    /**
     * check and set the university where student graduated
     * 
     * @param education Candidate's university
     * @throws Exception if education is an empty string
     */
    public void setEducation(String education) throws Exception {
        if (education.trim().equals("")) {
            throw new Exception("Education school can't be empty");
        } else {
            this.education = education;
        }
    }

}
