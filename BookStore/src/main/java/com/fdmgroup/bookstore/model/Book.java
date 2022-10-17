package com.fdmgroup.bookstore.model;

import java.util.Objects;

public class Book {
	private int itemId;
	private double price;
	private String tittle;
	private String author;
	private BookGenre bookGenre;
	
	public Book() {
		 
	}
	public Book(int itemId,double price, String tittle, String author,BookGenre bookGenre) {
		this.itemId = itemId;
		this.price = price;
		this.tittle = tittle;
		this.author = author;
		this.bookGenre = bookGenre;
	}
	
	
	@Override
	public String toString() {
		return "Book [itemId=" + itemId + ", price=" + price + ", tittle=" + tittle + ", author=" + author
				+ ", bookGenre=" + bookGenre + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(author, bookGenre, itemId, price, tittle);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && bookGenre == other.bookGenre && itemId == other.itemId
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(tittle, other.tittle);
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getAuthor() {
		return author;
	} 
	public void setAuthor(String author) {
		this.author = author;
	}
	public BookGenre getBookGenre() {
		return bookGenre;
	}
	public void setBookGenre(BookGenre bookGenre) {
		this.bookGenre = bookGenre;
	}
}
