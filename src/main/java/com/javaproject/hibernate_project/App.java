package com.javaproject.hibernate_project;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;



public class App 
{
    public static void main( String[] args ) 
    {     
        
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        Employee employee = new Employee();
        employee.setId(3);
        employee.setName("kushagra");
        employee.setEmail("kushagra@gmail.com");
        
//        session.save(employee);
        tx.commit();
        Query query = session.createQuery("from Employee");
        List<Employee> list = query.list();
        for(Employee employe: list) {
        	System.out.println(employe.getId()+" "+employe.getName()+" "+employe.getEmail());
        }
        
        
        factory.close();
        session.close();
        
        
    }
}
