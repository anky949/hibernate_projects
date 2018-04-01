package models;

import javax.persistence.*;

@Entity
public class Author {

    @Id
    private int id;


    private String firstname;
    private String lastName;
    private int age;

    @OneToOne(cascade=CascadeType.ALL) //by using CascadeType.PERSIST,we dont need to save Books object using session
    @JoinColumn(name="bid") //here foreign key is bid where refers to primary key(book_id) of Book table
    private Book book;

    public Book getBooks() {
        return book;
    }

    public void setBooks(Book book) {
        this.book = book;
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
