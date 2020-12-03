package com.rest.API.Service;

import com.rest.API.Model.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    void saveBook(Book book);
    Book getBookById(int book_id);
    void deleteBookById(int book_id);
    Page<Book> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}

