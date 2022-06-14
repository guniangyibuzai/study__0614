package com.iflytek.servlet;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/*")
public class UserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取请求地址
        String url=request.getRequestURI();
        //获取请求地址最后一个/后面的标识
        String op= url.substring(url.lastIndexOf("/")+1);

        if("test".equals(op)){
            PrintWriter out=  response.getWriter();
            Object parse = JSONObject.parse("{test:'测试成功'}");
            out.print(parse.toString());
            out.flush();
            out.close();
        }



    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
