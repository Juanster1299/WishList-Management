/*
package com.rest.api.model;


import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long book_id;

    @Column(name = "isbn")
    private String isbn;

    @Column (name = "title")
    private String title;

    @Column (name = "cover")
    private String cover;

    @Column(name = "genre_name")
    private String genre_name;

    @Column (name = "price")
    private double price;

    @Column (name = "date_published")
    private String date_published;

    @Column (name = "publisher_name")
    private String publisher_name;

    @Column (name = "summary")
    private String summary;

    @Column (name = "book_sells")
    private Long book_sells;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable=false)
    private Author author;
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book() {
        super();
    }

    public Book(Long book_id, String isbn, String title, String cover, String genre_name, double price,
                String date_published, String publisher_name, String summary, Long book_sells) {
        this.book_id = book_id;
        this.isbn = isbn;
        this.title = title;
        this.cover = cover;
        this.genre_name = genre_name;
        this.price = price;
        this.date_published = date_published;
        this.publisher_name = publisher_name;
        this.summary = summary;
        this.book_sells = book_sells;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getBook_sells() {
        return book_sells;
    }

    public void setBook_sells(Long book_sells) {
        this.book_sells = book_sells;
    }
}
*/

package com.rest.API.Model;


import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int book_id;

    @Column(name = "isbn")
    private String isbn;

    @Column (name = "title")
    private String title;

    @Column (name = "cover")
    private String cover;

    @Column(name = "genre_name")
    private String genre_name;

    @Column(name = "author_id")
    private String author_id;
    
    @Column (name = "price")
    private double price;

    @Column (name = "date_published")
    private String date_published;

    @Column (name = "publisher_name")
    private String publisher_name;

    @Column (name = "summary")
    private String summary;

    @Column (name = "book_sells")
    private Long book_sells;

	@OneToMany(mappedBy = "book")
	private List <WishListItems> wishlistitems;

    public Book() {
        super();
    }

    public Book(int book_id, String isbn, String title, String cover, String genre_name,String author_id, double price,
                String date_published, String publisher_name, String summary, Long book_sells) {
        this.book_id = book_id;
        this.isbn = isbn;
        this.title = title;
        this.cover = cover;
        this.genre_name = genre_name;
        this.author_id = author_id;
        this.price = price;
        this.date_published = date_published;
        this.publisher_name = publisher_name;
        this.summary = summary;
        this.book_sells = book_sells;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }
    
    public String getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}

	public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getBook_sells() {
        return book_sells;
    }

    public void setBook_sells(Long book_sells) {
        this.book_sells = book_sells;
    }
}
