import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        Calendar calendar=Calendar.getInstance();

        Address address1 =new Address();
        address1.setStreetNumber(5);
        address1.setLocation("Rohini");
        address1.setState("Delhi");

        List<String> subjectList1=new ArrayList<>();
        subjectList1.add("sub1");
        subjectList1.add("sub2");
        subjectList1.add("sub3");

        Author author1 = new Author();
        author1.setFirstName("Ankit");
        author1.setLastName("Gupta");
        author1.setAge(25);

        calendar.set(1992, 8, 26);
        author1.setDob(calendar.getTime());
        author1.setAddress(address1);
        author1.setSubjects(subjectList1);



        Address address2 =new Address();
        address2.setStreetNumber(12);
        address2.setLocation("Agra");
        address2.setState("UP");

        List<String> subjectList2=new ArrayList<>();
        subjectList2.add("sub1");
        subjectList2.add("sub4");
        subjectList2.add("sub5");


        Author author2=new Author();
        author2.setFirstName("Vikesh");
        author2.setLastName("Kumar");
        author2.setAge(28);

        calendar.set(1998,07,28);
        author2.setDob(calendar.getTime());
        author2.setAddress(address2);
        author2.setSubjects(subjectList2);


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

         session.save(author1);

         session.save(author2);



        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
}
