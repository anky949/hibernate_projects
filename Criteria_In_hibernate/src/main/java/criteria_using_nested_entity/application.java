package criteria_using_nested_entity;

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

        /*DriverAccount driverAccount=new DriverAccount();
        driverAccount.setAccountId(1);
        driverAccount.setAccountNo(1234);

        Driver driver=new Driver();
        driver.setDriverId(501);
        driver.setDriverName("ankit");
        driver.setDriverAccount(driverAccount);

        DriverTransaction driverTransaction=new DriverTransaction();
        driverTransaction.setTransactionId(1001);
        driverTransaction.setDriver(driver);
*/


        SessionFactory sessionFactory=new Configuration().configure("hibernatefornestedentity.cfg.xml").buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

  //      session.save(driverTransaction);


        Criteria criteria=session.createCriteria(DriverTransaction.class);
        criteria.createAlias("driver","driver_");
        criteria.createAlias("driver_.driverAccount","driveracc");

        ProjectionList projectionList=Projections.projectionList();
        projectionList.add(Projections.groupProperty("transactionId"),"tid");
        projectionList.add(Projections.property("driver_.driverName"),"dname");
        projectionList.add(Projections.property("driveracc.accountNo"),"accno");

        criteria.setProjection(projectionList);
        criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        System.out.println(criteria.list());

        session.getTransaction().commit();
        session.close();

        sessionFactory.close();
    }


}
