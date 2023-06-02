package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;
@Component
public class BookService {
    
    private static List<Book> list=new ArrayList<>();
    static{
        list.add(new Book(12,"Java","XYZ"));
        list.add(new Book(13,"Python","ABC"));
        list.add(new Book(14,"Ruby","DEF"));
    };

    public List<Book> getAllBook()
    {
        return list;
    }

    public Book getBookById(int id)
    {
        Book book=null;
        book=list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }
}
