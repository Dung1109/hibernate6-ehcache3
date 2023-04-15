package test.hibernate;

import org.hibernate.Session;
import test.hibernate.entities.Employee;
import test.hibernate.utils.XmlConnectionConfig;

public class FirstLevelCacheDemo {
    public static void main(String[] args) {

        try (Session session = XmlConnectionConfig.getSession()) {
            Employee employee = new Employee();

            for (int i = 0; i < 5; i++) {
                System.out.println(session.contains(employee));
                employee = session.get(Employee.class, 1);
                System.out.println(session.contains(employee));
            }
        }
    }
}
