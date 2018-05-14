package com.dao;

import com.Student;

/**
 * @author saikiran.v
 *
 */
public interface StudentDao {

	public Student getStudent(int sid);

	

	void insertStudent(Student student);



	/**
	 * 
	 *	returns void
	 */
	public void insertSubject(Student student);
}
