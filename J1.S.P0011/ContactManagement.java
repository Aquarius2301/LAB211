import java.util.ArrayList;

public class ContactManagement {

    private ArrayList<Contact> contact = new ArrayList<>();

    /**
     * add a contact
     * 
     * @throws Exception
     */
    public void addContact() throws Exception {
        int id;
        // if no contact, first person has ID=1
        if (contact.size() == 0)
            id = 1;
        else
            id = contact.get(contact.size() - 1).getId() + 1;

        String name;
        name = Validation.getString("Enter full name:",
                "Error! Please enter the full name again (Not Empty):");
        // check fullname
        do {
            if (checkName(name)) {
                break;
            } else {
                name = Validation.getString("Error! Please enter the full name (at least two words):",
                        "Error! Please enter the full name again (Not Empty):");
            }
        } while (true);

        String group = Validation.getString("Enter group:", "Error! Please enter the group again (Not Empty):");
        String address = Validation.getString("Enter address:",
                "Error! Please enter the address again (Not Empty):");
        String phone = Validation.getPhone("Enter phone number:");
        phone = convertPhoneNumber(phone);
        contact.add(new Contact(id, name, group, address, phone));
        System.out.println("Successful\n");
    }

    /**
     * check the name if it has 2 words or more
     * 
     * @return {@code true} if it has 2 words or more
     *         {@code false} if it has 1 word or less
     */
    private boolean checkName(String fullName) {
        String[] words = fullName.split("\\s+", 2);
        return words.length > 1;
    }

    /**
     * Take the first 10 numbers in phone number
     * 
     * @param phone phone number
     * @return phone number with format xxxxxxxxxx (x is digit)
     */
    private String convertPhoneNumber(String phone) {
        String res = "";
        for (int i = 0; i < phone.length(); i++) {
            if (Character.isDigit(phone.charAt(i))) {
                res += phone.charAt(i);
            }
        }
        return res.substring(0, 10);
    }

    /**
     * Display all contacts
     */
    public void displayContact() {
        if (contact.isEmpty()) // Notice if no contact in the list
            System.out.println("No contact in the list!");
        else {
            System.out
                    .println(
                            "+------+----------------+-----------------+-----------+----------------------+------------+");
            System.out
                    .println(
                            "|  ID  |   First Name   |    Last Name    |   Group   |       Address        |    Phone   |");
            System.out
                    .println(
                            "+------+----------------+-----------------+-----------+----------------------+------------+");
            for (int i = 0; i < contact.size(); i++) {
                Contact c = contact.get(i);
                System.out.printf("| %4d | %-14s | %-15s | %-9s | %-20s | %-10s |\n", c.getId(), c.getFirstName(),
                        c.getLastName(), c.getGroup(), c.getAddress(), c.getPhone());
            }
            System.out
                    .println(
                            "+------+----------------+-----------------+-----------+----------------------+------------+");
        }
        System.out.println();
    }

    /**
     * Delete a contact
     */
    public void deleteContact() {
        if (contact.isEmpty()) // Notice if no contact in the list
            System.out.println("No contact in the list!");
        else {
            displayContact();

            int id = Validation.getInteger("Enter ID:", "Error! Please enter the ID (Integer) from 1 to 9999:", 1,
                    9999);
            boolean isFound = false;
            for (int i = 0; i < contact.size(); i++) {
                if (contact.get(i).getId() == id) {
                    contact.remove(i);
                    isFound = true;
                    break;
                }
            }
            if (isFound)
                System.out.println("Successful");
            else
                System.out.println("Not found the ID!");
        }
        System.out.println();
    }
}
