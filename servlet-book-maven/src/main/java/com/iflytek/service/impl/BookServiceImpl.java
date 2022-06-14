package com.iflytek.service.impl;



import com.iflytek.dao.BookDao;
import com.iflytek.dao.impl.BookDaoImpl;
import com.iflytek.pojo.Book;
import com.iflytek.service.IBookService;

import java.util.List;

public class BookServiceImpl implements IBookService {

    private BookDao bookDao=new  BookDaoImpl();



    public int queryCountByParam(String bookname, String authorname, String category) {
        return bookDao.findBookCount(bookname,authorname,category);
    }


    @Override
    public List<Book> queryByParam(int page, int limit, String bookname, String authorname, String category) {
        int  start=limit * (page - 1);
        return bookDao.findBookList(start,limit,bookname,authorname,category);
    }


    public int insert(Book book) {
        return 0;
    }
}
