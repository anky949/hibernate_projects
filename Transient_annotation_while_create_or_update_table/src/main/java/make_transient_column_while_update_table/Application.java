package make_transient_column_while_update_table;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Calendar;

public class Application {

    public static void main(String[] args) {

      //see   <property name="hbm2ddl.auto">update</property> in hibernate.cfg.xml
//so value of lastname is not added because lastname column is transient
        Author author1 = new Author();
        author1.setFirstName("ram");
        author1.setLastName("Gupta");


        Author author2=new Author();
        author2.setFirstName("shyam");
        author2.setLastName("Gupta");


        Author author3=new Author();
        author3.setFirstName("bhupi");
        author3.setLastName("Kumar");


        Author author4=new Author();
        author4.setFirstName("dhiraj");
        author4.setLastName("Ahlawat");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

         session.save(author1);
         session.save(author2);
         session.save(author3);
         session.save(author4);


        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
}
