package com.jbk.dao;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Student;

@Repository
public class StudentDao {

	@Autowired
	SessionFactory factory;

	public String insertData(Student s) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		ss.persist(s);
		tr.commit();
		ss.close();
		return "Data is Inserted Successufully!";

	}

	public String deleteData(int stud_id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Student s1 = ss.get(Student.class, stud_id);
		ss.remove(s1);
		tr.commit();
		ss.close();
		return "Data is Deleted Successfully!";
	}

	public String updateData(Student s, int stud_id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Student s1 = ss.get(Student.class, stud_id);
		s1.setName(s.getName());
		s1.setCity(s.getCity());
		s1.setMobile(s.getMobile());
		ss.merge(s1);
		tr.commit();
		ss.close();
		return "Data is updated successufully!";
	}

	public Student getSingleRecord(int stud_id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlquery = "from Student where stud_id=:myid";
		Query<Student> query = ss.createQuery(hqlquery, Student.class);
		query.setParameter("myid", stud_id);
		Student s1 = query.uniqueResult();

		tr.commit();
		ss.close();
		return s1;
	}

	public List<Student> getAllRecord() {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlquery = "from Student";
		Query<Student> query = ss.createQuery(hqlquery, Student.class);
		List<Student> list = query.list();

		tr.commit();
		ss.close();
		return list;

	}

}
