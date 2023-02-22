import java.util.regex.Pattern;

public class Contact {
    private int id;
    private String fullName, firstName, lastName, group, address, phone;

    /**
     * Constructor
     * 
     * @param id       the id
     * @param fullName the full name
     * @param group    the group
     * @param address  the address
     * @param phone    the phone number
     * @throws Exception
     */
    public Contact(int id, String fullName, String group, String address, String phone) throws Exception {
        setId(id);
        setFullName(fullName);
        setGroup(group);
        setAddress(address);
        setPhone(phone);
    }

    /**
     * get the ID
     * 
     * @return the ID
     */
    public int getId() {
        return this.id;
    }

    /**
     * set and check the ID
     * 
     * @param id the ID
     * @throws Exception if ID is out of range [1,9999]
     */
    public void setId(int id) throws Exception {
        if (id <= 0 || id > 9999)
            throw new Exception("The ID must greater than 0 and smaller than 0");
        this.id = id;
    }

    /**
     * get the full name
     * 
     * @return
     */
    public String getFullName() {
        return this.fullName;
    }

    /**
     * set the full name
     * 
     * @param fullName the full name
     * @throws Exception if fullName is empty
     */
    public void setFullName(String fullName) throws Exception {
        if (fullName.trim().equals(""))
            throw new Exception("The name cannot be empty!");
        this.fullName = fullName;
        separateName();
    }

    /**
     * separate the name into first name and last name
     */
    private void separateName() {
        String[] words = fullName.split("\\s+", 2);
        firstName = words[0];
        if (words.length != 1) {
            lastName = words[1];
        } else
            lastName = "";
    }

    /**
     * Get the first name
     * 
     * @return the first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Get the last name
     * 
     * @return the last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Get the group
     * 
     * @return the group
     */
    public String getGroup() {
        return this.group;
    }

    /**
     * Set the group
     * 
     * @param group the group
     * @throws Exception if group is empty
     */
    public void setGroup(String group) throws Exception {
        if (group.trim().equals(""))
            throw new Exception("The group cannot be empty!");
        this.group = group;
    }

    /**
     * get the address
     * 
     * @return the address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * set the address
     * 
     * @param address the address
     * @throws Exception if address is empty
     */
    public void setAddress(String address) throws Exception {
        if (address.trim().equals(""))
            throw new Exception("The address cannot be empty!");
        this.address = address;
    }

    /**
     * get phone number
     * 
     * @return phone number
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * set phone number
     * 
     * @param phone the phone number
     * @throws Exception if phone is not follow the format \\d{10}
     */
    public void setPhone(String phone) throws Exception {
        String pattern = "^\\d{10}$";
        Pattern p = Pattern.compile(pattern);
        if (p.matcher(phone).matches()) {
            this.phone = phone;
        } else
            throw new Exception("The phone is wrong format!");
    }

}
