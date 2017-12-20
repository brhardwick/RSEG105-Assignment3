package rseg105.project3.part2.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

//The naming of this table will be used throughout access in beans and jsp pages. 
//It is case sensitive
@Entity
@Table(name = "book")
public class Book implements Serializable {
    
    private String category;
    private String isbn;
    private String title;

    private String publisher;
    private double price;
	private Long id;


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book - {Id: " + id + ", Title: " +title+ " ISBN: " + isbn + ", Category: " + category + ", Publisher: " + publisher + ", Price: " + price+ "} ";
    }

    @NotEmpty(message="{errors.ISBN.NotEmpty}")
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	//This is renamed from CATEGORY_NAME (in the database) to Category to resolve naming issues in jquery
    @Column(name = "CATEGORY_NAME")
    @NotEmpty(message="{errors.Category.NotEmpty}")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
    }
    
    @NotEmpty(message="{errors.Title.NotEmpty}")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
