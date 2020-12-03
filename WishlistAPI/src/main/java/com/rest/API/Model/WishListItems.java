package com.rest.API.Model;


import javax.persistence.*;

@Entity
@Table(name = "wishlistitems")
public class WishListItems {

	@Id
	@Column(name = "Wishlistitemid")
	private int wishlistitemID;
	
    
	@ManyToOne
	@JoinColumn(name = "Bookid", nullable=false)
		private Book book;
	
    public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	@ManyToOne
	@JoinColumn(name = "Wishlistid", nullable=false)
		private WishList wishlist;
	
    public WishList getWishlist() {
		return wishlist;
	}
	public void setWishlist(WishList wishlist) {
		this.wishlist = wishlist;
	}
	

	public WishListItems() {
		super();
	}
	public WishListItems (int wishlistitemID, int bookID) {
	super();
	this.wishlistitemID = wishlistitemID;

	
}

public int getWishlistitemID() {
		return this.wishlistitemID;
	}
	public void setWishlistitemID(int wishlistitemID) {
		this.wishlistitemID = wishlistitemID;
	}
	
	
}
