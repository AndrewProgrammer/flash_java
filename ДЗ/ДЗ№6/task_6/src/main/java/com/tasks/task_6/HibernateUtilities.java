package com.tasks.task_6;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtilities {

  private static SessionFactory sessionFactory = null;

  //Can`t create objects
  private HibernateUtilities() {

  }

  public static SessionFactory getSessionFactory() {
    if(sessionFactory == null){
      sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    return sessionFactory;
  }

}
