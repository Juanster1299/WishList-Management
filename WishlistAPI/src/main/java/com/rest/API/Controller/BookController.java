package com.rest.API.Controller;

import com.rest.API.Model.Book;
import com.rest.API.Model.WishListItems;
import com.rest.API.Repository.BookRepository;
import com.rest.API.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    // display list of books
    @GetMapping("/list")
    public String viewHomePage(Model model) {
        return findPaginated(1, "title", "asc", model);
    }

    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model) {
        // create model attribute to bind form data
        Book book = new Book();
        model.addAttribute("book", book);
        return "new_book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        // save Book to database
        bookService.saveBook(book);
        return "redirect:/book/list";
    }

    @GetMapping("/showUpdateBookForm/{book_id}")
    public String showUpdateBookForm(@PathVariable ( value = "book_id") int book_id, Model model) {

        // get author from the service
        Book book = bookService.getBookById(book_id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("book", book);
        return "update_book";
    }

    @GetMapping("/deleteBook/{book_id}")
    public String deleteBook(@PathVariable (value = "book_id") int book_id) {

        // call delete book method
        this.bookService.deleteBookById(book_id);
        return "redirect:/book/list";
    }
    
  //GET  ITEMS BY book_id
    @GetMapping("/{book_id}/wishlistitems")
    public String getItemsByBook (@PathVariable("book_id") int book_id, Model model) {
        List<WishListItems> wishlistitems = (List<WishListItems>) bookRepository.getItemsByBook(book_id);
        model.addAttribute("books", wishlistitems);
        return "book_items_id";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Book> page = bookService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Book> listBooks= page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listBooks", listBooks);
        return "book_index";
    }
}
/*public class BookController {
    @Autowired
    private BookRepository bookRepository;

    // Get All Books
    @GetMapping("/list")
    private String getAllBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "book_list";
    }

    // Get Book by ID
    @GetMapping(path = {"/add", "edit/{book_id}"})
    private String getBookById(@PathVariable("book_id") Optional<Long> book_id, Model model){
        if(book_id.isPresent()){
            model.addAttribute("book", bookRepository.findById(book_id.get()));
        }else{
            model.addAttribute("book", new Book());
        }
        return "add_edit_book";
    }

    // Create a Book
    @PostMapping("/addEditBook")
    private String insertOrUpdateBook(Book book){
        if(book.getBook_id() == null){
            bookRepository.save(book);
        }else{
            Optional<Book> bookOptional = bookRepository.findById(book.getBook_id());
            if(bookOptional.isPresent()){
                Book editBook = bookOptional.get();

                editBook.setPrice(book.getPrice());
                editBook.setIsbn(book.getIsbn());
                editBook.setTitle(book.getTitle());
                editBook.setCover(book.getCover());
                editBook.setGenre_name(book.getGenre_name());
                editBook.setDate_published(book.getDate_published());
                editBook.setPublisher_name(book.getPublisher_name());
                editBook.setSummary(book.getSummary());
                editBook.setBook_sells(book.getBook_sells());
                editBook.setAuthor(book.getAuthor());
                bookRepository.save(editBook);
            }
        }
        return "redirect:/book/list";
    }

    // Delete Book by Id
    @GetMapping("/delete/{book_id}")
    private String deleteBook(@PathVariable("book_id") Long book_id){
        Optional<Book> book = bookRepository.findById(book_id);
        if(book.isPresent()){
            bookRepository.delete(book.get());
        }else{
            System.err.println("not found");
        }
        return "redirect:/book/list";
    }
}*/
