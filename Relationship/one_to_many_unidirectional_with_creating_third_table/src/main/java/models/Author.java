package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
        //here  we have put reference of child table(Book) in parent table(Author) . therefore
    //it is one_to_many unidirectional because by author we can track book ,but by book we can't track author

    @Id
    private int id;


    private String firstname;
    private String lastName;
    private int age;

    //one author can write many books-:
    @OneToMany(cascade = CascadeType.ALL)  //by using CascadeType.ALL,we dont need to save Book object
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
