package hibernet_project001;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {

	public static void main(String[] args) {
		
		Student student = new Student(2, "Almaz", "Kochito");
		
		
		Configuration configuration = new Configuration();
		configuration.configure().addAnnotatedClass(Student.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()). build();
		
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		//session.save(student);
		
		session.delete(student);
		
		
		transaction.commit();
		session.close();

	}

}
