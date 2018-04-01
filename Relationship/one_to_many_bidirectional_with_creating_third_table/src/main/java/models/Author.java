package models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {




    //To make one_to_many bidirectional, we put reference of parent table(Author) in child table(Book) or vice versa
    //After making bidirectional,by author we can track book and by book we can track author also

    @Id
    private int id;


    private String firstname;
    private String lastName;
    private int age;


    //(1):one author can write many books
    @OneToMany(cascade = CascadeType.ALL)
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
