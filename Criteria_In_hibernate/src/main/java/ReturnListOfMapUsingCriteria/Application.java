package ReturnListOfMapUsingCriteria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import java.util.List;
import java.util.Map;

import static org.hibernate.criterion.Projections.groupProperty;
import static org.hibernate.criterion.Projections.property;
import static org.hibernate.criterion.Projections.sum;

public class Application {
    public static void main(String[] args) {
/*
        Student student1=new Student();
        student1.setId(1001);
        student1.setName("Ankit");

        Student student2=new Student();
        student2.setId(1002);
        student2.setName("arpit");

        Subject subject1=new Subject();
        subject1.setSubjectName("maths");
        subject1.setStudent(student1);

        Subject subject2=new Subject();
        subject2.setSubjectName("science");
        subject2.setStudent(student1);

        Subject subject3=new Subject();
        subject3.setSubjectName("hindi");
        subject3.setStudent(student1);

        Subject subject4=new Subject();
        subject4.setSubjectName("sst");
        subject4.setStudent(student2);
        Subject subject5=new Subject();
        subject5.setSubjectName("science");
        subject5.setStudent(student2);

        List<Subject> subjectList=new ArrayList<>();
        subject1.setMarks(90);
        subject2.setMarks(90);
        subject3.setMarks(70);
        subjectList.add(subject1);
        subjectList.add(subject2);
        subjectList.add(subject3);

        List<Subject>subjectList2=new ArrayList<>();
        subject4.setMarks(95);
        subject5.setMarks(65);
        subjectList2.add(subject4);
        subjectList2.add(subject5);


            student1.setSubjectList(subjectList);

            student2.setSubjectList(subjectList2);*/
        SessionFactory sessionFactory=new Configuration().configure("hibernatefor_returnListOfMapUsingCriteria.cfg.xml").buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();



            /*session.save(student1);
            session.save(student2);
*/
//I want to find sum of marks of every student by using List<Map> by using 1 criteria

        Criteria criteria=session.createCriteria(Subject.class);
        criteria.createAlias("student","student_");

        criteria.setProjection(Projections.projectionList().add(groupProperty("student_.id").as("studentId"))
        .add(property("student_.name").as("studentName"))
        .add(sum("marks").as("totalMarks")));
        criteria.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map> criteriaResult=(List<Map>) criteria.list();
        System.out.println(criteriaResult);

//how to get or print any value(like names here) from criteria using map
        for(Map map : criteriaResult){
            String sname= (String) map.get("studentName");
            Long smarks=(Long) map.get("totalMarks");

            System.out.println(sname + " got : "+smarks);
        }

        session.getTransaction().commit();
        session.close();

        sessionFactory.close();
    }


}
