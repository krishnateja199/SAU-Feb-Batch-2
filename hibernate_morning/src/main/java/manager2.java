
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.*;

public class manager2 {
    private static <T> List<T> loadAllData(Class<T> type, Session session) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        criteria.from(type);
        List<T> data = session.createQuery(criteria).getResultList();
        return data;
    }
    public static void main(String args[]) {
        Session session = sessionutil.getSession();

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory factory = configuration.buildSessionFactory();

        Transaction tx = session.beginTransaction();


        while (true) {
            System.out.println("1. Create employee\n" +
                    "2. Update all employee\n" +
                    "3. Update employee by id\n" +
                    "4. Delete employee - warning: this cannot be recovered\n" +
                    "5. Get all employee\n" +
                    "6. Get Employee by id\n" +
                    "7. exit\n" +
                    "Enter your choice (1-6)");
            Scanner s = new Scanner(System.in);
            int n = s.nextInt();
            if (n == 1) {
                employee p2=new employee();
                System.out.println("please enter id,firstname,lastname,age,designation,dob and salary");
                int n1=s.nextInt();
                String s1=s.next();
                String s2=s.next();
                int n2=s.nextInt();
                String s3=s.next();
                String s4=s.next();
                int n3=s.nextInt();

                p2.setId(n1);
                p2.setFirstName(s1);
                p2.setLastName(s2);
                p2.setAge(n2);
                p2.setDesignation(s3);
                p2.setDob(s4);
                p2.setSal(n3);
                session.save(p2);
                tx.commit();
                System.out.println("Employee has been successfully created");

            } else if (n == 2) {
                System.out.println("Updating the designation of all employees");
                String sqlquery = "Update Employee SET Designation = 'SE intern' where Designation = 'sde'";
                try {
                    session.createSQLQuery(sqlquery).executeUpdate();
                    System.out.println("All records updated");
                    tx.commit();
                } catch (Exception e) {
                    System.out.println("Can't update fields");
                }



            } else if (n == 3) {
                System.out.println("Enter Employee Id whose details are to be updated");
                int currentID = s.nextInt();
                System.out.println("Enter the attribute to update:\n" +
                        "1- Employee ID\n" +
                        "2- First Name\n" +
                        "3- Last Name\n" +
                        "4- Age\n" +
                        "5- Designation\n" +
                        "6- Date of Birth\n" +
                        "7- Salary");
                int attribute = s.nextInt();
                switch (attribute) {
                    case 1:
                        System.out.println("Enter New ID");
                        int updatedID = s.nextInt();
                        s.nextLine();

                        String sqlquery = String.format("Update Employee SET id ='%d' where id ='%d';", updatedID, currentID);
                        try {
                            session.createSQLQuery(sqlquery).executeUpdate();
                            System.out.println("Employee ID successfully updated !");
                            tx.commit();
                        } catch (Exception e2) {
                            System.out.println("Enter the correct Employee ID");
                        }
                        break;


                    case 2:
                        System.out.println("Enter the updated First Name");
                        String updatedFname = s.next();
                        sqlquery = String.format("Update Employee SET firstName ='%s' where id ='%d';", updatedFname, currentID);
                        try {
                            session.createSQLQuery(sqlquery).executeUpdate();
                            System.out.println("First Name of employee with ID = " + currentID + "Updated");
                            tx.commit();
                        } catch (Exception e2) {
                            System.out.println("Enter the correct Employee ID");
                        }
                        break;


                    case 3:
                        System.out.println("Enter the updated Last Name");
                        String updatedLname = s.next();
                        sqlquery = String.format("Update Employee SET lastName ='%s' where id ='%d';", updatedLname, currentID);
                        try {
                            session.createSQLQuery(sqlquery).executeUpdate();
                            System.out.println("Last Name of employee with ID = " + currentID + "Updated");
                            tx.commit();
                        } catch (Exception e2) {
                            System.out.println("Enter the correct Employee ID");
                        }
                        break;

                    case 4:
                        System.out.println("Enter the updated Age of Employee ");
                        int updatedAge = s.nextInt();
                        sqlquery = String.format("Update Employee SET age ='%s' where id ='%d';", updatedAge, currentID);
                        try {
                            session.createSQLQuery(sqlquery).executeUpdate();
                            System.out.println("Age of employee with ID = " + currentID + "Updated");
                            tx.commit();
                        } catch (Exception e2) {
                            System.out.println("Enter the correct Employee ID");
                        }
                        break;

                    case 5:
                        System.out.println("Enter the updated Designation of Employee ");
                        String updatedDesignation = s.next();
                        sqlquery = String.format("Update Employee SET designation ='%s' where id ='%d';", updatedDesignation, currentID);
                        try {
                            session.createSQLQuery(sqlquery).executeUpdate();
                            System.out.println("Designation of employee with ID = " + currentID + "Updated");
                            tx.commit();
                        } catch (Exception e2) {
                            System.out.println("Enter the correct Employee ID");
                        }
                        break;


                    case 6:
                        System.out.println("Enter the updated DOB of Employee ");
                        String updatedDOB = s.next();
                        sqlquery = String.format("Update Employee SET dob ='%s' where id ='%d';", updatedDOB, currentID);
                        try {
                            session.createSQLQuery(sqlquery).executeUpdate();
                            System.out.println("DOB of employee with ID = " + currentID + "Updated");
                            tx.commit();
                        } catch (Exception e2) {
                            System.out.println("Enter the correct Employee ID");
                        }
                        break;

                    case 7:
                        System.out.println("Enter the updated Salary of Employee ");
                        int updatedSalary = s.nextInt();
                        sqlquery = String.format("Update Employee SET sal ='%s' where id ='%d';", updatedSalary, currentID);
                        try {
                            session.createSQLQuery(sqlquery).executeUpdate();
                            System.out.println("Salary of employee with ID = " + currentID + "Updated");
                            tx.commit();
                        } catch (Exception e2) {
                            System.out.println("Enter the correct Employee ID");
                        }
                        break;
                }




            }else if(n==4){
             //   tx = session.beginTransaction();
                System.out.println("Enter the Emplyee ID of the Employee whose records are to be delete");
                int ide = s.nextInt();
                String query = String.format("Delete from Employee where id ='%d';", ide);
                try {
                    session.createSQLQuery(query).executeUpdate();
                    System.out.println(" record is deleted !");
                    tx.commit();
                } catch (Exception e2) {
                    System.out.println("Employee Not Found!");
                }


            }
            else if (n == 5) {

                System.out.println(loadAllData(employee.class,session));


            } else if (n == 6) {
                System.out.println("Enter id of employee to fetch details");
                int num=s.nextInt();
                employee p1 = session.load(employee.class, num);
                System.out.println(p1.getAge());
                System.out.println(p1.getFirstName());
                System.out.println(p1.getLastName());
                System.out.println(p1.getDesignation());
                System.out.println(p1.getDob());
                System.out.println(p1.getId());
                System.out.println(p1.getSal());

            } else if (n == 7)
                System.exit(0);
            else {
                System.out.println("Enter correct Choice");
            }


        }
    }
}