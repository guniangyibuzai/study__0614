package com.iflytek.dao;

import com.iflytek.pojo.Book;

import java.util.List;

public interface BookDao {


    int findBookCount(String bookname, String authorname, String category);

    List<Book> findBookList(int start, int limit, String bookname, String authorname, String category);
}
