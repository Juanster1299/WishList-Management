package com.rest.API.Exception;

public class WishListNotFoundException extends Exception{
	private int wishlistID;
	public WishListNotFoundException(int wishlistID) {
		super(String.format("WishList is not found with wishlistID: '%s", wishlistID));
	}

}
