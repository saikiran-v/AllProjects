package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.examination.Exam;
import com.examination.ExamRegistrar;
import com.examination.Paper;
import com.registration.Registrar;

/**
 * @author saikiran.v
 *
 */

public class Student {
	private String name;
	private int studId;

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	private int age;
	/*
	 * private boolean maritalStatus; private String sex; private LocalDate
	 * dateOfBirth; private String address; private String primaryEmailId;
	 * private String SecondaryEmailId; private long PhoneNumber; private String
	 * HighestEducationQualification; private String nationality;
	 */

	private String admissionId;
	private String result;
	private Exam exam;
	private List<Subject> subject;

	@Autowired
	private Registrar registrar;

	@Autowired
	private ExamRegistrar examRegistrar;

	public Registrar getRegistrar() {
		return registrar;
	}

	public void setRegistrar(Registrar registrar) {
		this.registrar = registrar;
	}

	public ExamRegistrar getExamRegistrar() {
		return examRegistrar;
	}

	public void setExamRegistrar(ExamRegistrar examRegistrar) {
		this.examRegistrar = examRegistrar;
	}

	public String registerStudent() {

		
		return registrar.registerStudent(this);
	}

	public void registerForExam() {

		this.exam = examRegistrar.registeringStudentForExamination(this);
		

	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}

	public String getAdmissionId() {
		return admissionId;
	}

	public void setAdmissionId(String admissionId) {
		this.admissionId = admissionId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Student() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void addSubject(Subject subject) {
		this.subject.add(subject);
	}

	public void deleteSubject(Subject subject) {
		System.out.println("You have Removed " + subject.getSubjectName());
		this.subject.remove(subject);
	}

	public String appearForExam() {
		Paper paper = exam.getPaper();
		return paper.submit();
	}

}
