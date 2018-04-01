import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateAuthor {
    public static void main(String[] args) {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        Author author=session.get(Author.class,35);
        author.setAge(24);
        author.setFirstname("Arpit");

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();





    }
}
