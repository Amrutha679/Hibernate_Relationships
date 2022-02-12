package com.main;

import java.util.HashSet;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.manytomany.Course;
import com.manytomany.Student;
import com.onetomany.*;
import onetoone.*;

public class MainLogic {

	public static void main(String[] args) {
	
		Session se = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = se.beginTransaction();
	
		Vendor v = new Vendor();
		
		((Vendor) v).setVendorId(111);
		v.setVendorName("Flipkart");

		Customers c1 = new Customers();
		c1.setCustomerId(222);
		c1.setCustomerName("Aarav");
		
		Customers c2 = new Customers();
		c2.setCustomerId(333);
		c2.setCustomerName("Keerthan");
		
		Set set = new HashSet();
		set.add(c1);
		set.add(c2);
		
		Person pe = new Person();
		pe.setPersonId(101);
		pe.setPersonName("Amrutha");
		
		PanCard pan = new PanCard();
		pan.setPanCardId(201);
		pan.setPanCardNo("DNKPA1246399");
		pan.setObj(pe);
		
		Student st = new Student();
		st.setStudentId(101);
		st.setStudentName("Amrutha");
		
		Student st2 = new Student();
		st2.setStudentId(102);
		st2.setStudentName("Aarav");
		
		Student st3 = new Student();
		st3.setStudentId(103);
		st3.setStudentName("Keerthan");
		
		Set students = new HashSet();
		students.add(st);
		students.add(st2);
		students.add(st3);
		
		Course c = new Course();
		c.setCourseId(201);
		c.setCourseName("Java");
		
		Course cs = new Course();
		cs.setCourseId(202);
		cs.setCourseName("React Js");
		
		Set courses = new HashSet();
		courses.add(c);
		courses.add(cs);
		
		st2.setCourses(courses);
		st.setCourses(courses);
		c.setStudents(students);
		cs.setStudents(students);
		
		se.save(c);
		se.save(cs);
		se.save(st);
		
		//se.save(pe);
		//se.save(pan);
		
		//v.setObj(set);
		
		//se.save(v);
		
		tx.commit();
		se.close();
	}
}


