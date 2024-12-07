package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();

        // Insert a new record
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Client client = new Client();
        client.setName("John Doe");
        client.setGender("Male");
        client.setAge(30);
        client.setLocation("New York");
        client.setEmail("john.doe@example.com");
        client.setMobile("1234567890");

        session.save(client);
        transaction.commit();

        // Retrieve and print all records
        List<Client> clients = session.createQuery("from Client", Client.class).list();
        for (Client c : clients) {
            System.out.println("ID: " + c.getId());
            System.out.println("Name: " + c.getName());
            System.out.println("Gender: " + c.getGender());
            System.out.println("Age: " + c.getAge());
            System.out.println("Location: " + c.getLocation());
            System.out.println("Email: " + c.getEmail());
            System.out.println("Mobile: " + c.getMobile());
            System.out.println("-------------------------");
        }

        session.close();
        factory.close();
    }
}
