import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.ArrayList;

public class example {
        public static void main(String[] args) {



            Author author1=new Author();
            author1.setId(40);
            author1.setFirstname("kapil");
            author1.setLastName("gupta");
            author1.setAge(29);



            Books book1=new Books();
            book1.setBook_id(505);
            book1.setBook_name("g");


            Books book2=new Books();
            book2.setBook_id(506);
            book2.setBook_name("HPorter");



            ArrayList<Books> booksArrayList=new ArrayList<>();

            booksArrayList.add(book1);
            booksArrayList.add(book2);


            author1.setBooks(booksArrayList);





            SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
            Session session=sessionFactory.openSession();
            session.beginTransaction();



                session.save(author1);

                session.save(book1);
                session.save(book2);


            session.getTransaction().commit();
            session.close();
            sessionFactory.close();


        }
    }


