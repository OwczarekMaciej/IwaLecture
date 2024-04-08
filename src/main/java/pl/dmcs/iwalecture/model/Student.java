package pl.dmcs.iwalecture.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")
    @SequenceGenerator(name = "student_generator", sequenceName = "student_SEQ", allocationSize = 1)
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String telephone;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.MERGE)
    private Address address;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Team> teamList;
    // Commented out due to simplify http requests sent from angular app

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
