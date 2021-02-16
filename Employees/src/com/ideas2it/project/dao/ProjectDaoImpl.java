/**
 * In this program we define the DAO layer and
 * the instructions neccessary for each method.
 * @version 11.0.3 
 * @author Anand P
 * @since 17.12.2020
**/
package com.ideas2it.project.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//import com.ideas2it.employee.model.Employee;
import com.ideas2it.project.model.Project;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.hibernateconnection.SessionManagement;

/*
 * this class contains the list of Projects and the details of Employees
 * all CRUD operations are done in this class
 * this class will be accessed by services
 */
public class ProjectDaoImpl implements ProjectDao {

	/*
	 * Used to insert the values into the database given by the values provided by
	 * user
	 * 
	 * @param it gets the parameter of Employees type to create the person
	 */
	public void addProject(Project project) throws Exception {
		Session session = null;
        Transaction transaction = null;
        try{
        	SessionFactory sessionFactory = SessionManagement.getSessionFactory();
        	project.setStatus("active");
        	session = sessionFactory.openSession();  
            transaction = session.beginTransaction();
            session.saveOrUpdate(project);
            transaction.commit();
        } catch (Exception ex) {
            throw new Exception("Unable to distribute project, because this match is already paired " );
        } finally {
            try {
                session.close(); 
            } catch(Exception e) {
                throw new Exception("Unable to close session");
            }
        }
    }


	/*
	 * Used to delete the values into the database given by the id provided by user
	 * 
	 * @param it gets the id of Employees for deleting
	 */
	
	  public void deleteProject(int id) { 
		 int noOfRowAffected = 0; 
		 Session session= null; 
		 Transaction transaction = null; 
		 try {
			  System.out.println("Inside Dao"); 
			  SessionFactory sessionFactory = SessionManagement.getSessionFactory(); 
			  System.out.println(sessionFactory);
			  session = sessionFactory.openSession(); 
			  transaction = session.beginTransaction(); 
			  Query query =session.createQuery("update Project project set  " + "project.status = :status  where project.projectId = :projectId");
			  query.setParameter("status", "passive"); 
			  query.setParameter("projectId", id);
			  noOfRowAffected = query.executeUpdate(); 
			  transaction.commit(); 
			  } catch (Exception ex) { 
				  System.out.println("unable to add User value" + ex); 
				  } finally { 
					  session.close(); 
				  } 
		 }
			  
	/* Used to print the values from the database given provided by user */
	  
	  public List<Project> listProject() { 
		 Session session = null; 
		 Transaction transaction = null; 
		 List<Project> projectList = new ArrayList<Project>(); 
		 try {
			 System.out.println("Inside Dao"); 
			 SessionFactory sessionFactory = SessionManagement.getSessionFactory(); 
			 System.out.println(sessionFactory);
			 session = sessionFactory.openSession(); transaction =
			 session.beginTransaction();
			 Query query = session.createQuery("from Project project"); 
			 projectList = query.list();
			 System.out.println(projectList);
			 transaction.commit(); 
			 } catch (Exception ex) { 
				 System.out.println("unable to add User value" + ex); 
		     } finally {
		    	 session.close(); 
		     }
		 return projectList;
		 }
	  
	  
	  

/* Used to update the values from the database given provided by user */
 
 public void updateProject(Project project) { 
	 Session session = null;
	 Transaction transaction = null; 
	 try { 
		 System.out.println("InsideDao"+project.getProjectId()); 
		 SessionFactory sessionFactory = SessionManagement.getSessionFactory(); 
		 System.out.println(sessionFactory);
		 project.setStatus("active");
		 session = sessionFactory.openSession();  
		 transaction = session.beginTransaction(); 
		 session.saveOrUpdate(project);
		 transaction.commit(); 
		 } catch (Exception ex) { 
			 System.out.println("unable to add User value" + ex); 
		 } finally { 
		  session.close(); 
	  } 
	 }

public void assignEmployee(int assignProjectId, int[] employeeid) {
	 Session session = null; 
	  Transaction transaction = null;
	  try { 
		  SessionFactory sessionFactory = SessionManagement.getSessionFactory();
		  System.out.println(sessionFactory); 
		  session = sessionFactory.openSession();
		  Query query = session.createQuery("from Project project where project.projectId = :projectId");
		  query.setParameter("projectId",assignProjectId); 
		  Project project = (Project)query.uniqueResult(); 
		  Set <Employee> employeeSet = project.getEmployee(); 
		  for(int empId : employeeid) {
			  Query querys = session.createQuery("from Employee employee where employee.eid = :employeeId"); 
			  querys.setParameter("employeeId",empId); 
			  Employee employee =(Employee) querys.uniqueResult();
			  employeeSet.add(employee);
			  }
		  System.out.println(employeeSet);
		  project.setEmployee(employeeSet); 
		  session.saveOrUpdate(project); 
		  transaction= session.beginTransaction(); 
		  transaction.commit(); 
		  } catch (Exception ex) {
			  System.out.println("unable to add User value" + ex); 
			  } finally {
				  session.close(); 
				  }
	  
	
}


@Override
public Project getProject(Integer projectid) {
	Session session = null; 
	  Transaction transaction = null;
	  Project project = new Project();
	  try { 
		  SessionFactory sessionFactory = SessionManagement.getSessionFactory();
		  System.out.println(sessionFactory); 
		  session = sessionFactory.openSession();
		  Query query = session.createQuery("from Project project where project.projectId = :projectId");
		  query.setParameter("projectId", projectid);
		  project = (Project)query.uniqueResult(); 
		  transaction= session.beginTransaction(); 
		  transaction.commit();
		  session.close(); 
		  } catch (Exception ex) {
			  System.out.println("unable to add User value" + ex); 
			  }
	return project;
	}


@Override
public List<Employee> getEmployees() {
	// TODO Auto-generated method stub
	Session session = null; 
	 Transaction transaction = null; 
	 List<Employee> employeeList = new ArrayList<Employee>(); 
	 try {
		 System.out.println("Inside Dao"); 
		 SessionFactory sessionFactory = SessionManagement.getSessionFactory(); 
		 System.out.println(sessionFactory);
		 session = sessionFactory.openSession(); transaction =
		 session.beginTransaction();
		 Query query = session.createQuery("from Employee employee where status = :status");
		 query.setParameter("status", "active");
		 employeeList = query.list();
		 System.out.println(employeeList);
		 transaction.commit(); 
		 } catch (Exception ex) { 
			 System.out.println("unable to add User value" + ex); 
	     } finally {
	    	 session.close(); 
	     }
	 return employeeList;
}
 }
/**
 * public void assignEmployee(int employeeId, int projectId) throws Exception{
 * Session session = null; Transaction transaction = null; try { SessionFactory
 * sessionFactory = SessionManagement.getSessionFactory();
 * System.out.println(sessionFactory); session = sessionFactory.openSession();
 * Query query = session.createQuery("from Employee employee where employee.eid
 * = :employeeId" ); query.setParameter("employeeId",employeeId); Project
 * project = (Project) query.uniqueResult(); Query querys = session.
 * createQuery("from Project project where project.projectId = :projectId");
 * querys.setParameter("projectId",projectId); Project project1 = (Project)
 * querys.uniqueResult(); Set <Project> projectSet = project.getEmployee();
 * projectSet.add(project1); project.setEmployee(projectSet);
 * session.saveOrUpdate(project); transaction = session.beginTransaction();
 * transaction.commit(); } catch (Exception ex) { System.out.println("unable to
 * add User value" + ex); } finally { session.close(); } }
 * 
 */

