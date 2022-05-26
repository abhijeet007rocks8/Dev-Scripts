package College;

public class Record {
	 
    //Instance Variables.
    private String name;
    private int idNumber;
    private int contactNumber;
 
    /**
     * Default Constructor.
     */
    public Record() {
    }
 
    /**
     * Parameterized Constructor.
     *
     * @param name
     * @param idNumber
     * @param contactNumber
     */
    public Record(String name, int idNumber, int contactNumber) {
        this.name = name;
        this.idNumber = idNumber;
        this.contactNumber = contactNumber;
    }
 
    /**
     * Get the value of contactNumber
     *
     * @return the value of contactNumber
     */
    public int getContactNumber() {
        return contactNumber;
    }
 
    /**
     * Set the value of contactNumber
     *
     * @param contactNumber new value of contactNumber
     */
    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }
 
    /**
     * Get the value of idNumber
     *
     * @return the value of idNumber
     */
    public int getIdNumber() {
        return idNumber;
    }
 
    /**
     * Set the value of idNumber
     *
     * @param idNumber new value of idNumber
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }
 
    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }
 
    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }
 
    /**
     * toString Method.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Records{" + "name=" + name + ", idNumber=" + idNumber + ", contactNumber=" + contactNumber + '}';
    }
 
}