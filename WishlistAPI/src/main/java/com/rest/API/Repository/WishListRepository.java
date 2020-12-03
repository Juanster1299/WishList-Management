package com.rest.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rest.API.Model.WishList;
import com.rest.API.Model.WishListItems;

import java.util.*;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer>{

	@Query("select wishlistitems from WishList x where x.wishlistID = ?1")
	List<WishListItems> getItemsByWishList(Integer wishlistID);

}
