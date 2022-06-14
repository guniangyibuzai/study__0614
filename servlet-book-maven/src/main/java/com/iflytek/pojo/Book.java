package com.iflytek.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class Book {
    private Integer id; // 编号，唯一
    private String name; // 书名
    private float price; // 价格
    private String author; // 作者
    private String category; // 分类
    private String publisher; // 出版社
    private Date publishdate; // 出版日期
    private int count; // 数量
    private String cover; // 封面
}
