package com.shop.orderservice.manage.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 李浩
 * @date 2017/11/30
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
