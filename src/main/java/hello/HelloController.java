package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/book")
public class HelloController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String add(String name , String author , String description) {
        Book book = null;

        try {
            book = new Book(name , author , description);
            bookRepository.save(book);
        }catch (Exception e) {
            return "Error adding the book";
        }
        return "Book added successfully";
    }

    @RequestMapping(value = "/{id}" ,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Book getById(@PathVariable("id") long id){
        return bookRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Book> getAll(){
        return bookRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(long id , String name , String author , String description) {
        Book book = null;

        try {
            book = bookRepository.findOne(id);
            if(book == null) {
                book = new Book(name, author, description);
            }else {
                book.setName(name);
                book.setAuthor(author);
                book.setDescription(description);
            }
            bookRepository.save(book);
        }catch (Exception e) {
            return "Error updating the book";
        }
        return "Book updated successfully";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(long id){
        try {
            Book book = bookRepository.findOne(id);
            if(book != null) {
                bookRepository.delete(id);
                return "Book deleted successfully";
            }
        }catch (Exception e) {
            return "Error deleting the book";
        }
        return "Invalid Book id";
    }
}