package com.javasm.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/9/20-20:55
 * @Since：jdk1.8
 * @Description：
 */
@WebFilter(filterName = "EncodeFilter")
public class EncodeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

            req =(HttpServletRequest)req;
            resp=(HttpServletResponse)resp;
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("老板是傻逼");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
