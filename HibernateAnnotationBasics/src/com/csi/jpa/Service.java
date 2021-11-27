package com.csi.jpa;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Service {
	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
public static void main(String[] args) {
    //saveData();
	//getData();
	
	//updateData();
	
	deleteData();
}
 static void saveData(){
	Session session =factory.openSession();
	Transaction transaction = session.beginTransaction();
	
	Employee employee = new Employee();
	employee.setEmpName("BINU");
	employee.setEmpSalary(45000.45);
	session.save(employee);
	transaction.commit();
}

  static  void updateData(){
	Session session = factory.openSession();
	Transaction transaction = session.beginTransaction();
	List<Employee> empList = session.createQuery("from Employee").list();
	for (Employee e1:empList){
		if (e1.getEmpId()==2){
			e1.setEmpName("MANI");
			e1.setEmpSalary(50000.45);
			session.update(e1);
transaction.commit();
	}
	}
}

 static void deleteData(){
	 Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> empList = session.createQuery("from Employee").list();
		for (Employee e1:empList){
			if (e1.getEmpId()==2){
				
				session.delete(e1);
	transaction.commit();
		}
		}
}

  static void getData(){
	
Session session= factory.openSession();

List<Employee> empList = session.createQuery("from Employee").list();
empList.forEach(System.out::println);
}

}
