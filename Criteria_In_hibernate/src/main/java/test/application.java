package test;

import models.Author;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;
import org.hibernate.sql.JoinType;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class application {
    public static void main(String[] args) {

        /*Person person1=new Person();
        person1.setId(35);
        person1.setName("ankit");
        person1.setBirth(getStartDateOfMonth(new Date()));
        */
        SessionFactory sessionFactory=new Configuration().configure("test.cfg.xml").buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

       /* Criteria criteria=session.createCriteria(Person.class);
        criteria.add(Restrictions.eq("id",35));
        criteria.add(Restrictions.ge("birth",getStartDateOfMonth(new Date())));
        criteria.add(Restrictions.lt("birth",getEndDateOfMonth(new Date())));
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        Person person=(Person) criteria.uniqueResult();


        System.out.println(person);*/
        System.out.println(getStartDateOfMonth(new Date()));
        System.out.println(getEndDateOfMonth(new Date()));
       /* session.save(person1);*/
        session.getTransaction().commit();
        session.close();

        sessionFactory.close();
    }

    public static Date getEndDateOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static Date getStartDateOfMonth(Date month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

}
