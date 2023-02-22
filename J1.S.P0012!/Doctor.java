public class Doctor {

    String name, spec;
    int avail;

    /**
     * Constructor
     */
    public Doctor() {
    }

    /**
     * Constructor with parameters
     * 
     * @param name
     * @param spec
     * @param avail
     */
    public Doctor(String name, String spec, int avail) {
        this.name = name;
        this.spec = spec;
        this.avail = avail;
    }

    /**
     * get the name
     * 
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Check and set name
     * 
     * @param name
     * @throws Exception if name is an empty string
     */
    public void setName(String name) throws Exception {
        if (name.trim().isEmpty())
            throw new Exception("Name cannot be empty!");
        this.name = name;
    }

    /**
     * Get the specialization
     * 
     * @return
     */
    public String getSpec() {
        return this.spec;
    }

    /**
     * Set and check the specialization
     * 
     * @param spec
     * @throws Exception
     */
    public void setSpec(String spec) throws Exception {
        if (spec.trim().isEmpty())
            throw new Exception("Specialization cannot be empty!");
        this.spec = spec;
    }

    /**
     * Get the availability
     * 
     * @return
     */
    public int getAvail() {
        return this.avail;
    }

    /**
     * Set and check the availability
     * 
     * @param avail
     * @throws Exception if avail < 0
     */
    public void setAvail(int avail) throws Exception {
        if (avail < 0)
            throw new Exception("Availability cannot be empty!");
        this.avail = avail;
    }

    /**
     * Show the information of this doctor
     * 
     * @param code
     * @return the information of a doctor
     */
    public String showDoctor(String code) {
        return String.format("| %-6s | %-26s | %-14s | %12d |", code, name, spec, avail);
    }
}
