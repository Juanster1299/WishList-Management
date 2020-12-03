package com.rest.API.Exception;

public class WishListItemNotFoundException extends Exception {
	private int wishlistitemID;
	public WishListItemNotFoundException(int wishlistitemID) {
		super(String.format("WishListItem not found wiht wishlistitemID: '%s", wishlistitemID));
	}

}
