package com.registration;

import com.Student;
import com.registration.Validator;

/**
 * @author saikiran.v
 *
 */
public class Registrar {

	private static Registrar registrar = null;

	private Registrar() {

	}

	public static Registrar getRegistrar() {

		if (registrar == null) {
			registrar = new Registrar();
		}
		return registrar;
	}

	public int registerStudent(Student student) {
		Validator v = Validator.getValidator();
		boolean validateStudentDetails = v.validateStudentDetails(student);
		if (validateStudentDetails)
			return 101;
		else
			return 0;

	}

}
