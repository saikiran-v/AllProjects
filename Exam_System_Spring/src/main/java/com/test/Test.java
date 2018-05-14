package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Maths;
import com.Physics;
import com.Student;
import com.Subject;

/**
 * @author saikiran.v
 *
 */
public class Test {
	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		List<Subject> listSubject = new ArrayList<Subject>();

		Student s = ac.getBean("student", Student.class);
		s.setStudId(2);
		s.setName("aditya");

		Scanner scanner = new Scanner(System.in);
		String registerStudent = s.registerStudent();
		System.out.println("your Registration no ." + registerStudent);

		System.out.println("subjects to register for Exam");
		Subject subject = new Maths();
		Subject subject1 = new Physics();

		listSubject.add(subject1);
		listSubject.add(subject);

		s.setSubject(listSubject);

		System.out.println("Enter 2 to register for exam");
		int input1 = scanner.nextInt();
		s.registerForExam();

		System.out.println("Your register for subject ::");
		s.getSubject().forEach(s1 -> System.out.println(s1.getSubjectName()));

		System.out.println("***** Registration Done ****");
		System.out.println("Enter 3 to appear for Exam");
		int input3 = scanner.nextInt();

		String result = s.appearForExam();
		System.out.println("Enter 4 to  Exam Results");
		int input4 = scanner.nextInt();

		System.out.println("result for admission No. " + s.getAdmissionId() + " is " + result);

		scanner.close();

	}
}
