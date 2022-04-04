package com.api.book.bootrestbook.controller;
import java.util.List;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.service.BookServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController   //RestController: RestController is used for making restful web services with the help of the @RestController annotation. This annotation is used at the class level and allows the class to handle the requests made by the client.
public class BookController{
    @Autowired
   private  BookServices bookservices;
   
   // @RequestMapping(value="/books",method= RequestMethod.GET)
   
     @GetMapping("/books")
     public List<Book> getAllBookss()
      {
         return this.bookservices.getAllBooks();
      }

      @GetMapping("/books/{id}")
      public Book getById(@PathVariable("id") int id)
      {
          return this.bookservices.getBookById(id);
      }
         @PostMapping("/books")
        public Book addBook(@RequestBody Book book)
       {
            Book b1=this.bookservices.addBook(book);
            return b1;
         
      }
         @DeleteMapping("/books/{id}")
        public int DeleteBook(@PathVariable("id") int id)
         {
            this.bookservices.delBook(id);
           return id;
           
        }
        @PutMapping("/books/{id}")
         public Book UpdateBooks(@RequestBody Book book,@PathVariable("id") int id)
           {
               this.bookservices.UpdateBook(book, id);
              return book;
          }

}

//The @PathVariable annotation is used to extract the value from the URI.
// It is most suitable for the RESTful web service where the URL contains 
//some value. Spring MVC allows us to use multiple @PathVariable annotations 
//in the same method. A path variable is a critical part of creating rest 
//resources.
