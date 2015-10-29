package edu.mum.hw2.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Artist {

	String name;

	String rating;

	@Column(name="c")
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
	@Override
	public String toString() {
		return "Artist [name=" + name + ", rating=" + rating + ", character=" + character + "]";
	}

}
