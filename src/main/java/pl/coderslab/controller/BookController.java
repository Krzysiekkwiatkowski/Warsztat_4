package pl.coderslab.controller;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private MemoryBookService memoryBookService;

    @Autowired
    public void setMemoryBookService(MemoryBookService memoryBookService){
        this.memoryBookService = memoryBookService;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @RequestMapping("/")
    public List<Book> getBooks(){
        return memoryBookService.getList();
    }

    @RequestMapping("/{id}")
    public Book getBook(@PathVariable("id") Long id){
        return memoryBookService.getBook(id);
    }

    @GetMapping("/add")
    @ResponseBody
    public String form(){
        return "Add Book\n" +
                "<form action=\"/books/\" method=\"post\">\n" +
                "    Id: <input type=\"number\" name=\"id\"></br>\n" +
                "    Isbn: <input type=\"text\" name=\"isbn\"></br>\n" +
                "    Title: <input type=\"text\" name=\"title\"></br>\n" +
                "    Author: <input type=\"text\" name=\"author\"></br>\n" +
                "    Publisher: <input type=\"text\" name=\"publisher\"></br>\n" +
                "    Type: <input type=\"text\" name=\"type\"></br>\n" +
                "    <input type=\"submit\" value=\"Add\">\n" +
                "</form>";
    }

    @PostMapping(value = "/")
    public Book addBook(@RequestBody Book book){
        return memoryBookService.addBook(book);
    }
}
