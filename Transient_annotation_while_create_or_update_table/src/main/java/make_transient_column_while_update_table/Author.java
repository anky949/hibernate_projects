package make_transient_column_while_update_table;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private int id;

    @Column(name = "fname")
    private String firstName;

    @Transient // here we made this column transient while update table that means few records are already inserted so from now any new value of lname will appear as null in database
    @Column(name = "lname")
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

