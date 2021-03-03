package com.nik;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Manager {
	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		while (true) {
			System.out.println("1. Create employee\n" + "2. Update employee id\n"
					+ "3. Delete employee - warning: this cannot be recovered\n" + "4. get all Employee\n"
					+ "5. Get Employee by id\n" + "6. exit\n" + "Enter your choice (1-6)");
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
			if (ch == 1) {
				Transaction tx = session.beginTransaction();

				Employee em = new Employee();
				System.out.println("Enter id :");
				int id = sc.nextInt();
				em.setId(id);

				System.out.println("Enter First name :");
				String fname = sc.next();
				em.setFirstname(fname);

				System.out.println("Enter Last Name");
				String lname = sc.next();
				em.setLastname(lname);

				System.out.println("Enter Age");
				int age = sc.nextInt();
				em.setAge(age);

				System.out.println("Enter Salary");
				int salary = sc.nextInt();
				em.setSalary(salary);

				System.out.println("Enter DOB");
				String dob = sc.next();
				em.setDob(dob);

				System.out.println("Enter Designation");
				String designation = sc.next();
				em.setDesignation(designation);

				System.out.println("Employee has been successfully created");

				session.save(em);
				tx.commit();
			} else if (ch == 2) {
				Transaction tx = session.beginTransaction();

				System.out.println("Enter the id");
				int id = sc.nextInt();

				System.out.println("Enter new id");
				int newId = sc.nextInt();
				String s = String.format("Update Employee SET id ='%d' where id ='%d';", newId, id);
				try {
					session.createSQLQuery(s).executeUpdate();
					System.out.println("Employee ID successfully updated !");
					tx.commit();
				} catch (Exception e) {
					System.out.println("Enter the correct Employee ID");
				}
				System.out.println("Updation Done!");
				tx.commit();
			} else if (ch == 3) {
				Transaction tx = session.beginTransaction();
				System.out.println("Enter Id of employee to delete :");
				int id = sc.nextInt();
				String s = String.format("Delete from Employee where id ='%d';", id);
				try {
					session.createSQLQuery(s).executeUpdate();
					System.out.println("row deleted !");
					tx.commit();
				} catch (Exception e) {
					System.out.println("Employee Not Found!");
				}
				tx.commit();
			} else if (ch == 4) {
				Transaction tx = session.beginTransaction();
				Session s = Config.getSession();
				List<Employee> employees = s.createQuery("from Employee", Employee.class).list();
				for (Employee emp : employees) {
					System.out.println(emp);
				}
				tx.commit();

			} else if (ch == 5) {
				Transaction tx = session.beginTransaction();
				System.out.print("Enter id of employee to Fetch Details: ");
				int id = sc.nextInt();
				try {
					Employee em = session.load(Employee.class, id);
					System.out.println("\n" + em.toString());
				} catch (NullPointerException e) {
					System.out.println("No Such Employee Found");
				}
				tx.commit();
			} else if (ch == 6) {
				System.exit(0);
			} else {
				System.out.println("\nEnter a Correct Choice");
			}
		}
	}
}
