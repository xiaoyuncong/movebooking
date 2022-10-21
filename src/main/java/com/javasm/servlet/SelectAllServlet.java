package com.javasm.servlet;

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
 * @Date：2022/9/20-21:15
 * @Since：jdk1.8
 * @Description：
 */
@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private MovingService movingService =new MovingServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<MovingBooking> movingBookings = movingService.selectAllMoveBooking();
//        request.setAttribute("moveInfo",movingBookings);
        String page = request.getParameter("page");
        int pageNo = page==null?1:Integer.parseInt(page);
        Pager<MovingBooking> byPager = movingService.findByPager(pageNo, 2);
        request.setAttribute("byPager",byPager);
        request.setAttribute("moveInfo",byPager.getRows());
        request.getRequestDispatcher("/showMoveInfo.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
