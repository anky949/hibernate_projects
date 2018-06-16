package Criteria_using_Pagination;

import models.Address;
import models.Author;
import models.Book;
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
        author1.setId(26);
        author1.setFirstname("vikesh");
        author1.setLastName("kumar");
        author1.setAge(22);
        Address address=new Address();
        address.setAdid(3);
        address.setCity("delhi");
        author1.setAddress(address);

        Book book1=new Book();
        book1.setBook_id(502);
        book1.setBook_name("GOT");

        author1.setBooks(book1);*/
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

            /*session.save(author1);
            session.save(address);
            session.save(book1);
*/
        Criteria criteria = session.createCriteria(Author.class);
        criteria.createAlias("address", "address1", JoinType.LEFT_OUTER_JOIN)
                .createAlias("book", "book1", JoinType.LEFT_OUTER_JOIN);

        List<Author> list = criteria.list();
        System.out.println(list);

        ProjectionList projectionList = Projections.projectionList();
        projectionList.add(Projections.property("address1.city"), "author_city");
        projectionList.add(Projections.property("book1.book_name"), "author_book");
        criteria.setProjection(projectionList);

        criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

        criteria.setFirstResult(0);
        criteria.setMaxResults(1);

        System.out.println(criteria.uniqueResult());


        session.getTransaction().commit();
        session.close();

        sessionFactory.close();
    }


}
