package com.book.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;

	@Column(name="bookName")
	private String bookName;
	
	@Column(name="ImgUrl")
	private String imgUrl;
	
	@Column(name="bookAuthor")
	private String bookAuthor;
	
	@Column(name="feature")
	private Boolean feature;
	
	@Column(name="price")
	private double price;

	public Object getAbout() {
		// TODO Auto-generated method stub
		return null;
	}
}
