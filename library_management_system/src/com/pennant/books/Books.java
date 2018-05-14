package com.pennant.books;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author saikiran.v
 *
 */
public abstract class Books {
	public String nameOfBook;
	public String authorName;
	public int noOfBooks;
	LocalDate issueDate;
	LocalDate returnDate;
	public static List<Catlog> listCatlog;
	
	
	public Catlog catlog;

	static {
		listCatlog = new ArrayList<Catlog>();
		Catlog c1 = new Catlog();
		c1.setAuthorName("RS Agarwal");
		c1.setNoOfCopies(500);
		listCatlog.add(c1);
		Catlog c2 = new Catlog();
		c2.setAuthorName("Joshua Bloch");
		c2.setNoOfCopies(500);
		listCatlog.add(c2);
		Catlog c3 = new Catlog();
		c3.setAuthorName("AUthor");
		c3.setNoOfCopies(500);
		listCatlog.add(c3);
	}

	public Books(String nameOfBook, String authorName, int noOfBooks, Catlog catlog1) {
		super();
		this.nameOfBook = nameOfBook;
		this.authorName = authorName;
		this.noOfBooks = noOfBooks;
		this.catlog=catlog1;
	}

	public Books() {
		// TODO Auto-generated constructor stub
	}

	public String getNameOfBook() {
		return nameOfBook;
	}

	public void setNameOfBook(String nameOfBook) {
		this.nameOfBook = nameOfBook;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getNoOfBooks() {
		return noOfBooks;
	}

	public void setNoOfBooks(int noOfBooks) {
		this.noOfBooks = noOfBooks;
	}

	public void addCatlog(Catlog catl) {
		listCatlog.add(catl);
	}

	public void removeCatlog(Catlog catl) {
		boolean flag = listCatlog.contains(catl);
		if (flag) {
			listCatlog.remove(catl);
		}

	}

	public static Catlog getCatlog(String authorName) {
		for (Catlog catlog2 : listCatlog) {
			if (catlog2.getAuthorName() == authorName) {
				return catlog2;
			}
		}
		return null;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "Books [nameOfBook=" + nameOfBook + ", authorName=" + authorName + ", noOfBooks=" + noOfBooks
				+ ", catlog=" + catlog + "]";
	}
	
	
	/*
	 * public static void main(String[] args) {
	 * //listCatlog.forEach(s->System.out.println(s.authorName));
	 * System.out.println(getCatlog("Joshua Bloch").authorName); }
	 */
}
