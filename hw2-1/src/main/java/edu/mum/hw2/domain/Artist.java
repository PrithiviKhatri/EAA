package edu.mum.hw2.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Artist {

	String name;

	String rating;
	String character;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}

}
