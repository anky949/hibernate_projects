import models.Author;
import models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class application {
    public static void main(String[] args) {
//scenario: //(1)one author can write many books and (2)one book can be written by only one author

        Author author1=new Author();
        author1.setId(35);
        author1.setFirstname("Ankit");
        author1.setLastName("gupta");
        author1.setAge(25);


        Author author2=new Author();
        author2.setId(26);
        author2.setFirstname("vikesh");
        author2.setLastName("kumar");
        author2.setAge(36);

        Book book1=new Book();
        book1.setBook_id(501);
        book1.setBook_name("Harry Porter");
        book1.setBookAuthor(author1);


        Book book2=new Book();
        book2.setBook_id(502);
        book2.setBook_name("Game Of Thrones");
        book2.setBookAuthor(author1);

        Book book3=new Book();
        book3.setBook_id(503);
        book3.setBook_name("Let Us C");
        book3.setBookAuthor(author2);


        Book book4=new Book();
        book4.setBook_id(504);
        book4.setBook_name("R.S Aggarwal");
        book4.setBookAuthor(author2);



        ArrayList<Book> bookArrayList1=new ArrayList<>();
        bookArrayList1.add(book1);
        bookArrayList1.add(book2);


        author1.setBooks(bookArrayList1);



        ArrayList<Book> bookArrayList2=new ArrayList<>();
        bookArrayList2.add(book3);
        bookArrayList2.add(book4);

        author2.setBooks(bookArrayList2);


        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        session.save(author1);

        session.save(author2);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();   }
}
