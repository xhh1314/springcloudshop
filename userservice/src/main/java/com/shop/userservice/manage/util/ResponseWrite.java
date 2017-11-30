package com.shop.userservice.manage.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lh
 *工具栏，response写入流
 */
public class ResponseWrite {

    public static void write(HttpServletResponse response, String obj) throws IOException {
        response.setHeader("Content-type", "text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.print(obj);
        System.out.println("repsonse返回字符："+obj);
        out.flush();
        out.close();
    }



}