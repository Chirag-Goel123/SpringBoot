package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;
@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    // private static List<Book> list=new ArrayList<>();
    // static{
    //     list.add(new Book(12,"Java","XYZ"));
    //     list.add(new Book(13,"Python","ABC"));
    //     list.add(new Book(14,"Ruby","DEF"));
    // };

    public List<Book> getAllBook()
    {
        List<Book> list=(List<Book>)this.bookRepository.findAll();
        return list;
    }

    public Book getBookById(int id)
    {
        Book book=null;
        try{
           // book=list.stream().filter(e->e.getId()==id).findFirst().get();
           this.bookRepository.findById(id);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return book;
    }

    // adding a book
    public Book addBook(Book book)
    {
        Book res=this.bookRepository.save(book);
        return res;
    }

    // delete a book
    public void deleteBook(int bookId)
    {
        // Book b=null;
        // for(int i=0;i<list.size();i++)
        // {
        //     if(list.get(i).getId()==bookId)
        //     {
        //         b=list.get(i);
        //         list.remove(i);
        //         break;
        //     }
        // }
        // return b;

       // list=list.stream().filter(book->book.getId()==bookId).collect(Collectors.toList());
       bookRepository.deleteById(bookId);
    }

    // Update a Book
    public void updateBook(Book book,int bid)
    {
        // list=list.stream().map(b->{  
        //     if(b.getId()==bid)
        //     {
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }
        //     return b;
        // }).collect(Collectors.toList());
        book.setId(bid);
        bookRepository.save(book);
    }
}
