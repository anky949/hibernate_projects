package models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {

    //if we want to make one to many relationship between Author table and Book table without creating third(Author_Book) table,than we have to put (mappedBy = "foreign_key_name") with one to many annotation in parent table(Author) which defines the foreign key name in child table(Book)

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "author_id")
    private int id;


    private String firstname;
    private String lastName;
    private int age;

    //(1):one author can write many books
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bookAuthor")//by using CascadeType.ALL,we dont need to save Book object and bookAuthor is a foreign key in Book table
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
