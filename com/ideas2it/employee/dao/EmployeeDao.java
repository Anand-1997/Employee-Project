/**
 * In this program we define the DAO layer and
 * the instructions neccessary for each method.
 * @version 11.0.3 
 * @author Anand P
 * @since 17.12.2020
**/
package com.ideas2it.employee.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.hibernateconnection.SessionManagement;

/*
 * This class contains the list of Employees and the details of Employees
 * all CRUD operations are done in this class
 * this class will be accessed by services
 */

public class EmployeeDao {

	/*
     * Used to insert the values into the database given
     * by the values provided by user
     * @param it gets the parameter of Employees type to create the person
     * @param it gets the parameter of Address to create currentAddress
     * @param it gets the parameter of Address to create permanentAddress
     */   

    public void insertEmployee(Employee employee,Address currentAddress, Address permanentAddress) {
    	Session session = null;
    	Transaction transaction = null;
        try {
            SessionFactory sessionFactory = SessionManagement.getSessionFactory();
            System.out.println(sessionFactory);
            session = sessionFactory.openSession();
            employee.setStatus("active");
            transaction = session.beginTransaction();
            int id = (int) session.save(employee); 
            employee.setEid(id);
            currentAddress.setEmployee(employee);
            permanentAddress.setEmployee(employee);
            Set addressSet = new HashSet();
            addressSet.add(currentAddress);
            addressSet.add(permanentAddress);
            employee.setAddress(addressSet);
            session.save(currentAddress);
            session.save(permanentAddress);
            transaction.commit();
            } catch (Exception ex) {
                System.out.println("unable to add User value" + ex);
            } finally {
                session.close();
            }
    }
    
    /*
     * Used to delete the values into the database given
     * by the id provided by user
     * @param it gets the id of Employees for deleting
     */   

    public void deleteEmployee(int id) {
    	int noOfRowAffected = 0;
        Session session = null;
        Transaction transaction = null;
        try {
            System.out.println("Inside Dao");
            SessionFactory sessionFactory = SessionManagement.getSessionFactory();
            System.out.println(sessionFactory);
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("update Employee employee set  " +
                    "employee.status = :status  where employee.eid = :employeeId");
            query.setParameter("status", "passive");
            query.setParameter("employeeId", id);
            noOfRowAffected = query.executeUpdate();
            transaction.commit();
        } catch (Exception ex) {
            System.out.println("unable to add User value" + ex);
        } finally {
            session.close();
        }
    }
    
    /*
     * Used to retrive the values into the database given
     * by the id provided by user
     * @param it gets the id of Employees for retriving
     */
    public void retriveEmployee(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            System.out.println("Inside Dao");
            SessionFactory sessionFactory = SessionManagement.getSessionFactory();
            System.out.println(sessionFactory);
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Employee employee where employee.eid = :employeeId");
            query.setParameter("employeeId",id);
            Employee employee = (Employee) query.uniqueResult();
            System.out.println(employee);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println("unable to add User value" + ex);
        } finally {
            session.close();
        }
    }
    
    /*
     * Used to print the values from the database given
     * provided by user
     */
    public void listEmployee() {
        Session session = null;
        Transaction transaction = null;
        List<Employee> employeeList = new ArrayList<Employee>();
        try {
            System.out.println("Inside Dao");
            SessionFactory sessionFactory = SessionManagement.getSessionFactory();
            System.out.println(sessionFactory);
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Employee employee");
            employeeList = query.list();
            System.out.println(employeeList);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println("unable to add User value" + ex);
        } finally {
            session.close();
        }
    }
    
    /*
     * Used to update the values from the database given
     * provided by user
     */
    public void updateEmployee(Employee employee,Address currentAddress, Address permanentAddress) {
        Session session = null;
        Transaction transaction = null;
        try {
            System.out.println("Inside Dao"+employee.getEid());
            SessionFactory sessionFactory = SessionManagement.getSessionFactory();
            System.out.println(sessionFactory);
            session = sessionFactory.openSession();
            employee.setStatus("active");
            System.out.println(employee.getStatus());
            transaction = session.beginTransaction();
            session.saveOrUpdate(employee); 
            currentAddress.setEmployee(employee);
            permanentAddress.setEmployee(employee);
            Set addressSet = new HashSet();
            addressSet.add(currentAddress);
            addressSet.add(permanentAddress);
            employee.setAddress(addressSet);
            session.saveOrUpdate(currentAddress);
            session.saveOrUpdate(permanentAddress);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println("unable to add User value" + ex);
        } finally {
            session.close();
        }
    }
        
}






