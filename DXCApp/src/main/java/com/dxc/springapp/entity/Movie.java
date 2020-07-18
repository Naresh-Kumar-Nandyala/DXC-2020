package com.dxc.springapp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movieinfo")
public class Movie {

	@Column(name = "movieid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "moviename", nullable = true, length = 255)
	private String name;

	@Column(name = "movierating", nullable = true, length = 255)
	private Integer rating;

	@Column(name = "moviecategory", nullable = true, length = 255)
	private String category;

	@Column(name = "movietype", nullable = true, length = 255)
	private String type;
	
	@Column(name = "movieduration", nullable = true, length = 5)
	private Double duration;

	public Movie() {
		super();
	}

	public Movie(Integer id, String name, Integer rating, String category, String type, Double duration) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.category=category;
		this.type = type;
		this.duration = duration;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public String toString() {
		return "Movie\n{\nid: " + id + "\nname: " + name + "\nrating: " + rating +
				"\ncategory: " + category + "\ntype: "+ type + "\nduration"+ duration +"}";
	}
}
