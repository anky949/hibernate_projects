import models.Author;
import models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class application {
    public static void main(String[] args) {


        Author author1=new Author();
        author1.setId(35);
        author1.setFirstname("Ankit");
        author1.setLastName("gupta");
        author1.setAge(25);

        Book book1=new Book();
        book1.setBook_id(501);
        book1.setBook_name("Harry Porter");

author1.setBooks(book1);

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

            session.save(author1);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
