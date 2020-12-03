package com.rest.API.Model;


import javax.persistence.*;

import org.hibernate.criterion.Restrictions;

import java.util.*;

@Entity
@Table(name = "wishlist")
public class WishList {
	

	@Id
	@Column(name = "Wishlistid")
	private int wishlistID;

	@Column(name = "Userid")
	private int userID;
	
	@Column(name = "Wishlistindex")
	private int wishlistindex;
	
	@Column(name = "Wishlistname")
	private String wishlistname;
	
	@OneToMany(mappedBy = "wishlist")
	private List <WishListItems> wishlistitems;
	
	
	public WishList(){
        super();
    }
public WishList(int wishlistID, int userID, int wishlistindex, String wishlistname) {
        super();
        this.wishlistID = wishlistID;
        this.userID = userID;
        this.wishlistindex = wishlistindex;
        this.wishlistname= wishlistname;
}
        

	public int getWishlistID() {
		return wishlistID;
	}
	
	public void setWishlistID(int wishlistID) {
		this.wishlistID = wishlistID;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getWishlistindex() {
		return wishlistindex;
	}
	public void setWishlistindex(int wishlistindex) {
		this.wishlistindex = wishlistindex;
	}
	public String getWishlistname() {
		return wishlistname;
	}
	public void setWishlistname(String wishlistname) {
		this.wishlistname = wishlistname;

	}

}