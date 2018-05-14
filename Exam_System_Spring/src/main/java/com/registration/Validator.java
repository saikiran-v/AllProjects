package com.registration;

import com.Student;
import com.dao.StudentDao;

/**
 * @author saikiran.v
 *
 */
public class Validator {

	private StudentDao studentDao;

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public boolean validateStudentDetails(Student student) {
		boolean flag = false;
		Student student2 = studentDao.getStudent(student.getStudId());
		if (student2 != null) {
			if (student2.getStudId() == student.getStudId()) {
				System.out.println("true  " + getClass());
				student.setAdmissionId(student2.getAdmissionId());
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * @param student
	 *            returns Student
	 */
	public Student insertStudent(Student student) {
		student.setAdmissionId(student.getStudId() + "");
		studentDao.insertStudent(student);
		return student;
	}

}
