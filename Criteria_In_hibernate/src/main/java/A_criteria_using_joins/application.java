package A_criteria_using_joins;

import models.Author;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.sql.JoinType;

import java.util.List;

public class application {
    public static void main(String[] args) {

/*

        Author author1=new Author();
        author1.setId(35);
        author1.setFirstname("ankit");
        author1.setLastName("gupta");
        author1.setAge(25);
        Address address=new Address();
        address.setAdid(2);
        address.setCity("noida");
        author1.setAddress(address);

        Book book1=new Book();
        book1.setBook_id(501);
        book1.setBook_name("Harry Porter");

        author1.setBooks(book1);
*/

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

/*
            session.save(author1);
            session.save(address);
            session.save(book1);
*/

        Criteria criteria = session.createCriteria(Author.class);
        criteria.createAlias("address", "address1", JoinType.LEFT_OUTER_JOIN)
                .createAlias("book", "book1", JoinType.LEFT_OUTER_JOIN);

        List<Author> list=criteria.list();
        System.out.println(list);



        session.getTransaction().commit();
        session.close();

        sessionFactory.close();
    }


}
