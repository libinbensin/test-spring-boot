package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/{id}" ,
            method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody Book bookRequest) {
        Book book = null;

        try {
            book = new Book(bookRequest.getName() , bookRequest.getAuthor() , bookRequest.getDescription());
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

    @RequestMapping(value = "/{id}" ,
            method = RequestMethod.PUT)
    public String update(@PathVariable("id") long id , @RequestBody Book bookRequest) {
        Book book;

        try {
            book = bookRepository.findOne(id);
            if(book == null) {
                book = bookRequest;
            }else {
                book.setName(bookRequest.getName());
                book.setAuthor(bookRequest.getAuthor());
                book.setDescription(bookRequest.getDescription());
            }
            bookRepository.save(book);
        }catch (Exception e) {
            return "Error updating the book";
        }
        return "Book updated successfully";
    }

    @RequestMapping(value = "/{id}" ,
            method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") long id){
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