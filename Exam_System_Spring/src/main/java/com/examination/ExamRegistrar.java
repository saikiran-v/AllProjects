package com.examination;

import com.Student;
import com.dao.StudentDao;

/**
 * @author saikiran.v
 *
 */
public class ExamRegistrar {

	private StudentDao studentDao;

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	private Exam exam;

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	private ExamRegistrar() {
		
	}

	public Exam registeringStudentForExamination(Student student) {
		studentDao.insertSubject(student);
		return exam;
	}

}
