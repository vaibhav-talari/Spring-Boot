package spring.core.boot.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "Books")
public class Book {

	@Id
	@NotNull(message="ID Cannot be Null")
	@Min(value=1,message="ID Cannot be Zero")
	@Column(name = "bookid")
	private long bookid;
	
	@NotEmpty(message="Title Cannot be Blank")
	@Column(name = "booktitle")
	private String title;
	
	@NotNull(message="Price Cannot be Null")
	@Min(value=1,message="Price cannot be less than Zero")
	@Column(name = "bookprice")
	private double price;
	
	@NotNull(message="Volume Cannot be Null")
	@Min(value=1,message="Volume Cannot be less than 1")
	@Column(name = "bookvolume")
	private int volume;
	
	@Past
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name = "bookpublishdate")
	private LocalDate publishDate;

	public Book() {
	}

	public Book(long bookid, String title, double price, int volume, LocalDate publishDate) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.publishDate = publishDate;
	}
	
	/*public Book(String title)
	{
		setBookid(10501);
		setTitle(title);
		setPrice(589);
		setVolume(6);
		setPublishDate(LocalDate.now().minusDays(2));
	}*/

	public long getBookid() {
		return bookid;
	}

	public void setBookid(long bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (bookid ^ (bookid >>> 32));
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((publishDate == null) ? 0 : publishDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + volume;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookid != other.bookid)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (publishDate == null) {
			if (other.publishDate != null)
				return false;
		} else if (!publishDate.equals(other.publishDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (volume != other.volume)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + ", price=" + price + ", volume=" + volume
				+ ", publishDate=" + publishDate + "]";
	}
	
	
}
