package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService {
    private static List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {return list;}

    public void setList(List<Book> list) {this.list = list;}

    public Book getBook(Long id){
        for (Book book : list) {
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

    public Book addBook(Book book){
        list.add(book);
        System.out.println(list.size());
        return book;
    }

    public void editBook(Book book){
        list.set(Integer.parseInt(book.getId().toString()), book);
    }

    public void deleteBook(int id){
        list.remove(id);
    }
}
