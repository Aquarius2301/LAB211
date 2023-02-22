import java.util.Calendar;
import java.util.regex.Pattern;

public class Candidate {
    private int candidateId;
    private String firstName;
    private String lastName;
    private int birthDate;
    private String address;
    private String phone;
    private String email;
    private int candidateType;

    /**
     * Constructor with no parameter
     */
    public Candidate() {
    }

    /**
     * Constructor with parameter
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
     * @throws Exception One of variables wrong format
     */
    public Candidate(int candidateId, String firstName, String lastName, int birthDate, String address, String phone,
            String email, int candidateType) throws Exception {
        setCandidateId(candidateId);
        setAddress(address);
        setBirthDate(birthDate);
        setCandidateType(candidateType);
        setEmail(email.toLowerCase());
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
    }

    /**
     * get the candidate id
     * 
     * @return int
     */
    public int getCandidateId() {
        return this.candidateId;
    }

    /**
     * Check and set ID
     * 
     * @param candidateId Candidate's ID
     * @throws Exception if the ID out of 1 to 99999
     */
    public void setCandidateId(int candidateId) throws Exception {
        if (1 <= candidateId && candidateId <= 99999)
            this.candidateId = candidateId;
        else
            throw new Exception("ID must be from 1 to 99999");
    }

    /**
     * get first name
     * 
     * @return Candidate's first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * check and set first name
     * 
     * @param firstName Candidate's first name
     * @throws Exception if firstName is an empty string
     */
    public void setFirstName(String firstName) throws Exception {
        if (firstName.trim().equals("")) {
            throw new Exception("First name can't be empty!");
        }
        this.firstName = firstName;
    }

    /**
     * get last name
     * 
     * @return Candidate's last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * check and set last name
     * 
     * @param lastName Candidate's last name
     * @throws Exception if lastName is an empty string
     */
    public void setLastName(String lastName) throws Exception {
        if (lastName.trim().equals("")) {
            throw new Exception("Last name can't be empty!");
        }
        this.lastName = lastName;
    }

    /**
     * get candidate's birth date
     * 
     * @return candidate's birth date
     */
    public int getBirthDate() {
        return this.birthDate;
    }

    /**
     * check and set Birth Date
     * 
     * @param birthDate Candidate's birth date (year)
     * @throws Exception if birthDate is out of range (from 1900 to this year)
     */
    public void setBirthDate(int birthDate) throws Exception {
        if (1900 <= birthDate && birthDate <= Calendar.getInstance().get(Calendar.YEAR))
            this.birthDate = birthDate;
        else
            throw new Exception("Birth Date must be from 1900 to " + Calendar.getInstance().get(Calendar.YEAR));
    }

    /**
     * get the candidate's address
     * 
     * @return Candidate's address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * check and set address
     * 
     * @param address candidate's address
     * @throws Exception if address is an empty string
     */
    public void setAddress(String address) throws Exception {
        if (address.trim().equals("")) {
            throw new Exception("Address can't be empty!");
        }
        this.address = address;
    }

    /**
     * get candidate's phone number
     * 
     * @return Candidate's phone number
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * check and set phone number
     * 
     * @param phone Candidate's phone number
     * @throws Exception if phone does not at least 10 digits
     */
    public void setPhone(String phone) throws Exception {
        String pattern = "^(09|08|07|05|03)\\d{8}$";
        Pattern p = Pattern.compile(pattern);
        if (p.matcher(phone).matches()) {
            this.phone = phone;
        } else
            throw new Exception("Phone number is wrong format.");
    }

    /**
     * get candidate's Email
     * 
     * @return Candidate's Email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * check and set Email
     * 
     * @param email candidate's Email
     * @throws Exception email is an empty string
     */
    public void setEmail(String email) throws Exception {
        if (email.trim().equals("")) {
            throw new Exception("Email can't be empty!");
        } else if (!isValidatedMail(email))
            throw new Exception("Email must follow the format <username>@<domain>!");
        this.email = email;
    }

    /**
     * Check email
     * <p>
     * Email is valid if it follows format <username>@<domain>
     * 
     * @param email Candidate's email
     * @return {@code true} if email is valid
     *         <p>
     *         {@code false} if email is not valid
     */
    private boolean isValidatedMail(String email) {
        String regexPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.compile(regexPattern).matcher(email).matches();
    }

    /**
     * get the candidate type
     * 
     * @return candidate type
     */
    public int getCandidateType() {
        return this.candidateType;
    }

    /**
     * check and set candidate's type
     * 
     * @param candidateType Candidate's type
     * @throws Exception if candidateType is out of range (from 0 to 2)
     */
    public void setCandidateType(int candidateType) throws Exception {
        if (0 <= candidateType && candidateType <= 2)
            this.candidateType = candidateType;
        else
            throw new Exception("Candidate Type must be from 0 to 2");
    }

}
