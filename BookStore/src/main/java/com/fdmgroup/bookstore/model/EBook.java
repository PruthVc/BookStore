package com.fdmgroup.bookstore.model;

import java.util.Objects;

public class EBook extends Book{
private double sizeMegaBytes;
	
	public EBook() {
		super();
	}
	
	public EBook(int itemId,double price, String tittle, String author,BookGenre bookGenre,double sizeMegabites) {
		super(itemId, price, tittle, author, bookGenre);
		this.sizeMegaBytes = sizeMegabites;
	}
	

	@Override
	public String toString() {
		return "EBook [sizeMegaBytes=" + sizeMegaBytes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(sizeMegaBytes);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EBook other = (EBook) obj;
		return Double.doubleToLongBits(sizeMegaBytes) == Double.doubleToLongBits(other.sizeMegaBytes);
	}

	public double getSizeMegaBytes() {
		return sizeMegaBytes;
	}

	public void setSizeMegaBytes(double sizeMegaBytes) {
		this.sizeMegaBytes = sizeMegaBytes;
	}

}
