package pl.dmcs.iwalecture.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private String city;
    private String street;
    private String number;
    private String postalCode;


    // Commented out due to simplify http requests sent from angular app
    @JsonManagedReference
    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    //@JoinTable(name="student_address",joinColumns = @JoinColumn(name="student_id"),inverseJoinColumns = @JoinColumn(name="address_id"))
    private List<Student> studentList;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getStreet() { return street; }

    public void setStreet(String street) { this.street = street; }

    public String getNumber() { return number; }

    public void setNumber(String number) { this.number = number; }

    public String getPostalCode() { return postalCode; }

    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }


    // Commented out due to simplify http requests sent from angular app
    public List<Student> getStudentList() { return studentList; }

    public void setStudentList(List<Student> studentList) { this.studentList = studentList; }
}

