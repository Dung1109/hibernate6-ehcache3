package test.hibernate;

import org.hibernate.Session;
import test.hibernate.entities.Employee;
import test.hibernate.utils.XmlConnectionConfig;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try (Session session1 = XmlConnectionConfig.getSession()) {
            Employee employee = session1.get(Employee.class, 1);
            System.out.println("Employee name: " + employee.getName());
            System.out.println("--------------End session1-----------------");
        }

        try (Session session2 = XmlConnectionConfig.getSession()) {
//            XmlConnectionConfig.getSessionFactory().getCache().evictAll();
            XmlConnectionConfig.getSessionFactory().getCache().evict(Employee.class);
            // evict entity with id = 1 from cache
//            XmlConnectionConfig.getSessionFactory().getCache().evictEntityData(Employee.class, 1);
            Employee employee = session2.get(Employee.class, 1);
            System.out.println("Employee name: " + employee.getName());
            System.out.println("--------------End session2-----------------");
        }
    }
}