package com.org;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//A one to one example of employee and address
//A one to one example of employee and address.


/**
 * Hello world!
 *
 */

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Configuration  cfg= new Configuration();
        cfg.configure("Hibernate.cfg.xml");
        SessionFactory fact = cfg.buildSessionFactory();
        Session sess= fact.openSession();
       // sess.beginTransaction();
        Transaction t=sess.beginTransaction();

        Employee e1=new Employee();    
        e1.setName("Ravi Malik");    
        e1.setEmail("ravi@gmail.com");    

        Address address1=new Address();    
        address1.setAddressLine1("G-21,Lohia nagar");    
        address1.setCity("Ghaziabad");    
        address1.setState("UP");    
        address1.setCountry("India");    
        address1.setPincode(201301);    

        e1.setAddress(address1);    
        address1.setEmployee(e1);    

        sess.persist(e1);    
        t.commit();    
        System.out.println("Save !!!");


        sess.close();    
        System.out.println("success");   
    }
}
