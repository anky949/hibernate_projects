package make_transient_column_while_create_table;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Author {


        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)


        private int id;

        @Column(name = "fname")
        private String firstName;

        @Transient //by @Transient, this column will not add in table
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


