package com.pennant.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pennant.books.Books;
import com.pennant.librain.Librain;
import com.pennant.librarymember.Member;
import com.pennant.librarymember.Student;

/**
 * @author saikiran.v
 *
 */
public class Test {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		List<Books> selectedBooks = new ArrayList<>();
		Member member = new Student();
		member.setmName("sai");
		member.setmNo(222);
		member.setmAddress("LB nagar hyderabad");
		Librain lib = new Librain();

		lib.displayBooks();
		boolean whileFlag = true;
		while (whileFlag) {
			System.out.println("Press 1 to issue book/Checkout");
			System.out.println("Press 2 to return a book");
			System.out.println("press 3 member info");
			System.out.println(" press 4 searchbook");
			String s = scn.nextLine();
			switch (s) {
			case "1":
				member.mRequestForBK(selectedBooks);
				selectedBooks.forEach(System.out::println);
				System.out.println("Do you Want to add more books y/n");
				String yes_No1= scn.nextLine();
				if(yes_No1.equals("n")){
					if(selectedBooks.isEmpty()==false)
					System.out.println("books Issue to Member "+member.getmName());
				}
				break;
			case "2":
				List<Books> returnBook = lib.listOfBooksTook(member);
				System.out.println("Books you took from lirary");
				returnBook.forEach(System.out::println);
				System.out.println("Do you Want to return those books y/n");
				String yes_No = scn.nextLine();
				if (yes_No.equals("n")) {
					System.out.println("Books Not Return");
				} else {
					member.mReturnBk(yes_No);
				}
				break;
			case "3":
				System.out.println("Member Info");
				System.out.println(member);
				System.out.println("Do you Want to update member Data y/n");
				String yeso = scn.nextLine();
				
				break;
			case "4":
				System.out.println("Select Books");

				boolean flag = true;
				while (flag) {
					System.out.println("Enter Book Name");
					String bookName = scn.nextLine();
					Books searchBook = lib.searchBook(bookName);

					if (searchBook == null || searchBook.getNoOfBooks() == 0) {
						System.out.println("Out Of Stock");
					} else {

						System.out.println("Do you Want to add to cart y/n");
						String cart = scn.nextLine();
						searchBook.setIssueDate(LocalDate.now());
						searchBook.setReturnDate(searchBook.getIssueDate().plusDays(10l));
						if (cart.equals("y")) {
							selectedBooks.add(searchBook);
							System.out.println("your Checkout list is");
							System.out.println("Selected Books -->");
							selectedBooks.forEach(System.out::println);
							lib.issueBooks(member, selectedBooks);
						}
						System.out.println("Do you Want to Select More Books y/n");
						String s1 = scn.nextLine();
						if (s1.equals("n")) {
							flag = false;
						}
					}

				}

				break;
			default:
				whileFlag = false;
				break;
			}
		}
	}

}
