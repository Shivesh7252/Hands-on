package MavenProject.Employee;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	private static SessionFactory fact;

	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.println("Hello World!");
		Configuration cfg = new Configuration();
		cfg.configure("Hibernate.cfg.xml");
		SessionFactory fact = cfg.buildSessionFactory();
		Session sess = fact.openSession();
		// sess.beginTransaction();
		Transaction t = sess.beginTransaction();

		Employee e1 = new Employee();
		e1.setName("Ravi Malik");
		e1.setEmail("ravi@gmail.com");
		e1.setSkill("Python");
		sess.save(e1);
		Employee e2 = new Employee();
		e2.setName("Amit");
		e2.setEmail("amit@gmail.com");
		e2.setSkill("java");
		sess.save(e2);
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		Employee emp3 = new Employee();
		emp1.setEmail("Shivesh.Bharti@genpact.com");
		emp1.setName("Shivesh");
		emp1.setSkill("Python");
		sess.save(emp1);
		// 2nd employee
		emp2.setEmail("Shivesh.Raj@genpact.com");
		emp2.setName("Shiva");
		emp2.setSkill("Java");
		sess.save(emp2);
		// 3rd employee
		emp3.setEmail("Amit.Kumar@genpact.com");
		emp3.setName("Amit");
		emp3.setSkill("Java");
		sess.save(emp3);
		System.out.println("Save !!!");
		t.commit();
		List employees = sess.createQuery("FROM Employee").list();
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.print(" Name: " + employee.getName());
			System.out.print("  Email: " + employee.getEmail());
			System.out.println("  Skill: " + employee.getSkill());
		}

		System.out.println("success");
		sess.close();
	}

}
