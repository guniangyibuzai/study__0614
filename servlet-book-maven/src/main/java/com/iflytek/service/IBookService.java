package com.iflytek.service;



import com.iflytek.pojo.Book;

import java.util.List;

public interface IBookService {
    int queryCountByParam(String bookname, String authorname, String category);

    List<Book> queryByParam(int page, int limit, String bookname, String authorname, String category);

    int insert(Book book);
}
