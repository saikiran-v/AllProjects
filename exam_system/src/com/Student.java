package com;

import java.time.LocalDate;
import java.util.List;

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
	private boolean maritalStatus;
	private int age;
	private String sex;
	private LocalDate dateOfBirth;
	private String address;
	private String primaryEmailId;
	private String SecondaryEmailId;
	private long PhoneNumber;
	private String HighestEducationQualification;
	private String nationality;
	private String admissionId;
	private String result;
	private Exam exam;
	private List<Subject> subject;

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

	public boolean isMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(boolean maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrimaryEmailId() {
		return primaryEmailId;
	}

	public void setPrimaryEmailId(String primaryEmailId) {
		this.primaryEmailId = primaryEmailId;
	}

	public String getSecondaryEmailId() {
		return SecondaryEmailId;
	}

	public void setSecondaryEmailId(String secondaryEmailId) {
		SecondaryEmailId = secondaryEmailId;
	}

	public long getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getHighestEducationQualification() {
		return HighestEducationQualification;
	}

	public void setHighestEducationQualification(String highestEducationQualification) {
		HighestEducationQualification = highestEducationQualification;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String registerStudent() {
		Registrar registrar = Registrar.getRegistrar();
		int registerStudent = registrar.registerStudent(this);
		if (registerStudent != 0) {
			admissionId = registerStudent + "";
		}
		return admissionId;
	}

	public void registerForExam() {

		ExamRegistrar examRegistrar = ExamRegistrar.getExamRegistrar();
		this.exam = examRegistrar.registeringStudentForExamination(this);

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
