package com.rest.API.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rest.API.Exception.WishListNotFoundException;
import com.rest.API.Model.WishListItems;
import com.rest.API.Model.WishList;


@Repository
public interface WishListItemsRepository extends JpaRepository<WishListItems, Integer>{

	
}
