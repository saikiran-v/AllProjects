package com.examination;

import com.Student;

/**
 * @author saikiran.v
 *
 */
public class ExamRegistrar {
	
	private static ExamRegistrar examRegistrar = null;

	private ExamRegistrar() {

	}

	public static ExamRegistrar getExamRegistrar() {

		if (examRegistrar == null) {
			examRegistrar = new ExamRegistrar();
		}
		return examRegistrar;
	}

	public Exam registeringStudentForExamination(Student student) {
		Paper p = new Paper();
		Exam e = new Exam(p);
		return e;
	}

}
