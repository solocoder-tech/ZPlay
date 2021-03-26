package com.example.aidlserver;

import com.example.aidlserver.Book;

interface IMyAidlInterface {
   String getName();

   void addBook(in Book book);

   List<Book> getBooks();
}
