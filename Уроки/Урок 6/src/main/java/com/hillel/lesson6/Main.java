package com.hillel.lesson6;

import com.hillel.lesson6.entities.Role;
import com.hillel.lesson6.entities.Student;
import com.hillel.lesson6.entities.User;
import com.hillel.lesson6.reports.ExamReport;
import com.hillel.lesson6.reports.Reports;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class Main {
    public static void main(String[] args){

        SessionFactory sessionFactory = HibernateUtilities.getSessionFactory();

        try( Session session = sessionFactory.openSession()) {
            NativeQuery query = session.createNativeQuery("select version();");
            session.createNativeQuery("select version();");
            String result = (String) query.getSingleResult();
            System.out.println(result);

            Transaction tx = session.beginTransaction();


            /*Student student = new Student();
            student.setFirstname("John");
            student.setLastname("Wayne");
            student.setAge(35);

            session.save(student);

            Student student1 = session.get(Student.class, (long) 1); // Если не найдет id - Null
            //Student student = session.get(Student.class, (long) 1); // Если не найдет id - EXCEPTION
            System.out.println(student1);

            student1.setAge(student1.getAge() + 10);

            User user = new User();
            user.setLogin("test");
            user.setPassword("test123");

            Role role1 = new Role();
            role1.setName("admin");

            Role role2 = new Role();
            role2.setName("customer");

            Set<Role> roles = new HashSet<>();
            roles.add(role1);
            roles.add(role2);

            user.setRoles(roles);

            session.save(user);
*/
            Reports reports = new Reports();
            List<ExamReport> exams = reports.getExamResults("John", "Wayne", session);

          /* Query query1 = session.createNamedQuery("studentByName");
           query1.setParameter("firstname", "John");

           Student student2 = (Student) query1.getSingleResult();

           NativeQuery nativeQuery = session.
                   createNativeQuery("select * from students").
                   addEntity(Student.class);

           Student student3 = (Student) nativeQuery.getSingleResult();
*/
           tx.commit();

        }catch (Exception e){}

        sessionFactory.close();
    }
}
