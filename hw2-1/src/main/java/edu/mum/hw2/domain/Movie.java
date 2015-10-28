package edu.mum.hw2.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id
	@GeneratedValue
	Long Id;
	String name;
	String rating;
	
	@Embedded
	@ElementCollection
	List<Artist> artists;

	@ElementCollection
	List<String> comments;
	@ElementCollection
	Set<String> categories;
	Byte[] cover;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
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
	public List<Artist> getArtists() {
		return artists;
	}
	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}
	public List<String> getComments() {
		return comments;
	}
	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	public Set<String> getCategories() {
		return categories;
	}
	public void setCategories(Set<String> categories) {
		this.categories = categories;
	}
	public Byte[] getCover() {
		return cover;
	}
	public void setCover(Byte[] cover) {
		this.cover = cover;
	}

}
