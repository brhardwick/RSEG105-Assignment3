package rseg105.project3.part1.domain;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * 1. Entity class using standard JPA annotations.
 * A new transient property  called birthDateString is added, which will 
 * be used for front-end presentation later.
 * For the "photo" attribute, we use a byte array as the Java data type, 
 * which corresponds to the BLOB data type in the RDBMS. In addition, the
 *  getter method is annotated with @Lob (indicates to the JPA provider that 
 *  it’s a large object column),and @Basic(fetch=FetchType.LAZY) that improves 
 *  performance.
 */

import java.io.Serializable;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
public class Book implements Serializable {
    
    private String category_name;
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


    // @NotEmpty(message="{validation.isbn.NotEmpty.message}")
    // @Size(min=3, max=60, message="{validation.isbn.Size.message}")
    // @Column(name = "ISBN")
    // public String getFirstName() {
    //     return firstName;
    // }

    // public void setFirstName(String firstName) {
    //     this.firstName = firstName;
    // }

    // @NotEmpty(message="{validation.lastname.NotEmpty.message}")
    // @Size(min=1, max=40, message="{validation.lastname.Size.message}")
    // @Column(name = "LAST_NAME")
    // public String getLastName() {
    //     return lastName;
    // }

    // public void setLastName(String lastName) {
    //     this.lastName = lastName;
    // }

    // @Column(name = "BIRTH_DATE")
    // @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    // @DateTimeFormat(iso=ISO.DATE)
    // public DateTime getBirthDate() {
    //     return birthDate;
    // }

    // public void setBirthDate(DateTime birthDate) {
    //     this.birthDate = birthDate;
    // }

    // @Column(name = "DESCRIPTION")
    // public String getDescription() {
    //     return description;
    // }

    // public void setDescription(String description) {
    //     this.description = description;
    // }

    // @Basic(fetch= FetchType.LAZY)
    // @Lob
    // @Column(name = "PHOTO")
    // public byte[] getPhoto() {
    //     return photo;
    // }

    // public void setPhoto(byte[] photo) {
    //     this.photo = photo;
    // }

    // @Transient
    // public String getBirthDateString() {
    //     String birthDateString = "";
    //     if (birthDate != null)
    //         birthDateString = org.joda.time.format.DateTimeFormat
    //                 .forPattern("yyyy-MM-dd").print(birthDate);
    //     return birthDateString;
    // }

    @Override
    public String toString() {
        return "Book - Id: " + id;
    }

    @NotEmpty(message="{errors.ISBN.NotEmpty}")
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

    @NotEmpty(message="{errors.Category.NotEmpty}")
	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
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
