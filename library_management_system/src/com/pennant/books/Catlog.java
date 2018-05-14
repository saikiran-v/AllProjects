package com.pennant.books;

/**
 * @author saikiran.v
 *
 */
public class Catlog {

	public String authorName;
	public int noOfCopies;

	public void updateInfo() {
		
	}

	public void searchInfo() {
		
	}

	public Catlog(String authorName, int noOfCopies) {
		super();
		this.authorName = authorName;
		this.noOfCopies = noOfCopies;
	}
	
	public Catlog() {
		// TODO Auto-generated constructor stub
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	@Override
	public String toString() {
		return "Catlog [authorName=" + authorName + ", noOfCopies=" + noOfCopies + "]";
	}
	

}
