import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Author {


        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)


        private int id;


        @Column(name = "fname")
        private String firstName;

        @Transient
        @Column(name = "lname")
        private String lastName;

        @Column(name = "age")
        int age;

        @Temporal(TemporalType.DATE) //@Temporal(TemporalType.DATE)-:it will appear as only date not with time
        @Column(name = "DateofBirth")
        Date dob;

        @Embedded //by this annotation,all properties of Address will insert into Author table
        // or we can put @Embeddable on the Address class name
        private Address address;

        @ElementCollection //it will create new table Author_subjects with two column Author_id and subjects. Author_id will be foreign key which refers to primary key(id) of Author table
        private List<String> subjects;

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }


