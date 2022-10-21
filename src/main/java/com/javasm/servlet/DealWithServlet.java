package com.javasm.servlet;

import com.javasm.service.MovingService;
import com.javasm.service.impl.MovingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/9/21-14:54
 * @Since：jdk1.8
 * @Description：
 */
@WebServlet("/dealServlet")
public class DealWithServlet extends HttpServlet {
    private MovingService movingService = new MovingServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int i = Integer.parseInt(id);
        int i1 = movingService.updateStatus(i);

        if(i1>0){
            response.sendRedirect("/selectAllServlet");
        }
    }
}
