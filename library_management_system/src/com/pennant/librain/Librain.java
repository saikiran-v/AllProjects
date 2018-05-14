package com.pennant.librain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.pennant.books.Books;
import com.pennant.books.Catlog;
import com.pennant.books.GeneralBook;
import com.pennant.books.ReferenceBook;
import com.pennant.librarymember.Member;

/**
 * @author saikiran.v
 *
 */
public class Librain {
	public String name;
	public String address;
	public float mobileNo;
	static List<Books> books = null;
	Map<Member, List<Books>> issuedBooks = null;
	List<Member> members = null;
	Scanner scn = new Scanner(System.in);

	{
		issuedBooks = new HashMap<Member, List<Books>>();
		members = new ArrayList<>();
		books = new ArrayList<Books>();
		Catlog catlog1 = Books.getCatlog("RS Agarwal");
		ReferenceBook b1 = new ReferenceBook("quantitative aptitude", "RS Agarwal", 10, catlog1);
		books.add(b1);
		Catlog catlog2 = Books.getCatlog("Joshua Bloch");
		ReferenceBook b2 = new ReferenceBook("Java 8", "Joshua Bloch", 10, catlog2);
		books.add(b2);
		Catlog catlog3 = Books.getCatlog("AUthor");
		GeneralBook gb1 = new GeneralBook("GS", "AUthor ", 10, catlog3);
		books.add(gb1);

	}

	public void updateInfo() {

	}

	public void issueBooks(Member member, List<Books> books) {

		issuedBooks.put(member, books);

	}

	public void memberInfo() {

	}

	public Books searchBook(String bookName) {

		for (Books books2 : books) {
			if (books2.nameOfBook.equals(bookName)) {
				return books2;
			}
		}

		return null;
	}

	public List<Books> listOfBooksTook(Member member) {
		return issuedBooks.get(member);
	}

	public void returnBook(Member member, String returnBooks) {

		List<Books> list = issuedBooks.get(member);
		if (list.isEmpty()) {
			System.out.println("No books to return");
		} else {

			System.out.println("Books you took from lirary & Returned Back");
			list.forEach(System.out::println);
			if (returnBooks.equals("y")) {
				issuedBooks.remove(member);
			}
		}
	}

	public void displayBooks() {
		books.forEach(s -> System.out.println(s));
	}

}
