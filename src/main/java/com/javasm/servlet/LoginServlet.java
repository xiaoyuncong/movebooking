package com.javasm.servlet;

import com.javasm.pojo.Users;
import com.javasm.service.UserService;
import com.javasm.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/9/20-20:48
 * @Since：jdk1.8
 * @Description：
 */
@WebServlet("/loginServlet")

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("userName");
        String password = request.getParameter("pwd");
        Users login = userService.login(name, password);

        if (login != null) {
            HttpSession session = request.getSession();

            session.setAttribute("name", name);
//            request.getRequestDispatcher("/selectAllServlet").forward(request, response);
             response.sendRedirect("/move.html");
//            response.getWriter().write("登录成功");

        } else {
            response.getWriter().write("账号或者密码错误");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
