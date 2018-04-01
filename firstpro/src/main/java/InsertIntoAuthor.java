import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class InsertIntoAuthor {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

        Author author1=new Author();
        author1.setId(35);
        author1.setFirstname("Ankit");
        author1.setLastName("Gupta");
        author1.setAge(25);


        Session session=sessionFactory.openSession();
        session.beginTransaction();



        session.save(author1);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
}
