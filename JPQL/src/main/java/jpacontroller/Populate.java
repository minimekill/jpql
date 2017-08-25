/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontroller;

import entities.Semester;
import entities.Student;
import entities.Teacher;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Dixie
 */

public class Populate {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_JPQL_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        
        em.getTransaction().begin();
        
        
        List<Student> students = em.createNamedQuery("Student.findAll",Student.class).getResultList();   // FOUND ALL THE STUDENTS !!!
        
      
        
        List<Student> studentsNamedAnders = em.createNamedQuery("Student.findByFirstname",Student.class).setParameter("firstname", "Anders").getResultList(); // Got dem Anders!!!
        
        
        Student student = new Student();
        student.setFirstname("Fedtmule");
        student.setLastname("and");
        student.setId(777l);
        Semester semester = (Semester) em.createNamedQuery("Semester.findById",Semester.class).setParameter("id", 1);
        
        student.setSemester(semester);
        
        em.persist(em);
        
        List<Student> studentsNamedAnd = em.createNamedQuery("Student.findByLastname",Student.class).setParameter("lastname", "and").getResultList();
        
        
        int sumOfStudents = em.createNamedQuery("Student.findAll", Student.class).getResultList().size();
        
        
        
        
        em.getTransaction().commit();
        em.close();
    }
}
