package com.javasm.servlet;

import com.alibaba.fastjson.JSON;
import com.javasm.pojo.MovingBooking;
import com.javasm.pojo.Pager;
import com.javasm.service.MovingService;
import com.javasm.service.impl.MovingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/9/24-15:52
 * @Since：jdk1.8
 * @Description：
 */
@WebServlet("/ajaxSelectAllServlet")
public class AjaxSelectAllServlet extends HttpServlet {
    private MovingService movingService=new MovingServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        int i = Integer.parseInt(currentPage);
        int i1 = Integer.parseInt(pageSize);
        Pager<MovingBooking> byPager = movingService.findByPager(i, i1);
        String s = JSON.toJSONString(byPager);
        response.getWriter().write(s);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
