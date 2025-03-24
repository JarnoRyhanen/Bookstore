package home.jarnobookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import home.jarnobookstore.domain.Book;
import home.jarnobookstore.domain.BookRepository;
import home.jarnobookstore.domain.CategoryRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public BookController(BookRepository repository) {
        this.bookRepository = repository;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String requestMethodName(@RequestParam String param) {
        return "index";
    }

    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        /*
         * jdbcTemplate.execute("Drop table book");
         * jdbcTemplate.execute("Drop table category");
         */
        return "booklist";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNewBook(Book book) {
        bookRepository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        bookRepository.deleteById(id);
        return "redirect:../booklist";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", bookRepository.findById(bookId));
        model.addAttribute("categories", categoryRepository.findAll());
        return "editbook";
    }

    // Get all books as JSON RESTful
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) bookRepository.findAll();
    }

    // Find one book by id RESTful
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookByIdRest(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId);
    }

    @RequestMapping("/login")
	public String login() {
		return "login";
	}
    

}
