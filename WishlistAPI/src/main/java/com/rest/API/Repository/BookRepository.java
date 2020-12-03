package com.rest.API.Repository;

import com.rest.API.Model.Book;
import com.rest.API.Model.WishListItems;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@Query("select wishlistitems from Book x where x.book_id = ?1")
	List<WishListItems> getItemsByBook(Integer book_id);

}
