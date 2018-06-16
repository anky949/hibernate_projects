package Criteria_using_groupby_and_set_returned_data_in_DTO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

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
  /*      DriverAccount driverAccount=new DriverAccount();
        driverAccount.setAccountId(2);
        driverAccount.setAccountNo(1234);

        Driver driver=new Driver();
        driver.setDriverId(502);
        driver.setDriverName("arpit");
        driver.setDriverAccount(driverAccount);

        DriverTransaction driverTransaction=new DriverTransaction();
        driverTransaction.setTransactionId(1002);
        driverTransaction.setDriver(driver);
*/

        SessionFactory sessionFactory=new Configuration().configure("hibernatefornestedentity.cfg.xml").buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

  //      session.save(driverTransaction);



        Criteria criteria=session.createCriteria(DriverTransaction.class);
        criteria.createAlias("driver","driver_");
        criteria.createAlias("driver_.driverAccount","driverAccount")
        .setProjection(Projections.sum("driver_.driverId"));

        /*Long result=(Long) (criteria.uniqueResult());
        System.out.println(result);
        */ProjectionList projectionList=Projections.projectionList();
        projectionList.add(Projections.groupProperty("driveracc.accountNo"),"accno");
        projectionList.add(Projections.count("driver_.driverName"),"total_drivers"); //note here count method return the value of Long type

        criteria.setProjection(projectionList);
        DetailDTO detailDTOS=(DetailDTO) criteria.setResultTransformer(Transformers.aliasToBean(DetailDTO.class)).uniqueResult();
        System.out.println( detailDTOS);

        session.getTransaction().commit();

        session.close();

        sessionFactory.close();
    }


}
