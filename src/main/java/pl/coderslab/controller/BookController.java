package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
