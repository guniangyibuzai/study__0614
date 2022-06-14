package com.iflytek.servlet;

import com.alibaba.fastjson.JSONObject;
import com.iflytek.pojo.Book;
import com.iflytek.service.IBookService;
import com.iflytek.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@WebServlet("/request/book/*")
public class BookServlet extends HttpServlet {

     private IBookService IBookService=new  BookServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取请求地址
        String url=request.getRequestURI();
        //获取请求地址最后一个/后面的标识
        String op= url.substring(url.lastIndexOf("/")+1);

        if("all".equals(op)){
            /* 获取查询条件*/
            String bookname = request.getParameter("bookname");
            String authorname = request.getParameter("authorname");
            String category = request.getParameter("category");

            /* 获取分页参数*/
            Integer page = Integer.valueOf(request.getParameter("page"));// 当前页
            Integer limit = Integer.valueOf(request.getParameter("limit"));// 每页几条

            /*查询总条数*/
            int count =  IBookService.queryCountByParam(bookname, authorname, category);
            /*分页查询*/
            List<Book> books = IBookService.queryByParam(page, limit,bookname, authorname, category);

// 按照LayUI表格数据格式传递结果数据
            HashMap<Object, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", count);
            map.put("data", books);

            PrintWriter out=  response.getWriter();
            String json= JSONObject.toJSONString(map);
            out.print(json.toString());
            out.flush();
            out.close();
        }



    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
