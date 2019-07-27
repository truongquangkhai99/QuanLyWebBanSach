package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
	private SimpleIntegerProperty id;
	private SimpleStringProperty title;
	private SimpleStringProperty category;
	private SimpleStringProperty decription;
	private SimpleStringProperty author;
	private SimpleStringProperty publisherDate;
	private SimpleStringProperty publisher;
	private SimpleDoubleProperty price;
	
	public Book() {
		this.id = new SimpleIntegerProperty();
		this.title = new SimpleStringProperty();
		this.category = new SimpleStringProperty();
		this.decription = new SimpleStringProperty();
		this.author = new SimpleStringProperty();
		this.publisherDate = new SimpleStringProperty();
		this.publisher = new SimpleStringProperty();
		this.price = new SimpleDoubleProperty();
		
	}

	public Book(Integer id, String title, String category, String decription, String author, String publisherDate,
			String publisher, Double price) {
		this.id = new SimpleIntegerProperty(id);
		this.title = new SimpleStringProperty(title);
		this.category = new SimpleStringProperty(category);
		this.decription = new SimpleStringProperty(decription);
		this.author = new SimpleStringProperty(author);
		this.publisherDate = new SimpleStringProperty(publisherDate);
		this.publisher = new SimpleStringProperty(publisher);
		this.price = new SimpleDoubleProperty(price);
		
	}

	public Integer getId() {
		return this.id.get();
	}

	public void setId(Integer id) {
		this.id.set(id);
	}
	
	public String getTitle() {
		return this.title.get();
	}
	public void setTitle(String title) {
		this.title.set(title);
	}
	
	public String getCategory() {
		return this.category.get();
	}
	public void setCategory(String category) {
		this.category.set(category);
	}
	
	public String getDecription() {
		return this.decription.get();
	}
	public void setDecription(String decription) {
		this.decription.set(decription);
	}
	
	public String getAuthor() {
		return this.author.get();
	}
	public void setAuthor(String author) {
		this.author.set(author);
	}
	
	public String getPublisherDate() {
		return this.publisherDate.get();
	}
	public void setPublisherDate(String publisherDate) {
		this.publisherDate.set(publisherDate);
	}
	
	public String getPublisher() {
		return this.publisher.get();
	}
	public void setPublisher(String publisher) {
		this.publisher.set(publisher);
	}
	
	public double getPrice() {
		return this.price.get();
	}
	public void setPrice(double price) {
		this.price.set(price);
	}
	
	

}
