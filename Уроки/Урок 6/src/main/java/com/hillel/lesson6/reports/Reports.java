package com.hillel.lesson6.reports;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class Reports {

  public List<ExamReport> getExamResults(String firstname, String lastname, Session session) {

        /*
        Query query = session.createQuery("select " +
                            "new com.hillel.lessons.reports.ExamReport(s.name, st.firstname, e.grade) " +
                            "from Exam e, Subject s, Student st " +
                            "where e.student.id = st.id and e.subject.id = s.id " +
                            "and st.firstname = :firstname and st.lastname = :lastname");
                            */

    Query query = session.createQuery("select " +
        "new com.hillel.lesson6.reports.ExamReport(e.subject.name, " +
        "e.student.firstname, e.grade) " +
        "from Exam e " +
        "where e.student.firstname = :firstname and " +
        "e.student.lastname = :lastname");

    query.setParameter("firstname", firstname);
    query.setParameter("lastname", lastname);

    return query.getResultList();
  }
}