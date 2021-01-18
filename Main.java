//package com.ideas2it;

import java.util.InputMismatchException;
import java.util.Scanner;

//import com.ideas2it.dbconnection.HibernateSessionFactory;
import com.ideas2it.employee.controller.EmployeeController;
//import com.ideas2it.project.controller.ProjectController;
import com.ideas2it.employee.dao.EmployeeDao;
//import com.ideas2it.project.dao.ProjectDao;
//import com.ideas2it.employee.model.Address;
//import com.ideas2it.employee.model.Employee;
//import com.ideas2it.project.model.Project;
import com.ideas2it.employee.service.EmployeeService;
//import com.ideas2it.project.service.ProjectService;
import com.ideas2it.project.controller.ProjectController;


/* This Main class gives the use options to either give access to
 * EmployeeContoller or ProjectConroller and perform all the CRUD 
 * operations with the help of the Collections
 * @author Anand P
 * @version 11.0.3
 * since 14-12-2020
 */
public class Main {

    public static void main(String[] args) {
        //Main main = new Main();
        /*To create the object for Employeecontroller class */
        EmployeeController employeeController = new EmployeeController();         
        /* To create object for ProjectController class */  
        ProjectController projectController = new ProjectController();
        int options;
        System.out.println(); 
            do {
                System.out.println("Select the option");
                System.out.println("1:Employee Details");               
                System.out.println("2:Project Details");
                System.out.println("Enter your option ");
                Scanner scanner = new Scanner(System.in);
                options = scanner.nextInt();
                switch(options) {
                case 1:
                    /* It calls the employeeControl method from EmployeeController class */
		    		employeeController.employeeControl();            
                    break;                   
                case 2:
                    /* It calls the projectControl method from ProjectController class */
                    projectController.projectControl();
                    break;		    
                default:
                    System.out.println("Invalid Option. Please Enter the Correct option");
                    break;
                }          
         }while(options != 2); 
    }
}
