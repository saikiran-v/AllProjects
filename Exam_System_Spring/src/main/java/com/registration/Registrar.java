package com.registration;

import com.Student;
import com.registration.Validator;

/**
 * @author saikiran.v
 *
 */
public class Registrar {

	private Validator validator;

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	public String registerStudent(Student student) {

		boolean validateStudentDetails = validator.validateStudentDetails(student);

		if (validateStudentDetails) {
			System.out.println("True "+getClass()+" admission id "+ student.getAdmissionId());
			return student.getAdmissionId();
		} else {
			System.out.println("false "+getClass());

			Student insertStudent = validator.insertStudent(student);
			return insertStudent.getAdmissionId()+"";
		}
	}

}
