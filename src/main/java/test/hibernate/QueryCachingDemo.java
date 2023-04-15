package test.hibernate;

import org.hibernate.CacheMode;
import org.hibernate.Session;
import test.hibernate.entities.Employee;
import test.hibernate.utils.XmlConnectionConfig;

import java.util.List;

public class QueryCachingDemo {
    public static void main(String[] args) {

        try (Session session = XmlConnectionConfig.getSession()) {
            List<Employee> employees = session.createQuery("FROM Employee WHERE id= 1", Employee.class)
                    .setCacheable(true)
                    .setCacheMode(CacheMode.GET)
                    .getResultList();
            System.out.println("employees size: " + employees.size());

            employees = session.createQuery("FROM Employee WHERE id= 1", Employee.class)
                    .setCacheable(true)
                    .getResultList();
            System.out.println("employees size: " + employees.size());
        }


    }
}
