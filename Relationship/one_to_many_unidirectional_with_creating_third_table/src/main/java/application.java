import models.Author;
import models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class application {
    public static void main(String[] args) {

        //scenario://one author can write many books

        Author author1=new Author();
        author1.setId(35);
        author1.setFirstname("Ankit");
        author1.setLastName("gupta");
        author1.setAge(25);

        Book book1=new Book();
        book1.setBook_id(501);
        book1.setBook_name("Harry Porter");

        Book book2=new Book();
        book2.setBook_id(502);
        book2.setBook_name("Game Of Thrones");



        ArrayList<Book> bookArrayList=new ArrayList<>();
        bookArrayList.add(book1);
        bookArrayList.add(book2);

       author1.setBooks(bookArrayList);



        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

            session.save(author1);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
