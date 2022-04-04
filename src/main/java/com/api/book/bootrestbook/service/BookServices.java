package com.api.book.bootrestbook.service;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public  class BookServices {
    @Autowired
    private BookRepository bookRepository;
    //private static List<Book> list= new ArrayList<>();
// static{
    
//     list.add(new Book(1,"HTML","hary"));
//     list.add(new Book(2,"CSS","Roy"));
//     list.add(new Book(6,"JS","Jack"));
//     list.add(new Book(7,"JS","Jack"));
// }

public List<Book> getAllBooks() 
   {
        
       List<Book> li=(List<Book>) this.bookRepository.findAll();
       return li; 
   }

    public Book getBookById(int id)
      {
          Book book=null;
        //z book=list.stream().filter(e-> e.getId()==id).findFirst().get();
          book=this.bookRepository.findById(id);
         return book;
   }
      public Book addBook(Book b)
     {
          //list.add(b);
         Book b1=this.bookRepository.save(b);
         return b1;
           
       }
       
        public int delBook(int id)
        {
      //  list= list.stream().filter(boo->boo.getId()!=id).
      //    collect(Collectors.toList());
         this.bookRepository.deleteById(id);
         return id;
        
       }
       public void UpdateBook(Book book,int id)
         {
      //      list=list.stream().map(bb->{
      //        if(bb.getId()==id)
      //          {
      //              bb.setAuthor(book.getAuthor());
      //              bb.setTitle(book.getTitle());
      //          }
      //          return bb;
      //   }).collect(Collectors.toList());
            book.setId(id);
             this.bookRepository.save(book);
         }
}
