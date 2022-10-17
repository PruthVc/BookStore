package com.fdmgroup.bookstore.model;

import java.util.Objects;

public class AudioBook extends Book{
private int timeLengthSeconds;
	
	public AudioBook() {
		super(); 
	}
	
	@Override
	public String toString() {
		return "AudioBook [timeLengthSeconds=" + timeLengthSeconds + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(timeLengthSeconds);
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
		AudioBook other = (AudioBook) obj;
		return timeLengthSeconds == other.timeLengthSeconds;
	}

	public AudioBook(int itemId,double price, String tittle, String author,BookGenre bookGenre,int timeLength) {
		super(itemId, price, tittle, author, bookGenre);
		this.timeLengthSeconds = timeLength;
	}

	public int getTimeLengthSeconds() {
		return timeLengthSeconds;
	}

	public void setTimeLengthSeconds(int timeLengthSeconds) {
		this.timeLengthSeconds = timeLengthSeconds;
	}
}
