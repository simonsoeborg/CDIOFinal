package Data.DTO;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String initial;
    private String role;
    private String status;

    public User(int id, String firstname, String lastname, String initial, String role, String status) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.initial = initial;
        this.role = role;
        this.status=status;
    }

    // *Todo Lav en løsning sålede at initials selv bliver dannet. (Ved ikke hvor jeg skal implementer).
    public void setInitial (String firstname, String lastname) {
        Character first = Character.toUpperCase(firstname.charAt(0));
        Character second = Character.toUpperCase(lastname.charAt(0));
        initial= String.valueOf(first+second);
    }

    public String getInitial() { return initial; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() { return role; }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status=status;
    }

}
