package com.pennant.librarymember;

import java.util.List;

import com.pennant.books.Books;
import com.pennant.librain.Librain;

/**
 * @author saikiran.v
 *
 */
public  abstract class Member {
	public String mName;
	public String mAddress;
	public int mNo;
	
	Librain librain;
	{
		librain=new Librain();
	}
	public void mRequestForBK(List<Books> books) {
		librain.issueBooks(this, books);
		
	}

	public void mReturnBk(String yesN) {
		librain.returnBook(this,yesN);
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmAddress() {
		return mAddress;
	}

	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	@Override
	public String toString() {
		return "Member [mName=" + mName + ", mAddress=" + mAddress + ", mNo=" + mNo + "]";
	}
	
}
