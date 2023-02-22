import java.util.Calendar;

public class Experience extends Candidate {
    private int expInYear;
    private String proSkill;

    /**
     * Constructor
     */
    public Experience() {
        super();
    }

    /**
     * Constructor
     * 
     * @param candidateId   Candidate's ID
     * @param firstName     Candidate's first name
     * @param lastName      Candidate's last name
     * @param birthDate     Candidate's birth date (year)
     * @param address       Candidate's address
     * @param phone         Candidate's phone
     * @param email         Candidate's email
     * @param candidateType Candidate Type (0: Experience, 1: Fresher, 2:
     *                      Internship)
     * @param expInYear     Candidate experience (year)
     * @param proSkill      Candidate skill
     * @throws Exception
     */
    public Experience(int candidateId, String firstName, String lastName, int birthDate, String address, String phone,
            String email, int candidateType, int expInYear, String proSkill) throws Exception {

        super(candidateId, firstName, lastName, birthDate, address, phone,
                email, candidateType);
        setExpInYear(expInYear, birthDate);
        setProSkill(proSkill);
    }

    /**
     * get Candidate experience
     * 
     * @return Candidate experience
     */
    public int getExpInYear() {
        return this.expInYear;
    }

    /**
     * check and set candidate experience
     * 
     * @param expInYear Candidate experience
     * @throws Exception expInYear is out of range (from 1 to 100)
     */
    public void setExpInYear(int expInYear, int birthDate) throws Exception {
        if (0 <= expInYear && expInYear <= Calendar.getInstance().get(Calendar.YEAR) - birthDate) {
            this.expInYear = expInYear;
        } else
            throw new Exception(
                    "Experience Year must be from 0 to " + (Calendar.getInstance().get(Calendar.YEAR) - birthDate));
    }

    /**
     * get candidate's skill
     * 
     * @return Candidate's skill
     */
    public String getProSkill() {
        return this.proSkill;
    }

    /**
     * check and set candidate's skill
     * 
     * @param proSkill Candidate's skill
     * @throws Exception if proSkill is an empty string
     */
    public void setProSkill(String proSkill) throws Exception {
        if (proSkill.trim().equals(""))
            throw new Exception("Professional skill can't be empty");
        this.proSkill = proSkill;
    }

}
