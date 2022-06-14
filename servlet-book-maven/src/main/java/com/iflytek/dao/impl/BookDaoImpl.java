package com.iflytek.dao.impl;

import com.iflytek.dao.BookDao;
import com.iflytek.pojo.Book;
import com.iflytek.utils.JDBCUtil;
import com.mysql.jdbc.StringUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());



    @Override
    public int findBookCount(String bookname, String authorname, String category) {
        ArrayList<Object> objects = new ArrayList<>();
        String sql ="select count(1) from book where 1=1 ";

        if(!StringUtils.isNullOrEmpty(bookname)){
            sql += "and name LIKE ?";
            objects.add("%" + bookname + "%");
        }
        if (!StringUtils.isNullOrEmpty(authorname)){
            sql += "and author = ?";
            objects.add(authorname);
        }
        if (!StringUtils.isNullOrEmpty(category)){
            sql += " and category = ?";
            objects.add(category);
        }
        Long query =0l;

        try {
             query = runner.query(sql, new ScalarHandler<Long>(), objects.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return query.intValue();
    }

    @Override
    public List<Book> findBookList(int start, int limit, String bookname, String authorname, String category) {

        ArrayList<Object> objects = new ArrayList<>();
        String sql ="select * from book where 1=1 ";

        if(!StringUtils.isNullOrEmpty(bookname)){
            sql += "and name LIKE ?";
            objects.add("%" + bookname + "%");
        }
        if (!StringUtils.isNullOrEmpty(authorname)){
            sql += "and author = ?";
            objects.add(authorname);
        }
        if (!StringUtils.isNullOrEmpty(category)){
            sql += " and category = ?";
            objects.add(category);
        }

        sql+=" limit ?,?";
        objects.add(start);
        objects.add(limit);

        List<Book> query=null;

        try {
             query = runner.query(sql, new BeanListHandler<>(Book.class), objects.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return query;
    }
}
