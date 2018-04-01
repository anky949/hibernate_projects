import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class ReadFromAuthorTable {
    public static void main(String[] args) {


        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();



       Author author=session.get(Author.class,35);

        System.out.println(author.getId()+" "+author.getFirstname()+" "+author.getLastName());
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();


    }
}
