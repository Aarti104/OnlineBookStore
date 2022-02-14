package com.cg.bookstore.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Book {
	@Id
	@SequenceGenerator(name="mybooklogic",initialValue=1000,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="mybooklogic")
	private int bookId;
	private String bookname;
	private String category;
	private String isbn;
	private int bookPrice;
	private LocalDate publishDate;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="Customer_Book_Info",
			joinColumns=@JoinColumn(name="bookdetails"),
			inverseJoinColumns=@JoinColumn(name="customerdetails"))
	private List<Customer> customers;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(int bookId, String bookname, String category, String isbn, int bookPrice, LocalDate publishDate,
			List<Customer> customers) {
		super();
		this.bookId = bookId;
		this.bookname = bookname;
		this.category = category;
		this.isbn = isbn;
		this.bookPrice = bookPrice;
		this.publishDate = publishDate;
		this.customers = customers;
	}

	public int getBookId() {
		return bookId;
	}
	public void setBookid(int bookId) {
		this.bookId = bookId;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
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
		result = prime * result + bookPrice;
		result = prime * result + bookId;
		result = prime * result + ((bookname == null) ? 0 : bookname.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((publishDate == null) ? 0 : publishDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
		if (bookPrice != other.bookPrice)
			return false;
		if (bookId != other.bookId)
			return false;
		if (bookname == null) {
			if (other.bookname != null)
				return false;
		} else if (!bookname.equals(other.bookname))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (publishDate == null) {
			if (other.publishDate != null)
				return false;
		} else if (!publishDate.equals(other.publishDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookname=" + bookname + ", category=" + category + ", isbn=" + isbn
				+ ", bookPrice=" + bookPrice + ", publishDate=" + publishDate + "]";
	}
	
	
	

}
