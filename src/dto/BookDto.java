package dto;

import java.sql.Date;

public class BookDto {
	private int id;
	private String title;
	private String category;
	private String decription;
	private String author;
	private Date publisherDate;
	private String publisher;
	private double price;
	
	
	
	public BookDto() {
		
	}
	public BookDto(String title, String category, String decription, String author, Date publisherDate,
			String publisher, double price) {
		
		this.title = title;
		this.category = category;
		this.decription = decription;
		this.author = author;
		this.publisherDate = publisherDate;
		this.publisher = publisher;
		this.price = price;
	}
	public BookDto(int id, String title, String category, String decription, String author, Date publisherDate,
			String publisher, double price) {
		
		this.id = id;
		this.title = title;
		this.category = category;
		this.decription = decription;
		this.author = author;
		this.publisherDate = publisherDate;
		this.publisher = publisher;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPublisherDate() {
		return publisherDate;
	}
	public void setPublisherDate(Date date) {
		this.publisherDate = date;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
